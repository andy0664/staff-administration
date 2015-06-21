package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.Column;

import com.dhtmlx.planner.DHXEvent;

public class EventV3 extends DHXEvent {

	
	/*
	Important steps when adding a column to the events table:
	the column name is: user_id
	so in the entity we use (Event in this case, which inherits from DHXEvent), we add the column and map it to @Column(name = "user_id") 
	We have to implement a constructor for the Entity class with all attributes
	The next step is to define the getter and setter methods. for the 4 default attributes, getters and setters were already defined. We add the 
	getter and setter for our new column user_id:
	after the syntax: "get" + variablename mapped to Column (first letter of variable has to be in uppercase now:
	for example: variable user_id
	getter: getUser_id
	setter: setUser_id
	
	After that, we have to map the column from the entity to the database table:
	This is done in Event.hbm.xml
	Add the column:
	<property column="user_id" name="user_id" type="java.lang.String"/>
	
	It seems like we also have to add the empty constructor for the createEvent method in the CustomEventsManager.class
	
	
	There was also a problem in getEvents - because we now have an additional column, but in the CustomEventsManager in getEvents, it checks in the createCreteria a Event.class with 
	only the 4 default columns, so change this class to our Event class we created in the entities. 
	
	 * 
	 */
	
	public String user_id;
	public String department;
	public Boolean department_visibility;
	
	
	public EventV3() {
		
	}
	
	public EventV3(int event_id, Date start_date, Date end_date, String event_name, String user_id, String department, Boolean department_visibility) {
		this.id = event_id;
		this.text = event_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = user_id;
		this.department = department;
		this.department_visibility = department_visibility;	
	}
	
	public EventV3(Date start_date, Date end_date, String event_name, String user_id, String department, Boolean department_visibility) {
		this.text = event_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.user_id = user_id;
		this.department = department;
		this.department_visibility = department_visibility;	
	}
	
	
	
	
	public EventV3(String user_id) {
		this.user_id = user_id;
	}
	
	public EventV3(String user_id, String department, Boolean department_visibility) {
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
