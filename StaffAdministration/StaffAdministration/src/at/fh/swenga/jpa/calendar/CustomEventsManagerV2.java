package at.fh.swenga.jpa.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.model.Employee;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.dhtmlx.planner.DHXStatus;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import at.fh.swenga.jpa.model.EventV3;


public class CustomEventsManagerV2 extends DHXEventsManager {
	//returns only the events created by the user himself. 
	
	private User user;
	private String userDepartment;
	private static String ROLE_ADMIN = "ROLE_ADMIN";
	private boolean createDepartmentEvent;
	private boolean foreignUserCalendar;
	private String foreignUserName;

	public CustomEventsManagerV2(HttpServletRequest request) {
		super(request);
		// user = (User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println("Username========================"+user.getUsername());
		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		user = (User) ((SecurityContext) session
				.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication()
				.getPrincipal();
		
	
		System.out.println(userDepartment);
		createDepartmentEvent = false;
		userDepartment = "Default Department";
		
	}
	
	
	public CustomEventsManagerV2(HttpServletRequest request, boolean createDepartmentEvent, String department) {
		super(request);
		// user = (User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println("Username========================"+user.getUsername());
		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		user = (User) ((SecurityContext) session
				.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication()
				.getPrincipal();
		
		
		//userDepartment
		//Employee currentEmployee = (Employee) employeeDao.findEmployeeByUserName(user.getUsername());
		//userDepartment = currentEmployee.getDepartment().getName();
		System.out.println(userDepartment);
		this.createDepartmentEvent = createDepartmentEvent;
		userDepartment = department;
		
	}
	
	public CustomEventsManagerV2(HttpServletRequest request, String customUser) {
		super(request);
		// user = (User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println("Username========================"+user.getUsername());
		foreignUserCalendar = true;
		foreignUserName = customUser;
		
	}
	
	public CustomEventsManagerV2(String userDepartment, HttpServletRequest request) {
		super(request);
		HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		user = (User) ((SecurityContext) session
				.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication()
				.getPrincipal();
		this.userDepartment = userDepartment;
	}
	


	
	public Iterable<DHXEv> getEvents() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DHXEv> evs = new ArrayList<DHXEv>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// evs = session.createCriteria(Event.class).list();
			// check Event for right user name:
			// only get the events that the current user has created. 
			//evs = session.createCriteria(Event.class)
			//		.add(Restrictions.eq("user_id", user.getUsername())).list();
			
			//evs = session.createCriteria(EventV3.class).add(Restrictions.eq("user_id", "admin")).list();
			
			// VERSION 1: only retrieve personal events:
			
			if (foreignUserCalendar) {
				evs = session.createCriteria(EventV3.class).add(Restrictions.eq("user_id", foreignUserName)).list();
			} else {
				//evs = session.createCriteria(EventV3.class).add(Restrictions.eq("user_id", user.getUsername())).list();
				//when a manager adds department events, he just wants to view his personal entries in his personal calendar, so remove department entries from personal calendar:
				//so only add entries with department visibility == false
				evs = session.createCriteria(EventV3.class).add(Restrictions.and(Restrictions.eq("user_id", user.getUsername()), Restrictions.eq("department_visibility", false))).list();
				System.out.println(user.getUsername());
			}
			
			
			//getting the own events and the department events:
			//WHERE user_id = "username" OR (department = "Department1" AND department_visibility = true)
			
			// VERSION 2: retrieve personal and department wide events
			//evs = session.createCriteria(EventV3.class).add(Restrictions.or(Restrictions.eq("user_id", user.getUsername()),Restrictions.and(Restrictions.eq("department", userDepartment),Restrictions.eq("department_visibility", true)))).list();
			
			//checking for the right department, even if it is just for a employee:
			//evs = session.createCriteria(EventV3.class).add(Restrictions.eq("department", "Department1")).add(Restrictions.or(Restrictions.eq("user_id", user.getUsername()),Restrictions.eq("department_visibility", true))).list();
			
			//evs = session.createCriteria(EventV3.class).list();
			//with the getUsername method, the query gets executed successfully on the first reload, but when reloading more than one time, there are no events visible
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		return evs;
	}
	

	
	
	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		HttpSession s = getRequest().getSession(true);
		EventV3 ev = (EventV3) event;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			//Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//omg omg omg!!!! Casting this event to my own event works!! OMG OMG OMG
			//EventV3 ev = (EventV3) event;
			
			//we have to add the username again to the event, otherwise the user_id in the events table will get set to null
			//if the retrieved user_id for the event from the database is the same as the current user, the user can change entries, otherwise not. 
			Boolean userFlag;
			
			
			if (ev.getId() == null) {
				userFlag = true;  //there was no event yet, so the event does not have an ID yet. We allow the user to craete an event! It does not matter which user is logged in
				
			}
			
			else {
			
				try{
					java.sql.Connection conn = DatabaseConnection.getConnection();
					java.sql.Statement statement = conn.createStatement();
	
					//String query = "SELECT event_id, event_name, start_date, end_date, user_id FROM events WHERE user_id = \""+user.getUsername()+"\"";
					String query = "SELECT event_id, event_name, start_date, end_date, user_id, department, department_visibility FROM events WHERE event_id = "+ev.getId().toString();
					//String query = "SELECT event_id, event_name, start_date, end_date, user_id FROM events";
					
					ResultSet resultset = statement.executeQuery(query);
					
					while (resultset.next()) {
						ev.setUser_id(resultset.getString("user_id"));
						ev.setDepartment(resultset.getString("department"));
						//strangely, i need to cast the getBoolean again to (Boolean) otherwise I get an error. 
						ev.setDepartment_visibility((Boolean) resultset.getBoolean("department_visibility"));
					}
					
					conn.close();
					userFlag = ev.getUser_id().equals(user.getUsername());
					System.out.println("user_id retrievement successful");
					System.out.println(ev.getUser_id());
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					userFlag = false; //something went wrong, do not allow user to update events
				}
			}
			
			//Boolean userFlag = ev.getUser_id().equals(user.getUsername());
			
			/*
			if (ev.getDepartment_visibility()) {
				addResponseAttribute("color", "red");
			} else {
				addResponseAttribute("color", "blue");
			}
			*/
			
			if (status == DHXStatus.UPDATE) {
				if (!userFlag)
					return DHXStatus.ERROR;
				//System.out.println("EventV3 Update");
				session.update(ev);
				
			} else if (status == DHXStatus.DELETE) {
				if (!userFlag)
					return DHXStatus.ERROR;
				//System.out.println("EventV3 Delete");
				session.delete(ev);
			} else if (status == DHXStatus.INSERT) {
				if (!userFlag)
					return DHXStatus.ERROR;
				//System.out.println("EventV3 Save");
				session.save(ev);
			}
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return status;
	}
	

	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		//if (foreignUserCalendar)
		//{
		//	return null;
		//}
		
		//else {
		//return new Event();
		//return new EventV3();
		
		//it was important to add the user_id parameter to the new EventV3 in this function!!!! that was all that was needed!!
		//the following line instantiate a blank Event object, but with the username already set as user_id attribute
		System.out.println(user.getAuthorities());
		return new EventV3(user.getUsername(), userDepartment, false);
}

}