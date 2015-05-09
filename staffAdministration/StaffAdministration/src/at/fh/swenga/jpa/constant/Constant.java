package at.fh.swenga.jpa.constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
	
	//Page names
	public static final String PAGE_INDEX="index";
	public static final String PAGE_EDIT_EMPLOYEE="/pages/editEmployee";
	public static final String PAGE_EDIT_DEPARTMENT="/pages/editDepartment";
	public static final String PAGE_MANAGE_EMPLOYEES="/pages/manageEmployees";
	public static final String PAGE_MANAGE_DEPARTMENTS="/pages/manageDepartments";
	public static final String PAGE_NEW_TIME_RECORD = "/pages/editTimeRecord";
	public static final String PAGE_LIST_TIME_RECORDS = "/pages/listTimeRecords";
	
	
	//Export
	public static final String CLASS_EXPORT_TIME_RECORD="timeRecordExcelExport";
	
	//Roles
	public static final int ROLE_ADMINISTRATOR=1;
	public static final int ROLE_MANAGER=2;
	public static final int ROLE_EMPLOYEE=3;
	
	public static final int NO_DEPARTMENT=-1;
	
	//Model Key Attributes
	public static final String KEY_EMPLOYEE_LIST="employeeList";
	public static final String KEY_EMPLOYEE="employee";
	public static final String KEY_DEPARTMENT_LIST="departmentList";
	public static final String KEY_DEPARTMENT="department";
	public static final String KEY_TIME_RECORD_LIST="timeRecordList";
	public static final String KEY_ERROR_MESSAGE="errorMessage";
	public static final String KEY_UPDATE_EMPLOYEE_MESSAGE="updateEmployeeMessage";
	public static final String KEY_NEWS_LIST="newsList";
	public static final String KEY_TIME_RECORD_DATE_FROM="dateFrom";
	public static final String KEY_TIME_RECORD_DATE_TO="dateTo";
	
	//Redirects
	public static final String REDIRECT_MANAGE_EMPLOYEES="redirect:manageEmployees";
	public static final String REDIRECT_MANAGE_DEPARTMENTS="redirect:manageDepartments";
	
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	//Methods
	public static Date parseToDate(String date) {	
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String parseDateToString(Date date){
		return dateFormat.format(date);
	}
	
	public static String parseTimeToString(Date time){
		return timeFormat.format(time);
	}
}
