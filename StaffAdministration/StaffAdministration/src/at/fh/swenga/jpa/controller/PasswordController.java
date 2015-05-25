package at.fh.swenga.jpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dto.NewPassword;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;

@Controller
public class PasswordController {

	@Autowired
	private SimpleEmployeeRepository employeeDao;

	@Autowired
	private ControllerSupport controllerSupport;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

	@RequestMapping(value = { "changePassword" })
	public String changePassword(Model model) {
		return Constant.PAGE_NEW_PASSWORD;
	}

	@RequestMapping(value = { "updatePassword" })
	public String updatePassword(@Valid @ModelAttribute NewPassword password,
			BindingResult bindingResult, Model model) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return Constant.PAGE_NEW_PASSWORD;
		}
		User user = controllerSupport.getCurrentUser();
		Employee emp = employeeDao.findEmployeeByUserName(user.getUsername());
		
		if(!encoder.matches(password.getOldPassword(), emp.getPassword())){
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,"old password not correct!");
			return Constant.PAGE_NEW_PASSWORD;
		}else if(!password.getNewPassword().equals(password.getRepeatPassword())){
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,"not the same password!");
			return Constant.PAGE_NEW_PASSWORD;
		}
		emp.setPassword(encoder.encode(password.getNewPassword()));
		employeeDao.save(emp);
		return Constant.PAGE_INDEX;
	}

}
