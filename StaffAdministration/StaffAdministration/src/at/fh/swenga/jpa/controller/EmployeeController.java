package at.fh.swenga.jpa.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.SimpleAnnouncementRepository;
import at.fh.swenga.jpa.dao.SimpleDepartmentRepository;
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleNewsRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dao.SimpleUserRoleRepository;
import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.UserRole;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;
import at.fh.swenga.jpa.support.DateTimeEditor;

@Controller
public class EmployeeController {

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

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

	// For Binding Date and Time
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
	}

	/*
	 * ########### manageEmployees.jsp ############
	 */

	@Transactional
	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.GET)
	public String editEmployee(Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
				departmentDao.findAll());
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@Transactional
	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.GET)
	public String changeEmployee(@RequestParam int id, Model model) {
		try {
			model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
					departmentDao.findAll());
			model.addAttribute(Constant.KEY_EMPLOYEE,
					employeeDao.findOne(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@Transactional
	@RequestMapping(value = { "deleteEmployee" })
	public String deleteEmployee(@RequestParam int id, Model model) {
		try {
			//announcementDao.changeEnableStateAnnouncement(false, employeeDao.findEmployeeById(id));
			employeeDao.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"couldn't delete employee");
		}

		return "forward:manageEmployees";
	}

	// Zum füllen der Mitarbeiter Tabelle nur zum testen --> ende entfernen
//	@RequestMapping("fillEmployee")
//	@Transactional
//	public String fillData(Model model) {
//
//		DataFactory df = new DataFactory();
//
//		for (int i = 0; i < 10; i++) {
//			Address address = new Address(df.getStreetName(), df.getCity(),
//					df.getRandomWord(), 8052);
//			Employee p1 = new Employee(12345, df.getFirstName(),
//					df.getLastName(), df.getBirthDate(), address,
//					df.getRandomText(10, 20), 1234.5f, df.getBirthDate(),
//					"testUser",
//					"$2a$04$vr5j3pjvADh5r0zX0zfIreLKVP7.Xbq1JhHozBhlGnBeHg.RdE/fC","admin@gmx.at","+43 1234567");
//			employeeDao.save(p1);
//		}
//		return Constant.REDIRECT_MANAGE_EMPLOYEES;
//	}
	
	@RequestMapping(value={"ExportEmployeePdf"})
	public String exportEmployeePdf(int id, Model model){
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findEmployeeById(id));
		return Constant.CLASS_EXPORT_EMPLOYEE_PDF;
	}
	
	@RequestMapping(value={"ExportEmployeesPdf"})
	public String exportEmployeesPdf(Model model){
		User user = controllerSupport.getCurrentUser();
		if (user.getAuthorities().size() == Constant.ROLE_INT_MANAGER) {
			model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
					employeeDao.findEmployeeFromManager(user.getUsername()));
		} else {
			model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
					employeeDao.findAll());
		}
		return Constant.CLASS_EXPORT_EMPLOYEE_PDF;
	}

	/*
	 * ########### editEmployee.jsp ############
	 */
	@Transactional
	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute EmployeeDTO newEmployee,
			@Valid @ModelAttribute Address newAddress,
			@RequestParam int department, BindingResult bindingResult,
			Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return "forward:/manageEmployees";
		}
		newEmployee.setAddress(newAddress);
		Employee emp = newEmployee.generateEmployee();
		emp.setPassword(encoder.encode(emp.getPassword()));
		saveEmployee(emp, department, newEmployee.getRole());
		if (department != Constant.NO_DEPARTMENT) {
			String message = String.format("Birthday: %s %s ",
					emp.getFirstName(), emp.getLastName());
			Date announcementDay = controllerSupport
					.getBirthdayCurYear(newEmployee.getDayOfBirth());
			if (announcementDay.before(new Date())
					&& !DateUtils.isSameDay(announcementDay, new Date())) {
				announcementDay = controllerSupport.updateAnnouncementYear(
						announcementDay, 1);
			}
			Announcement announcement = new Announcement(
					Constant.ANNOUNCEMENT_BIRTHDAY, message, announcementDay,
					employeeDao.findManagerFromEmployee(department), emp);
			announcementDao.save(announcement);

		}
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	@Transactional
	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.POST)
	public String updateEmployee(
			@Valid @ModelAttribute EmployeeDTO newEmployee,
			@Valid @ModelAttribute Address newAddress, @RequestParam int id,
			@RequestParam int department, BindingResult bindingResult,
			Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return "forward:/manageEmployees";
		}
		Employee emp = employeeDao.findOne(id);
		newEmployee.setAddress(newAddress);
		emp.updateEmployee(newEmployee);
		if(newEmployee.getPassword()!=null && !emp.getPassword().equals(newEmployee.getPassword())){
			emp.setPassword(encoder.encode(newEmployee.getPassword()));
		}
		if (newEmployee.getRole()==null || emp.getRole().equals(newEmployee.getRole())) {
			saveEmployee(emp, department, "");
		} else {
			emp.setUserRole(new HashSet<UserRole>());
			emp.setRole(newEmployee.getRole());
			List<UserRole> list = userRoleRepository.findByEmployee(emp);
			userRoleRepository.delete(list);
			// userRoleRepository.removeByUsername(emp.getId());
			saveEmployee(emp, department, emp.getRole());
		}

		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	/*
	 * ########### profile.jsp ############
	 */
	@Transactional
	@RequestMapping(value = { "changeRequest" }, method = RequestMethod.POST)
	public String employeeChangeRequest(String userName, String changeRequest,
			Model model) {
		Employee emp = employeeDao.findEmployeeByUserName(userName);
		Employee manager = employeeDao.findManagerFromEmployee(emp
				.getDepartment().getId());
		String message = String.format("%s %s: %s", emp.getFirstName(),
				emp.getLastName(), changeRequest);
		Announcement annouce = new Announcement(
				Constant.ANNOUNCEMENT_CHANGE_REQUEST, message,
				Constant.ANNOUNCEMENT_NOT_READ, manager, emp);
		announcementDao.save(annouce);
		return "forward:start";
	}

	private void saveEmployee(Employee emp, int department, String role) {
		if (department != Constant.NO_DEPARTMENT) {
			emp.setDepartment(departmentDao.findDepartmentById(department));
		}
		if (Constant.ROLE_ADMINISTRATOR.equals(role)) {
			emp.addUserRole(genereateUserRole(Constant.ROLE_ADMINISTRATOR, emp));
			emp.addUserRole(genereateUserRole(Constant.ROLE_MANAGER, emp));
			emp.addUserRole(genereateUserRole(Constant.ROLE_EMPLOYEE, emp));
			emp.setRole(Constant.ROLE_ADMINISTRATOR);
		} else if (Constant.ROLE_MANAGER.equals(role)) {
			emp.addUserRole(genereateUserRole(Constant.ROLE_MANAGER, emp));
			emp.addUserRole(genereateUserRole(Constant.ROLE_EMPLOYEE, emp));
			emp.setRole(Constant.ROLE_MANAGER);
		} else if (Constant.ROLE_EMPLOYEE.equals(role)) {
			emp.addUserRole(genereateUserRole(Constant.ROLE_EMPLOYEE, emp));
			emp.setRole(Constant.ROLE_EMPLOYEE);
		}
		employeeDao.save(emp);
	}

	private UserRole genereateUserRole(String role, Employee emp) {
		return new UserRole(role, emp);
	}

}
