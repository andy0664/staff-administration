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
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;
import at.fh.swenga.jpa.support.DateTimeEditor;

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
	}
	
	/*
	 * ########### manageDepartments.jsp ############
	 */
	
	@Transactional
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

	@Transactional
	@RequestMapping(value = { "changeDepartment" }, method = RequestMethod.GET)
	public String editDepartment(@RequestParam int id, Model model) {
		model.addAttribute(Constant.KEY_DEPARTMENT,
				departmentDao.findDepartmentById(id));
		model.addAttribute(Constant.KEY_EMPLOYEE_LIST,
				employeeDao.findEmployeeByDepartmentId(id));
		return Constant.PAGE_EDIT_DEPARTMENT;
	}

	@Transactional
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

	@Transactional
	@RequestMapping(value = { "changeDepartment" }, method = RequestMethod.POST)
	public String updateDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,
			@RequestParam int id, @RequestParam int manager, Model model,
			BindingResult bindingResult) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
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
	
	@Transactional
	@RequestMapping(value = { "addDepartment" }, method = RequestMethod.POST)
	public String saveDepartment(
			@Valid @ModelAttribute DepartmentDTO newDepartment,
			@RequestParam int manager, BindingResult bindingResult, Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
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
	
}
