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

	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.GET)
	public String editEmployee(Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
				departmentDao.findAll());
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "editEmployee" })
	public String changeEmployee(@RequestParam int id, Model model) {
		try {
			model.addAttribute(Constant.KEY_DEPARTMENT_LIST,
					departmentDao.findAll());
			model.addAttribute(Constant.KEY_EMPLOYEE, employeeDao.findOne(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	@RequestMapping(value = { "deleteEmployee" })
	public String deleteEmployee(@RequestParam int id, Model model) {
		try {
			// announcementDao.changeEnableStateAnnouncement(false,
			// employeeDao.findEmployeeById(id));
			employeeDao.delete(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"couldn't delete employee");
		}

		return "forward:manageEmployees";
	}

	@RequestMapping(value = { "ExportEmployeePdf" })
	public String exportEmployeePdf(int id, Model model) {
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeById(id));
		return Constant.CLASS_EXPORT_EMPLOYEE_PDF;
	}

	@RequestMapping(value = { "ExportEmployeesPdf" })
	public String exportEmployeesPdf(Model model) {
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
	@RequestMapping(value = { "addEmployee" }, method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute EmployeeDTO newEmployee,
			BindingResult bindingResultEmployee,
			@Valid @ModelAttribute Address newAddress,
			BindingResult bindingResultAddress, @RequestParam int department,
			Model model) {
		if (controllerSupport.checkBinding(bindingResultEmployee, model)
				|| controllerSupport.checkBinding(bindingResultAddress, model)) {
			return cancelAddEmployee(model, newEmployee, newAddress);
		}
		newEmployee.setAddress(newAddress);
		Employee emp = newEmployee.generateEmployee();
		emp.setPassword(encoder.encode(emp.getPassword()));
		String uniqueError = checkEmployee(emp);
		if (!Constant.NO_ERROR.equals(uniqueError)) {
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, uniqueError);
			return cancelAddEmployee(model, newEmployee, newAddress);
		}
		try {
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
						Constant.ANNOUNCEMENT_BIRTHDAY, message,
						announcementDay,
						employeeDao.findManagerFromEmployee(department), emp);

				announcementDao.save(announcement);
			}
		} catch (Exception ex) {
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					Constant.ERROR_MESSAGE_ADD_EMPLOYEE);
			return cancelAddEmployee(model, newEmployee, newAddress);
		}
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	@RequestMapping(value = { "changeEmployee" }, method = RequestMethod.POST)
	public String updateEmployee(
			@Valid @ModelAttribute EmployeeDTO newEmployee,
			BindingResult bindingResultEmployee,
			@Valid @ModelAttribute Address newAddress,
			BindingResult bindingResultAddress, @RequestParam int id,
			@RequestParam int department, Model model) {
		Employee emp = employeeDao.findOne(id);
		if (controllerSupport.checkBinding(bindingResultEmployee, model)
				|| controllerSupport.checkBinding(bindingResultAddress, model)) {
			return cancelChangeEmployee(model, emp,
					Constant.ERROR_MESSAGE_UPDATE_EMPLOYEE);
		}
		newEmployee.setAddress(newAddress);
		emp.updateEmployee(newEmployee);
		String uniqueError = checkEmployee(emp);
		if (!Constant.NO_ERROR.equals(uniqueError)) {
			return cancelChangeEmployee(model, emp, uniqueError);
		}
		if (newEmployee.getPassword() != null
				&& !emp.getPassword().equals(newEmployee.getPassword())) {
			emp.setPassword(encoder.encode(newEmployee.getPassword()));
		}
		try {
			if (newEmployee.getRole() == null
					|| emp.getRole().equals(newEmployee.getRole())) {
				saveEmployee(emp, department, "");
			} else {
				emp.setUserRole(new HashSet<UserRole>());
				emp.setRole(newEmployee.getRole());
				List<UserRole> list = userRoleRepository.findByEmployee(emp);
				userRoleRepository.delete(list);
				// userRoleRepository.removeByUsername(emp.getId());
				saveEmployee(emp, department, emp.getRole());
			}
		} catch (Exception ex) {
			return cancelChangeEmployee(model, emp,
					Constant.ERROR_MESSAGE_UPDATE_EMPLOYEE);
		}
		return Constant.REDIRECT_MANAGE_EMPLOYEES;
	}

	/*
	 * ########### profile.jsp ############
	 */
	@RequestMapping(value = { "changeRequest" }, method = RequestMethod.POST)
	public String employeeChangeRequest(String changeRequest, Model model) {
		User user = controllerSupport.getCurrentUser();
		if (user.getAuthorities().size() == Constant.ROLE_INT_EMPLOYEE) {
			Employee emp = employeeDao.findEmployeeByUserName(user
					.getUsername());
			Employee manager = employeeDao.findManagerFromEmployee(emp
					.getDepartment().getId());
			String message = String.format("%s %s: %s", emp.getFirstName(),
					emp.getLastName(), changeRequest);
			Announcement annouce = new Announcement(
					Constant.ANNOUNCEMENT_CHANGE_REQUEST, message,
					Constant.ANNOUNCEMENT_NOT_READ, manager, emp);
			announcementDao.save(annouce);
		}
		return "forward:start";
	}

	private void saveEmployee(Employee emp, int department, String role)
			throws Exception {
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
			emp.setRole(Constant.ROLE_EMPLOYEE);
			emp.addUserRole(genereateUserRole(Constant.ROLE_EMPLOYEE, emp));
		}
		employeeDao.save(emp);
	}

	private UserRole genereateUserRole(String role, Employee emp) {
		return new UserRole(role, emp);
	}

	private String checkEmployee(Employee emp) {
		if (employeeDao.checkUniqueSSN(emp.getSsn(), emp.getId()) != null) {
			return "Employee with SSN already exists";
		}
		if (employeeDao.checkUniqueMail(emp.getMail(), emp.getId()) != null) {
			return "Employee with E-Mail already exists";
		}
		if (employeeDao.checkUniquePhone(emp.getPhone(), emp.getId()) != null) {
			return "Employee with Phone already exists";
		}
		if (employeeDao.checkUniqueUserName(emp.getUserName(), emp.getId()) != null) {
			return "Employee with Username already exists";
		}
		return Constant.NO_ERROR;
	}

	private String cancelAddEmployee(Model model, EmployeeDTO newEmployee,
			Address newAddress) {
		model.addAttribute(Constant.KEY_TMP_EMPLOYEE, newEmployee);
		model.addAttribute(Constant.KEY_ADDRESS, newAddress);
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

	private String cancelChangeEmployee(Model model, Employee emp,
			String message) {
		model.addAttribute(Constant.KEY_EMPLOYEE, emp);
		model.addAttribute(Constant.KEY_ERROR_MESSAGE, message);
		return Constant.PAGE_EDIT_EMPLOYEE;
	}

}
