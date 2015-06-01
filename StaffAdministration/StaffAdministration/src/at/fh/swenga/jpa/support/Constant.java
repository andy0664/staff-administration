package at.fh.swenga.jpa.support;

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
	public static final String PAGE_LOGIN = "login";
	public static final String PAGE_LIST_EMPLYEES = "/pages/listEmployees";
	public static final String PAGE_PROFILE = "pages/profile";
	public static final String PAGE_NEW_PASSWORD="pages/newPassword";
	
	
	//Export
	public static final String CLASS_EXPORT_TIME_RECORD_EXCEL="timeRecordExcelExport";
	public static final String CLASS_EXPORT_EMPLOYEE_PDF="EmployeePdfExport";
	public static final String CLASS_EXPORT_TIME_RECORD_PDF="timeRecordPdfExport";
	
	//Roles
	public static final String ROLE_ADMINISTRATOR="ROLE_ADMIN";
	public static final String ROLE_MANAGER="ROLE_MANAGER";
	public static final String ROLE_EMPLOYEE="ROLE_EMPLOYEE";
	public static final int ROLE_INT_ADMINISTRATOR=3;
	public static final int ROLE_INT_MANAGER=2;
	public static final int ROLE_INT_EMPLOYEE=1;
	
	//Calendar JSP file paths:
	public static final String CALENDAR_ARTICLE_READ_ONLY = "/calendar/article_read_only";
	public static final String CALENDAR_ARTICLE = "/calendar/article";
	public static final String CALENDAR_CUSTOM_EDITOR = "/calendar/custom_editor";
	public static final String CALENDAR_HEADER = "/calendar/header";
	public static final String CALENDAR_MENU = "/calendar/menu";
	public static final String CALENDAR_PRODUCTS = "/calendar/products";
	
	
	//Status
	public static final String STATUS_AVAILABLE="Available";
	public static final String STATUS_BUSY="Busy";
	public static final String STATUS_NOT_AVAILABLE="Not Available";
	
	
	//Subjects Announcements
	public static final String ANNOUNCEMENT_VACATION="Request for leave";
	public static final String ANNOUNCEMENT_BIRTHDAY="Birthday";
	public static final String ANNOUNCEMENT_CHANGE_REQUEST="Request for data change";
	
	public static final int ANNOUNCEMENT_NOT_READ=1;
	
	//Typ Timerecord
	public static final String TYP_VACATION="vacation";
	
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
	public static final String KEY_ANNOUNCEMENT_LIST="announcementList";
	public static final String KEY_STATUS="status";
	
	
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
