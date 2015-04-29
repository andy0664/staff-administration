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
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Employee;

@Controller
public class CoverPageController {

	@Autowired
	private SimpleEmployeeRepository employeeDao;

	// For Binding Date
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	// ########### index.jsp ############

	// Cover Page
	@RequestMapping(value = { "/", "start" })
	public String index(Model model) {
		return Constant.PAGE_INDEX;
	}

	// From index.jsp manageEmployees
	@RequestMapping(value = { "manageEmployee" })
	public String listAllEmployee(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "manageDepartment" })
	public String listAllDepartments(Model model) {
		return Constant.PAGE_MANAGE_DEPARTMENTS;
	}

	// ########### manageEmployees.jsp ############

	// From index.jsp add new Department
	@RequestMapping(value = { "addEmployee" })
	public String editEmployee(Model model) {
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "changeEmployee" })
	public String changeEmployee(@RequestParam int id, Model model) {
		try{
			model.addAttribute(Constant.KEY_EMPLOYEE, employeeDao.findEmployeeById(id));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return Constant.PAGE_EDIT_EMPLOYEE;
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
			return "forward:manageEmployee";
		}

	

	// ########### editEmployee.jsp ############
	
	@RequestMapping(value = { "saveEmployee" }, method = RequestMethod.POST)
	@Transactional
	public String saveEmployee(@RequestParam int ssn,
			@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String dayOfBirth, @RequestParam String country,
			@RequestParam String street, @RequestParam String city,
			@RequestParam int zip, @RequestParam String jobDescription,
			@RequestParam float salary, @RequestParam String dayOfEntry,
			@RequestParam int role, Model model) {
		try {
			Address address = new Address(street, city, country, zip);
			Employee employee = new Employee(ssn, firstName, lastName,
					Constant.parseToDate(dayOfBirth), address, jobDescription,
					salary, Constant.parseToDate(dayOfEntry), role);
			employeeDao.save(employee);
			model.addAttribute(Constant.KEY_UPDATE_EMPLOYEE_MESSAGE,
					"Employee added/updated");
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"Couldn't add/change employee");
		}
		return "forward:/manageEmployee";
	}
	
	// From editEmployee.jsp submit button
		// @RequestMapping(value = { "saveEmployee" }, method = RequestMethod.POST)
		// public String saveEmployee(
		// @Valid @ModelAttribute("newEmployee") Employee newEmployee,
		// BindingResult bindingResult, Model model) {
		// if (bindingResult.hasErrors()) {
		// String errorMessage = "";
		// for (FieldError error : bindingResult.getFieldErrors()) {
		// errorMessage += error.getField() + " is invalid<br>";
		// }
		// model.addAttribute(Constant.KEY_ERROR, errorMessage);
		// return "forward:/start";
		// } else {
		// if (newEmployee == null) {
		// System.out.println("Is null##########################");
		// } else {
		// model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
		// employeeDao.save(newEmployee));
		// }
		// }
		// return "forward:/start";
		// }

	

	
	
	
	
	
	
	
	// From index.jsp add new Department
	@RequestMapping(value = { "addDepartment" })
	public String editDepartment(Model model) {
		return Constant.PAGE_EDIT_DEPARTMENT;
	}

	// @ExceptionHandler(Exception.class)
	// public String handleAllException(Exception ex) {
	// return "showError";
	// }
}
