package at.fh.swenga.jpa.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.collections4.map.HashedMap;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import at.fh.swenga.jpa.dao.SimpleAnnouncementRepository;
import at.fh.swenga.jpa.dao.SimpleDepartmentRepository;
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleNewsRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dao.SimpleUserRoleRepository;
import at.fh.swenga.jpa.dto.DepartmentDTO;
import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.dto.TimeRecordDTO;
import at.fh.swenga.jpa.dto.TimeRecordRequestDTO;
import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.News;
import at.fh.swenga.jpa.model.TimeRecord;
import at.fh.swenga.jpa.model.UserRole;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;
import at.fh.swenga.jpa.support.DateTimeEditor;

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

	@Autowired
	private SimpleUserRoleRepository userRoleRepository;

	@Autowired
	private SimpleAnnouncementRepository announcementDao;

	@Autowired
	private ControllerSupport controllerSupport;

	private boolean firstStart = true;

	// For Binding Date and Time
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
	}

	/*
	 * ########### login ############
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLogin() {
		try {
			if (firstStart) {
				DataFactory df = new DataFactory();
				Address address = new Address(df.getStreetName(), df.getCity(),
						df.getRandomWord(), 8052);
				Employee p1 = new Employee(
						12345,
						df.getFirstName(),
						df.getLastName(),
						df.getBirthDate(),
						address,
						df.getRandomText(10, 20),
						1234.5f,
						df.getBirthDate(),
						"admin",
						"$2a$04$vr5j3pjvADh5r0zX0zfIreLKVP7.Xbq1JhHozBhlGnBeHg.RdE/fC",
						"admin@gmx.at", "+43 1234567");
				Employee p2 = new Employee(
						123456,
						df.getFirstName(),
						df.getLastName(),
						df.getBirthDate(),
						address,
						df.getRandomText(10, 20),
						1234.5f,
						df.getBirthDate(),
						"manager",
						"$2a$04$vr5j3pjvADh5r0zX0zfIreLKVP7.Xbq1JhHozBhlGnBeHg.RdE/fC",
						"manager@gmx.at", "+43 12345678");
				Employee p3 = new Employee(
						1234567,
						df.getFirstName(),
						df.getLastName(),
						df.getBirthDate(),
						address,
						df.getRandomText(10, 20),
						1234.5f,
						df.getBirthDate(),
						"employee",
						"$2a$04$vr5j3pjvADh5r0zX0zfIreLKVP7.Xbq1JhHozBhlGnBeHg.RdE/fC",
						"employee@gmx.at", "+43 123456789");
				UserRole role = new UserRole(Constant.ROLE_ADMINISTRATOR, p1);
				UserRole role2 = new UserRole(Constant.ROLE_MANAGER, p1);
				UserRole role3 = new UserRole(Constant.ROLE_EMPLOYEE, p1);
				p1.addUserRole(role);
				p1.addUserRole(role2);
				p1.addUserRole(role3);
				p1.setRole(Constant.ROLE_ADMINISTRATOR);
				employeeDao.save(p1);
				UserRole role4 = new UserRole(Constant.ROLE_MANAGER, p2);
				UserRole role5 = new UserRole(Constant.ROLE_EMPLOYEE, p2);
				p2.addUserRole(role4);
				p2.addUserRole(role5);
				p2.setRole(Constant.ROLE_MANAGER);
				employeeDao.save(p2);
				UserRole role6 = new UserRole(Constant.ROLE_EMPLOYEE, p3);
				p3.addUserRole(role6);
				p3.setRole(Constant.ROLE_EMPLOYEE);
				employeeDao.save(p3);
			}
			firstStart = false;
			return Constant.PAGE_LOGIN;
		} catch (Exception ex) {
			System.out.println("Location: " + ex.getLocalizedMessage()
					+ "\nCouse: " + ex.getCause() + "\nMessage: "
					+ ex.getMessage());
		}
		return null;

	}

	/*
	 * ########### index.jsp ############
	 */

	// Cover Page
	@RequestMapping(value = { "/", "start" })
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute(Constant.KEY_NEWS_LIST, newsRepository.findAll());
		User user = controllerSupport.getCurrentUser();
		Employee emp = employeeDao.findEmployeeByUserName(user.getUsername());
		model.addAttribute(Constant.KEY_EMPLOYEE, emp);
		if (user.getAuthorities().size() == Constant.ROLE_INT_MANAGER) {
			model.addAttribute(
					Constant.KEY_ANNOUNCEMENT_LIST,
					announcementDao
							.findAnnouncementByManagerAndEnabledTrueAndNotReadGreaterThanOrDayIs(
									emp, 0, new Date()));
		}
		if (request.getSession().getAttribute(Constant.KEY_STATUS) == null) {
			request.getSession().setAttribute(Constant.KEY_STATUS,
					emp.getStatus());
			request.getSession().setAttribute(Constant.KEY_USER_NAV_BAR_TOP, emp.getFirstName()+" "+emp.getLastName());
		}
		return Constant.PAGE_INDEX;
	}

	// From index.jsp manageEmployees
	@RequestMapping(value = { "manageEmployees" })
	public String listAllEmployee(Model model) {
		User user = controllerSupport.getCurrentUser();
		if (user.getAuthorities().size() == Constant.ROLE_INT_MANAGER) {
			model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
					employeeDao.findEmployeeFromManager(user.getUsername()));
		} else {
			model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
					employeeDao.findEmployeeByOrderByDepartmentId());
		}

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

	@RequestMapping(value = { "showAllTimeRecords" })
	public String showTimeRecords(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_LIST_TIME_RECORDS;
	}

	@RequestMapping(value = { "newNews" })
	public String newNews(@Valid @ModelAttribute News newNews,
			BindingResult bindingResult, Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return "forward:/start";
		}
		newsRepository.save(newNews);
		return "forward:/start";
	}

	@RequestMapping(value = { "removeNews" }, method = RequestMethod.GET)
	public String removeNews(@RequestParam int id, Model model) {
		try {
			newsRepository.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"Couldn't delete news");
		}
		return "forward:/start";
	}

	@RequestMapping(value = { "showPersonalTimeRecords" })
	public String showPersonalTimeRecords(Model model) {
		User user = controllerSupport.getCurrentUser();
		model.addAttribute(Constant.KEY_EMPLOYEE,
				employeeDao.findEmployeeByUserName(user.getUsername()));
		return Constant.PAGE_LIST_TIME_RECORDS;
	}

	@RequestMapping(value = { "showEmployees" })
	public String showAllEmployees(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
		return Constant.PAGE_LIST_EMPLYEES;
	}

	
	@RequestMapping(value = { "setStatus" })
	public String setStatus(@RequestParam String status, Model model,
			HttpServletRequest request) {
		User user = controllerSupport.getCurrentUser();
		employeeDao.updateEmployeeStatus(user.getUsername(), status);
		request.getSession().setAttribute(Constant.KEY_STATUS, status);
		return Constant.PAGE_INDEX;
	}

	@RequestMapping(value = { "showProfile" })
	public String showProfile(Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE, employeeDao
				.findEmployeeByUserName(controllerSupport.getCurrentUser()
						.getUsername()));
		return Constant.PAGE_PROFILE;
	}

	// @ExceptionHandler(Exception.class)
	// public String handleAllException(Exception ex) {
	// return "showError";
	// }

}
