package at.fh.swenga.jpa.controller;

import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import at.fh.swenga.jpa.dao.SimpleDepartmentRepository;
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleNewsRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dao.SimpleUserRoleRepository;
import at.fh.swenga.jpa.dto.DepartmentDTO;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.UserRole;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;
import at.fh.swenga.jpa.support.DateTimeEditor;
import at.fh.swenga.jpa.support.SanitizeString;

@Controller
public class DepartmentController {

	@Autowired
	private SimpleEmployeeRepository employeeDao;

	@Autowired
	private SimpleDepartmentRepository departmentDao;

	@Autowired
	private ControllerSupport controllerSupport;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
		binder.registerCustomEditor(String.class, new SanitizeString());
	}

	/*
	 * ########### manageDepartments.jsp ############
	 */

	@RequestMapping(value = { "deleteDepartment" })
	public String deleteDepartment(@RequestParam int id, Model model) {
		try {
			departmentDao.delete(id);
			if(departmentDao.exists(id)){
				model.addAttribute(Constant.KEY_ERROR_MESSAGE,
						"couldn't delete department - Department has employees");
			}
		} catch (Exception ex) {
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"couldn't delete department");
		}
		return "forward:manageDepartments";
	}

	@RequestMapping(value = { "editDepartment" })
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

	/*
	 * ########### editDepartment.jsp ############
	 */

	@RequestMapping(value = { "changeDepartment" }, method = RequestMethod.POST)
	public String updateDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,BindingResult bindingResult,
			@RequestParam int id, @RequestParam int manager, Model model) {
		
		Department dep = departmentDao.findDepartmentById(id);
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return prepareCancelUpdate(model, Constant.ERROR_MESSAGE_UPDATE_DEPARTMENT, dep);
		}
		dep.updateDepartment(newDepartment);
		String uniqueError = checkUniqueKey(dep);
		if(!uniqueError.equals(Constant.NO_ERROR)){
			return prepareCancelUpdate(model, uniqueError, dep);
		}
		try{
			if (dep.getManager().getId() != manager) {
				Employee newManager = employeeDao.findOne(manager);
				if(newManager.getRole().equals(Constant.ROLE_EMPLOYEE)){
					UserRole role = new UserRole(Constant.ROLE_MANAGER, newManager);
					newManager.addUserRole(role);
					newManager.setRole(Constant.ROLE_MANAGER);
					employeeDao.save(newManager);
				}
				dep.setManager(newManager);
			}
			departmentDao.save(dep);
		}catch(Exception ex){
			return prepareCancelUpdate(model, Constant.ERROR_MESSAGE_UPDATE_DEPARTMENT, dep);
		}
		
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	@RequestMapping(value = { "addDepartment" }, method = RequestMethod.POST)
	public String saveDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,
			BindingResult bindingResult, @RequestParam int manager, Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return prepareCancelAdd(model, Constant.ERROR_MESSAGE_ADD_DEPARTMENT, newDepartment);
		}
		Employee emp = employeeDao.findOne(manager);
		Department dep = newDepartment.generateDepartment();
		String uniqueError = checkUniqueKey(dep);
		if(!uniqueError.equals(Constant.NO_ERROR)){
			return prepareCancelAdd(model,uniqueError,newDepartment);
			
		}
		try{
			if(emp.getRole().equals(Constant.ROLE_EMPLOYEE)){
				UserRole role = new UserRole(Constant.ROLE_MANAGER, emp);
				emp.addUserRole(role);
				emp.setRole(Constant.ROLE_MANAGER);
			}
			emp.setDepartment(dep);
			dep.setManager(emp);
			departmentDao.save(dep);
			employeeDao.save(emp);
		}catch(Exception ex){
			return prepareCancelAdd(model, Constant.ERROR_MESSAGE_ADD_DEPARTMENT, newDepartment);
		}
		return Constant.REDIRECT_MANAGE_DEPARTMENTS;
	}

	private String checkUniqueKey(Department department) {
		if (departmentDao.checkUniqueShortcut(department.getShortcut(),
				department.getId()) != null) {
			return "Shortcut already used";
		}
		return Constant.NO_ERROR;
	}
	
	private String prepareCancelAdd(Model model, String message, DepartmentDTO dep){
		model.addAttribute(Constant.KEY_ERROR_MESSAGE, message);
		model.addAttribute(Constant.KEY_TMP_DEPARTMENT, dep);
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeWithNoDepartment());
		return Constant.PAGE_EDIT_DEPARTMENT;
	}
	
	private String prepareCancelUpdate(Model model, String message, Department dep){
		model.addAttribute(Constant.KEY_ERROR_MESSAGE, message);
		model.addAttribute(Constant.KEY_TMP_DEPARTMENT, dep);
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeByDepartmentId(dep.getId()));
		return Constant.PAGE_EDIT_DEPARTMENT;
	}

}
