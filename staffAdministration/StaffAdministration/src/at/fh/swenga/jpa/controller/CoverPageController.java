package at.fh.swenga.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.jpa.constant.Constant;


@Controller
public class CoverPageController {
	
	
	//Cover Page
	@RequestMapping(value={"/","start"})
	public String index(Model model){
		return Constant.PAGE_INDEX;
	}
	
	//From index.jsp add new Employee
	@RequestMapping(value={"addEmployee"})
	public String editEmployee(Model model){
		return Constant.PAGE_EDIT_EMPLOYEE;
	}
	
	
	//From index.jsp add new Department
	@RequestMapping(value={"addDepartment"})
	public String editDepartment(Model model){
		return Constant.PAGE_EDIT_DEPARTMENT;
	}
	
	//From editEmployee.jsp submit button
	@RequestMapping(value={"saveEmployee"})
	public String saveEmployee(Model model){
		return "forward:/start";
	}
}
