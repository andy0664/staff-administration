package at.fh.swenga.jpa.support;

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

}
