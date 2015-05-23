package at.fh.swenga.jpa.model;

import java.util.Date;

import com.dhtmlx.planner.DHXEventRec;

public class EventRec extends DHXEventRec {

	public String user_id;
	public String department;
	public Boolean department_visibility;
	
	
	public EventRec() {
		
	}
	
	
	public EventRec(String user_id) {
		this.user_id = user_id;
	}
	
	public EventRec(String user_id, String department, Boolean department_visibility) {
		this.user_id = user_id;
		this.department = department;
		this.department_visibility = department_visibility;
	}
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public Boolean getDepartment_visibility() {
		return department_visibility;
	}
	public void setDepartment_visibility(Boolean department_visibility) {
		this.department_visibility = department_visibility;
	}
	
	//altough converting the data to Boolean in the EventsManager, it still is handled as String, so we need this method in addition
	public void setDepartment_visibility(String department_visibility) {
		this.department_visibility = department_visibility.equals("true");
		System.out.println("setDepartment_visibility with String argument was called");
		System.out.println(department_visibility);
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
