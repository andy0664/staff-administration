package at.fh.swenga.jpa.controller.calendar;

import javax.servlet.http.HttpServletRequest;

import at.fh.swenga.jpa.constant.Constant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.extensions.DHXExtension;

@Controller
public class SimpleInitController {

	//@RequestMapping({"/01_simple_init.html", "/index", "/"})
	//@RequestMapping({"/01_simple_init.html","/showCalendar"})
	@RequestMapping({"01_simple_init.html", "/showCalendar"})
    public ModelAndView scheduler_01(HttpServletRequest request) throws Exception {
    	// creates and configures scheduler instance
    	DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
    	s.setInitialDate(2013, 1, 7);
    	s.config.setScrollHour(8);
    	s.setWidth(900);

    	// sets events set
    	CustomEventsManager evs = new CustomEventsManager(request);
    	s.parse(evs.getEvents());

    	ModelAndView mnv = new ModelAndView(Constant.CALENDAR_ARTICLE);
    	mnv.addObject("title", "Scheduler - Calendar");
    	mnv.addObject("sample_name", "Your calendar");
    	mnv.addObject("sample_dsc", "This calendar has 3 default views: Day, Week, Month. You can add, edit, delete events but when you reload the page all changes will be lost.");
    	// puts scheduler code in view
		mnv.addObject("body", s.render());

        return mnv;
    }
	
}
