package at.fh.swenga.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;

@Controller
public class CoverPageController {

	@Autowired
	private SimpleEmployeeRepository employeeDao;

	@Autowired
	private SimpleDepartmentRepository departmentDao;

	// For Binding Date
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	/*
	 * ########### index.jsp ############
	 */

	// Cover Page
	@RequestMapping(value = { "/", "start" })
	public String index(Model model) {
		return Constant.PAGE_INDEX;
	}

	// From index.jsp manageEmployees
	@RequestMapping(value = { "manageEmployees" })
	public String listAllEmployee(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "manageDepartments" })
	public String listAllDepartments(Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
				departmentDao.findAll());
		return Constant.PAGE_MANAGE_DEPARTMENTS;
	}

	/*
	 * ########### manageEmployees.jsp ############
	 */

	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.GET)
	public String editEmployee(Model model) {
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.GET)
	public String changeEmployee(@RequestParam int id, Model model) {
		try {
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
	public String saveEmployee(@Valid @ModelAttribute Employee newEmployee,
			@Valid @ModelAttribute Address newAddress,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMessage += error.getField() + " is invalid<br>";
			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, errorMessage);
			return "forward:/manageEmployees";
		} else {
			newEmployee.setAddress(newAddress);
			employeeDao.save(newEmployee);
		}
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute Employee newEmployee,
			@Valid @ModelAttribute Address newAddress, @RequestParam int id,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMessage += error.getField() + " is invalid<br>";
			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, errorMessage);
			return "forward:/manageEmployees";
		} else {
			Employee emp = employeeDao.findEmployeeById(id);
			newEmployee.setAddress(newAddress);
			emp.updateEmployee(newEmployee);
			employeeDao.save(emp);
		}
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
		model.addAttribute(Constant.KEY_DEPARTMENT, departmentDao.findDepartmentById(id));
		return Constant.PAGE_EDIT_DEPARTMENT;
	}
	
	@RequestMapping(value={"addDepartment"}, method=RequestMethod.GET)
	public String addDepartment(Model model){
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

	@RequestMapping(value={"changeDepartment"}, method=RequestMethod.POST)
	public String updateDepartment(
			@Valid @ModelAttribute Department newDepartment,
			@RequestParam int id, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMessage += error.getField() + " is invalid<br>";
			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, errorMessage);
			return "forward:/manageDepartments";
		} else {
			Department dep = departmentDao.findDepartmentById(id);
			dep.updateDepartment(newDepartment);
			departmentDao.save(dep);
		}
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}
	
	@RequestMapping(value = { "addDepartment" }, method = RequestMethod.POST)
	public String saveDepartment(@Valid @ModelAttribute Department newDepartment,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMessage += error.getField() + " is invalid<br>";
			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, errorMessage);
			return "forward:/manageDepartments";
		} else {
			departmentDao.save(newDepartment);
		}
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	// @ExceptionHandler(Exception.class)
	// public String handleAllException(Exception ex) {
	// return "showError";
	// }
}
