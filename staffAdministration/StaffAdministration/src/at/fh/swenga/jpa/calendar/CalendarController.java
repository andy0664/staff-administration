package at.fh.swenga.jpa.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;







import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleUserRoleRepository;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.DateTimeEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXLightbox;
import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.DHXStatus;
import com.dhtmlx.planner.controls.DHXAgendaView;
import com.dhtmlx.planner.controls.DHXGridView;
import com.dhtmlx.planner.controls.DHXGridViewColumn;
import com.dhtmlx.planner.controls.DHXLightboxMiniCalendar;
import com.dhtmlx.planner.controls.DHXLightboxSelect;
import com.dhtmlx.planner.controls.DHXView;
import com.dhtmlx.planner.controls.DHXWeekAgendaView;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;

@Controller
public class CalendarController {
	
	
	@Autowired
	private SimpleEmployeeRepository employeeDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
	}
	
	
	//DateFormat dateFormat = new SimpleDateFormat("yyyy,mm,dd");
	private Calendar cal = Calendar.getInstance();
	private Date today = cal.getTime();
	private String testUser;
	private String calendarNote = "\n\nIn the grid view, you can sort events by clicking on the text field or a date field on the top of the view. \n" + 
	"By clicking on the Adobe Acrobat logo, you can export your calendar view as PDF document. ";
    
    private User getCurrentUser(HttpServletRequest request){
    	HttpSession session = request.getSession(true);
		System.out.println(session.getAttribute("SPRING_SECURITY_CONTEXT"));
		User user = (User) ((SecurityContext) session
				.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication()
				.getPrincipal();
		return user;
		
    }
	
	private boolean hasRole(User user, String role) {
		for (GrantedAuthority auth : user.getAuthorities()) {
            if (role.equals(auth.getAuthority()))
            	return true;
        }
		return false;
	}
	
	
	@RequestMapping("calendar/showCalendarReadOnly")
	public ModelAndView calendarReadOnly(HttpServletRequest request) throws Exception {
		testUser = request.getParameter("username");
    	if (testUser == null || testUser == "null") {
    		testUser = "admin";
    	}
    	System.out.println("testUser: " + testUser);
    	String name = employeeDao.findEmployeeByUserName(testUser).getFirstName();
    	String surname = employeeDao.findEmployeeByUserName(testUser).getLastName();
    	
    	DHXPlanner s = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
    	//s.setInitialDate(2013, 1, 7);
    	
    	s.config.setReadonly(true);
    	s.config.setReadonlyForm(true);
    	s.config.setDragResize(false);
    	s.config.setDragMove(false);
    	s.config.setDragLightbox(false);
    	s.config.setDragCreate(false);
    	s.config.setDblClickCreate(false);
    	s.config.setEditOnCreate(false);
    	s.config.setDetailsOnCreate(false);
    	s.config.setDetailsOnDblClick(false);
    	s.setInitialDate(today);
    	s.config.setScrollHour(8);
    	s.setWidth(900);
    	
    	//TO DO:
    	//Now, the standard event_class was edited in the dhtmlxscheduler.js: events are either blue or red, depends on whether the department_visibility of the event is true or false
    	
    	//s.load("events_read_only", DHXDataFormat.JSON);
    	//s.data.dataprocessor.setURL("events_read_only");
    	s.load("events_read_only", DHXDataFormat.JSON);
    	s.data.dataprocessor.setURL("events_read_only");
    	
    	
    	//s.views.add(new DHXAgendaView());
    	
    	DHXWeekAgendaView view2 = new DHXWeekAgendaView();//initializes the view
    	view2.setLabel("Agenda");// the name of the tab
    	s.views.add(view2);
    	
    	//s.setInitialView("agenda");
    	//s.views.getView(3).setTabPosition(50);
    	s.views.getView(3).setTabWidth(42);
    	
    	//DHXAgendaView agenda = (DHXAgendaView) s.views.getView(3);
    	//agenda.setStartDate(today);
    	//agenda.setEndDate(cal.YEAR+1, cal.MONTH+1, cal.DAY_OF_MONTH);
    	
    	
    	DHXGridView view = new DHXGridView();
    	view.addOption(new DHXGridViewColumn("text", "Text"));
    	view.addOption(new DHXGridViewColumn("start_date", "Start date", 150));
    	view.addOption(new DHXGridViewColumn("end_date", "End date", 150));
    	view.setFrom(cal.YEAR, cal.MONTH+1, cal.DAY_OF_MONTH);
    	s.views.add(view);
    	s.views.getView(4).setTabWidth(30);
    	
    	s.toPDF();
    	
    	//ModelAndView mnv = new ModelAndView(Constant.CALENDAR_ARTICLE);
    	ModelAndView mnv = new ModelAndView(Constant.CALENDAR_ARTICLE_READ_ONLY);
    	mnv.addObject("title", "Protected Calendar View");
    	mnv.addObject("sample_name", "Calendar of " + name + " " + surname);
    	mnv.addObject("sample_dsc", "This page lets you view all personal events of a selected employee. This view is read only, so no changes can be made. ");
    	//following line renders the Calendar/Planner object
		mnv.addObject("body", s.render());
		
		
        return mnv;
    }
	
	
	
	//@RequestMapping("calendar/departmentCalendar")
	@RequestMapping("calendar/showCalendarDepartment")
    public ModelAndView departmentCalendar(HttpServletRequest request) throws Exception {
		
		User currentUser = getCurrentUser(request);
		boolean managerRole = hasRole(currentUser, Constant.ROLE_MANAGER);
		
    	DHXPlanner s = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
    	//s.setInitialDate(2013, 1, 7);
    	s.setInitialDate(today);
    	s.config.setScrollHour(8);
    	s.setWidth(900);
    	
    	//TO DO:
    	//Now, the standard event_class was edited in the dhtmlxscheduler.js: events are either blue or red, depends on whether the department_visibility of the event is true or false
    	
    	//s.load("department_events", DHXDataFormat.JSON);
    	//s.data.dataprocessor.setURL("department_events");
    	s.load("department_events", DHXDataFormat.JSON);
    	s.data.dataprocessor.setURL("department_events");
    	
    	s.config.setDetailsOnCreate(true);
    	s.config.setDetailsOnDblClick(true);

    	// lightbox configuring
    	//with the following line we could adjust the timepicker of the lightbox: if a 5 minute interval is too much. 
    	//as parameter we have to set the according css file
    	//s.templates.setTimePicker(value);
    	//planner.templates.time_picker = function(date){
    	//	return planner.date.date_to_str(planner.config.hour_date);
    	//};
    	s.lightbox.get("description").setHeight(30);
  
    	
    	
    	//TO DO: if WeekAgendaView isnt appropriate, uncomment the following line again. 
    	//s.views.add(new DHXAgendaView());//initializes the view
    	
    
    	DHXWeekAgendaView view2 = new DHXWeekAgendaView();//initializes the view
    	view2.setLabel("Agenda");// the name of the tab
    	s.views.add(view2);
    	
    	//s.setInitialView("agenda");//adds the view to the Java calendar control
    	
    	s.views.getView(3).setTabWidth(42);
    	//DHXAgendaView agenda = (DHXAgendaView) s.views.getView(3);
    	//agenda.setStartDate(today);
    	//set end date to one year in the future!!
    	//it is important to add +1 to month, since Calender.MONTH goes from 0 to 11 and not from 1 to 12
    	//agenda.setEndDate(cal.YEAR+1, cal.MONTH+1, cal.DAY_OF_MONTH);
    	//s.views.add(agenda);
    	

    	
    	DHXGridView view = new DHXGridView();
    	view.setTabWidth(30);
    	//view.setTabPosition(5);
    	DHXGridViewColumn column0 = new DHXGridViewColumn("text", "Text");
    	DHXGridViewColumn column1 = new DHXGridViewColumn("start_date", "Start date", 150);
    	DHXGridViewColumn column2 = new DHXGridViewColumn("end_date", "End date", 150);
    	column0.setSorting(DHXGridViewColumn.Sort.DATE);
    	column1.setSorting(DHXGridViewColumn.Sort.DATE);
    	column2.setSorting(DHXGridViewColumn.Sort.DATE);
    	view.addOption(column0);
    	view.addOption(column1);
    	view.addOption(column2);
    	//view.addOption(new DHXGridViewColumn("text", "Text"));
    	//view.addOption(new DHXGridViewColumn("start_date", "Start date", 150));
    	//view.addOption(new DHXGridViewColumn("end_date", "End date", 150));
    	view.setFrom(cal.YEAR, cal.MONTH+1, cal.DAY_OF_MONTH);
    	s.views.add(view);
    	
    	//following line would attach the miniCalendar to the HDXPlanner, but I could not figure out how to adjust the planner position
    	//by default, this position would be next to the month view, on the same spot as the week agenda view, since it would overlap, I have not implemented it yet. 
    	//s.calendars.attachMiniCalendar();
    	s.lightbox.add(new DHXLightboxMiniCalendar("cal", "Time period"));
    	
    	//PDF export functionality:
    	s.toPDF();
    	
    	ModelAndView mnv = new ModelAndView(Constant.CALENDAR_ARTICLE);
    	mnv.addObject("title", "Scheduler - Personal plus Department Events");
    	mnv.addObject("sample_name", "Department Calendar");
    	if (managerRole)
    	{
    		mnv.addObject("sample_dsc", "In this page you can view your events and department wide events. Events created on this page will be added to the department events for every department employee to see. " + calendarNote);
    	} else {
    		mnv.addObject("sample_dsc", "In this page you can view your events and department wide events. Employees are not allowed to create department wide events. Created events will be stored in the personal calendar. " + calendarNote);
    	}
    	
		mnv.addObject("body", s.render());

        return mnv;
    }
	
	
	//@RequestMapping({"/calendar/03_saving.html", "/calendar/showCalendar"})
	@RequestMapping("calendar/showCalendarPersonal")
    public ModelAndView scheduler_03(HttpServletRequest request) throws Exception {
		
		
    	DHXPlanner s = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
    	//s.setInitialDate(2013, 1, 7);
    	s.setInitialDate(today);
    	s.config.setScrollHour(8);
    	s.setWidth(900);
    	
    	//TO DO:
    	//Now, the standard event_class was edited in the dhtmlxscheduler.js: events are either blue or red, depends on whether the department_visibility of the event is true or false
    	
    
    	s.load("calendar_events", DHXDataFormat.JSON);
    	s.data.dataprocessor.setURL("calendar_events");
    	s.config.setDetailsOnCreate(true);
    	s.config.setDetailsOnDblClick(true);

    	// lightbox configuring
    	s.lightbox.get("description").setHeight(30);
    	
    	//DHXAgendaView viewAgenda = new DHXAgendaView();
    	//s.views.getView(3).setTabPosition(50);
    	//viewAgenda.setTabWidth(42);
    	//s.views.add(new DHXAgendaView());
    	//s.views.add(viewAgenda);
    	//s.setInitialView("agenda");
    	//s.setInitialView("agenda");
    	
    	//s.views.add(new DHXAgendaView());//initializes the view
    	
    	
    	DHXWeekAgendaView view2 = new DHXWeekAgendaView();//initializes the view
    	view2.setLabel("Agenda");// the name of the tab
    	s.views.add(view2);
    	
    	//s.setInitialView("agenda");//adds the view to the Java calendar control
    	
    	s.views.getView(3).setTabWidth(42);
    	//DHXAgendaView agenda = (DHXAgendaView) s.views.getView(3);
    	//DHXWeekAgendaView agenda = (DHXWeekAgendaView) s.views.getView(3);
    	//agenda.setStartDate(today);
    	//set end date to one year in the future!!
    	//it is important to add +1 to month, since Calender.MONTH goes from 0 to 11 and not from 1 to 12
    	//agenda.setEndDate(cal.YEAR+1, cal.MONTH+1, cal.DAY_OF_MONTH);
    	//s.views.add(agenda);
    	
    	//s.calendars.attachMiniCalendar();
    	//s.lightbox.add(new DHXLightboxMiniCalendar("cal", "Time period"));

    	
    	
    	DHXGridView view = new DHXGridView();
    	view.setTabWidth(30);
    	//view.setTabPosition(5);
    	DHXGridViewColumn column0 = new DHXGridViewColumn("text", "Text");
    	DHXGridViewColumn column1 = new DHXGridViewColumn("start_date", "Start date", 150);
    	DHXGridViewColumn column2 = new DHXGridViewColumn("end_date", "End date", 150);
    	column0.setSorting(DHXGridViewColumn.Sort.DATE);
    	column1.setSorting(DHXGridViewColumn.Sort.DATE);
    	column2.setSorting(DHXGridViewColumn.Sort.DATE);
    	view.addOption(column0);
    	view.addOption(column1);
    	view.addOption(column2);
    	//view.addOption(new DHXGridViewColumn("text", "Text"));
    	//view.addOption(new DHXGridViewColumn("start_date", "Start date", 150));
    	//view.addOption(new DHXGridViewColumn("end_date", "End date", 150));
    	view.setFrom(cal.YEAR, cal.MONTH+1, cal.DAY_OF_MONTH);
    	s.views.add(view);
    	
    	//s.calendars.attachMiniCalendar();
    	s.lightbox.add(new DHXLightboxMiniCalendar("cal", "Time period"));
    	
    	//PDF export functionality:
    	s.toPDF();
    	
    	ModelAndView mnv = new ModelAndView(Constant.CALENDAR_ARTICLE);
    	mnv.addObject("title", "Scheduler - Personal Events");
    	mnv.addObject("sample_name", "Personal Events");
    	mnv.addObject("sample_dsc", "In this page you can view, add, edit and delete personal events. Those events will be stored for later use." + calendarNote);
		mnv.addObject("body", s.render());
		mnv.addObject("username", testUser);
        return mnv;
    }

    
    
    @RequestMapping("/calendar/department_events")
    @ResponseBody public String departmentEvents(HttpServletRequest request) {
    	User currentUser = getCurrentUser(request);
    	
    	Employee currentEmployee = employeeDao.findEmployeeByUserName(currentUser.getUsername());
    	//Employee currentEmployee = (Employee) employeeDao.findEmployeeByUserName(currentUser.getUsername());
    	String currentDepartment;
    	try {
    		currentDepartment= currentEmployee.getDepartment().getName();
    		System.out.println("department: ----  " + currentDepartment);
    	} catch (Exception e) {
    		//we get an exception, when an employee has no department, so wet set an default value:
    		currentDepartment = "";
    	}
    	
    	//String currentDepartment = "default department";
    	boolean managerRole = hasRole(currentUser, Constant.ROLE_MANAGER);
    	//if the managerRole == true, the user creates department wide events in that view
    	//boolean setDepartmentEvents = false;
    	//if (managerRole) {	setDepartmentEvents  = true;}
    	System.out.println("department: ----  " + currentDepartment);
    	System.out.println("hasManagerRole: ----  " + managerRole);
    	System.out.println("createPublicDepartmentEvent: ----  " + managerRole);
    	//CustomEventsManagerV2 evs = new CustomEventsManagerV2(request);
    	CustomDepartmentWideEventsManager evs = new CustomDepartmentWideEventsManager(request, managerRole, currentDepartment);
    	//following line handles the security - must be logged in as user to perform database changes?
    	evs.security.can(DHXStatus.UPDATE);
    	evs.security.can(DHXStatus.INSERT);
    	evs.security.can(DHXStatus.DELETE);
    	return evs.run();
    }
    
    @RequestMapping("/calendar/calendar_events")
    @ResponseBody public String calendarEvents(HttpServletRequest request) {
    	User currentUser = getCurrentUser(request);
    	
    	Employee currentEmployee = employeeDao.findEmployeeByUserName(currentUser.getUsername());
    	//Employee currentEmployee = (Employee) employeeDao.findEmployeeByUserName(currentUser.getUsername());
    	String currentDepartment;
    	try {
    		currentDepartment= currentEmployee.getDepartment().getName();
    		System.out.println("department: ----  " + currentDepartment);
    	} catch (Exception e) {
    		//we get an exception, when an employee has no department, so wet set an default value:
    		currentDepartment = "";
    	}
    	
    	CustomEventsManagerV2 evs = new CustomEventsManagerV2(currentDepartment, request);
    	
    	//following line handles the security - must be logged in as user to perform database changes?
    	evs.security.can(DHXStatus.UPDATE);
    	evs.security.can(DHXStatus.INSERT);
    	evs.security.can(DHXStatus.DELETE);
    	return evs.run();
    }
    
    @RequestMapping("/calendar/events_read_only")
    @ResponseBody public String eventsReadOnly(HttpServletRequest request) {
    	System.out.println("events_read_only called");
    	System.out.println("events_read_only_request_parameter username:   " + request.getParameter("username")); //requestParameter username not available anymore in the next request. 
    	//the following code is not working here, because a set requestParameter is only retrievable at the direct server side machine. if this server sends a new request to another
    	//computer, the parameter is lost. so we write the user parameter for the read only view in a document global variable - testUser
    	/*
    	testUser = request.getParameter("username");
    	if (testUser == null || testUser == "null") {
    		testUser = "admin";
    	}
    	*/
    	System.out.println("testUser_events_read_only: " + testUser);
    	
    	CustomEventsManagerV2 evs = new CustomEventsManagerV2(request, testUser);
    	//following line handles the security - must be logged in as user to perform database changes?
    	evs.security.deny(DHXStatus.UPDATE);
    	evs.security.deny(DHXStatus.INSERT);
    	evs.security.deny(DHXStatus.DELETE);
    	return evs.run();
    }

}
