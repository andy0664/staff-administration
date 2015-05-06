package at.fh.swenga.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import at.fh.swenga.jpa.constant.Constant;
import at.fh.swenga.jpa.dao.SimpleDepartmentRepository;
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleNewsRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dto.DepartmentDTO;
import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.dto.TimeRecordDTO;
import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.News;
import at.fh.swenga.jpa.model.TimeRecord;

@Controller
public class CoverPageController {

	@Autowired
	private SimpleEmployeeRepository employeeDao;

	@Autowired
	private SimpleDepartmentRepository departmentDao;

	@Autowired
	private SimpleTimeRecordRepository timeRecordDao;
	
	@Autowired
	private SimpleNewsRepository newsRepository;

	// For Binding Date and Time
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
	}

	/*
	 * ########### index.jsp ############
	 */

	// Cover Page
	@RequestMapping(value = { "/", "start" })
	public String index(Model model) {
		model.addAttribute(Constant.KEY_NEWS_LIST, newsRepository.findAll());
		return Constant.PAGE_INDEX;
	}

	// From index.jsp manageEmployees
	@RequestMapping(value = { "manageEmployees" })
	public String listAllEmployee(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeByOrderByDepartmentId());
		return Constant.PAGE_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "manageDepartments" })
	public String listAllDepartments(Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
				departmentDao.findAll());
		return Constant.PAGE_MANAGE_DEPARTMENTS;
	}

	@RequestMapping(value = { "newTimeRecord" })
	public String newTimeRecord(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_NEW_TIME_RECORD;
	}

	@RequestMapping(value = { "showTimeRecords" })
	public String showTimeRecords(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_LIST_TIME_RECORDS;
	}

	@RequestMapping(value = { "newNews" })
	public String newNews(@Valid @ModelAttribute News newNews,
			BindingResult bindingResult, Model model) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/start";
		}
		newsRepository.save(newNews);
		return "forward:/start";
	}
	
	@RequestMapping(value={"removeNews"}, method=RequestMethod.GET)
	public String removeNews(@RequestParam int id, Model model){
		try{
			newsRepository.delete(id);
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, "Couldn't delete news");
		}
		return "forward:/start";
	}

	/*
	 * ########### manageEmployees.jsp ############
	 */

	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.GET)
	public String editEmployee(Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
				departmentDao.findAll());
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.GET)
	public String changeEmployee(@RequestParam int id, Model model) {
		try {
			model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
					departmentDao.findAll());
			model.addAttribute(Constant.KEY_EMPLOYEE,
					employeeDao.findEmployeeById(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "deleteEmployee" })
	public String deleteEmployee(@RequestParam int id, Model model) {
		try {
			employeeDao.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"couldn't delete employee");
		}

		return "forward:manageEmployees";
	}

	// Zum füllen der Mitarbeiter Tabelle nur zum testen --> ende entfernen
	@RequestMapping("fillEmployee")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();

		for (int i = 0; i < 10; i++) {
			Address address = new Address(df.getStreetName(), df.getCity(),
					df.getRandomWord(), 8052);
			Employee p1 = new Employee(12345, df.getFirstName(),
					df.getLastName(), df.getBirthDate(), address,
					df.getRandomText(10, 20), 1234.5f, df.getBirthDate(), 1);
			employeeDao.save(p1);
		}
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	/*
	 * ########### editEmployee.jsp ############
	 */

	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute EmployeeDTO newEmployee,
			@Valid @ModelAttribute Address newAddress,
			@RequestParam int department, BindingResult bindingResult,
			Model model) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/manageEmployees";
		}
		newEmployee.setAddress(newAddress);
		Employee emp = newEmployee.generateEmployee();
		saveEmployee(emp, department);
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.POST)
	public String updateEmployee(
			@Valid @ModelAttribute EmployeeDTO newEmployee,
			@Valid @ModelAttribute Address newAddress, @RequestParam int id,
			@RequestParam int department, BindingResult bindingResult,
			Model model) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/manageEmployees";
		}
		Employee emp = employeeDao.findEmployeeById(id);
		newEmployee.setAddress(newAddress);
		emp.updateEmployee(newEmployee);
		saveEmployee(emp, department);
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	/*
	 * ########### manageDepartments.jsp ############
	 */

	@RequestMapping(value = { "deleteDepartment" })
	public String deleteDepartment(@RequestParam int id, Model model) {
		try {
			departmentDao.delete(id);
		} catch (Exception ex) {
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"couldn't delete department");
		}
		return "forward:manageDepartments";
	}

	@RequestMapping(value = { "changeDepartment" }, method = RequestMethod.GET)
	public String editDepartment(@RequestParam int id, Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT,
				departmentDao.findDepartmentById(id));
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeByDepartmentId(id));
		return Constant.PAGE_EDIT_DEPARTMENT;
	}

	@RequestMapping(value = { "addDepartment" }, method = RequestMethod.GET)
	public String addDepartment(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeWithNoDepartment());
		return Constant.PAGE_EDIT_DEPARTMENT;
	}

	// Zum füllen der Mitarbeiter Tabelle nur zum testen --> ende entfernen
	@RequestMapping("fillDepartment")
	@Transactional
	public String fillDepartment(Model model) {

		DataFactory df = new DataFactory();

		for (int i = 0; i < 10; i++) {
			Department dep1 = new Department(df.getName(), df.getRandomText(2,
					5));
			departmentDao.save(dep1);
		}
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	/*
	 * ########### editDepartment.jsp ############
	 */

	@RequestMapping(value = { "changeDepartment" }, method = RequestMethod.POST)
	public String updateDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,
			@RequestParam int id, @RequestParam int manager, Model model,
			BindingResult bindingResult) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/manageDepartments";
		}
		Department dep = departmentDao.findDepartmentById(id);
		dep.updateDepartment(newDepartment);
		if (dep.getManager().getId() != manager) {
			dep.setManager(employeeDao.findEmployeeById(manager));
		}
		departmentDao.save(dep);
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	@RequestMapping(value = { "addDepartment" }, method = RequestMethod.POST)
	public String saveDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,
			@RequestParam int manager, BindingResult bindingResult, Model model) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/manageDepartments";
		}
		Employee emp = employeeDao.findEmployeeById(manager);
		Department dep = newDepartment.generateDepartment();
		emp.setDepartment(dep);
		dep.setManager(emp);
		departmentDao.save(dep);
		employeeDao.save(emp);

		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	/*
	 * ########### editTimeRecord.jsp ############
	 */

	@RequestMapping(value = { "addTimeRecord" }, method = RequestMethod.POST)
	public String addTimeRecord(@Valid @ModelAttribute TimeRecordDTO newRecord,
			@RequestParam int employee, Model model, BindingResult bindingResult) {
		if (checkBinding(bindingResult, model)) {
			return "forward:/start";
		}
		Employee emp = employeeDao.findEmployeeById(employee);
		TimeRecord record = newRecord.generateTimeRecord();
		record.setEmployee(emp);
		timeRecordDao.save(record);
		return Constant.PAGE_INDEX;
	}

	/*
	 * ########### listTimeRecords.jsp ############
	 */
	@RequestMapping(value = { "timeRecordEmployee" })
	public String timeRecordManagerView(@RequestParam int employee, Model model) {
		return prepareTimeRecordManager(employee, model);
	}

	@RequestMapping(value = { "timeRecordEmployeeDelete" })
	public String timeRecordManagerView(@RequestParam int timerecord,
			@RequestParam int id, Model model) {
		return prepareTimeRecordManager(id, model);
	}

	@RequestMapping(value = { "deleteTimeRecord" })
	public String deleteTimeRecord(@RequestParam int timerecord, int id,
			Model model) {
		try {
			timeRecordDao.delete(timerecord);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"Couldn't delete timerecord");
		}
		return "forward:timeRecordEmployeeDelete";
	}

	// @ExceptionHandler(Exception.class)
	// public String handleAllException(Exception ex) {
	// return "showError";
	// }

	private void saveEmployee(Employee emp, int department) {
		if (department != Constant.NO_DEPARTMENT) {
			emp.setDepartment(departmentDao.findDepartmentById(department));
		}
		employeeDao.save(emp);
	}

	private String prepareTimeRecordManager(int employee, Model model) {
		model.addAttribute(Constant.KEY_TIME_RECORD_LIST,
				timeRecordDao.findRecordsByEmployeeId(employee));
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		model.addAttribute(Constant.KEY_EMPLOYEE,
				employeeDao.findEmployeeById(employee));
		return Constant.PAGE_LIST_TIME_RECORDS;
	}

	private boolean checkBinding(BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMessage += error.getField() + " is invalid<br>";
			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, errorMessage);
			return true;
		}
		return false;
	}
}
