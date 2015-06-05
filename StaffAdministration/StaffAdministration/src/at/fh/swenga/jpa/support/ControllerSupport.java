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
//			String errorMessage = "";
//			for (FieldError error : bindingResult.getFieldErrors()) {
//				errorMessage += error.getField() + " is invalid<br>";
//			}
			model.addAttribute(Constant.KEY_ERROR_MESSAGE, Constant.ERROR_MESSAGE_ADD_EMPLOYEE);
			return true;
		}
		return false;
	}

	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
	}

	public Date updateAnnouncementYear(Date date, int addYear) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, addYear);
		return cal.getTime();
	}
	
	public Date getBirthdayCurYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
		return cal.getTime();
	}
}
