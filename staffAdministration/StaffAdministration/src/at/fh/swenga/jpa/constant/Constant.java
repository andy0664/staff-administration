package at.fh.swenga.jpa.constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
	
	//Page names
	public static final String PAGE_INDEX="index";
	public static final String PAGE_EDIT_EMPLOYEE="/pages/editEmployee";
	public static final String PAGE_EDIT_DEPARTMENT="/pages/editDepartment";
	
	
	//Roles
	public static final int ROLE_ADMINISTRATOR=1;
	public static final int ROLE_MANAGER=2;
	public static final int ROLE_EMPLOYEE=3;
	
	//Model Key Attributes
	public static final String KEY_EMPLOYEE_LIST="employeeList";
	public static final String KEY_ERROR="errorMessage";
	
	//Methods
	
	public static Date parseToDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
