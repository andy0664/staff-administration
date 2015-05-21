package at.fh.swenga.jpa.support;

import java.util.Calendar;
import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Repository
public class ControllerSupport {

	public boolean checkBinding(BindingResult bindingResult, Model model) {
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

	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

	public int getDayMoth(Date date, int choice) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (choice) {
		case Constant.DAY_OF_MONTH:
			return cal.get(Calendar.DAY_OF_MONTH);
		default:
			return cal.get(Calendar.MONTH) + 1;
		}
	}
}
