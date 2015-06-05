package at.fh.swenga.jpa.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.SimpleAnnouncementRepository;
import at.fh.swenga.jpa.dao.SimpleDepartmentRepository;
import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleNewsRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dao.SimpleUserRoleRepository;
import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;

@Controller
public class AnnouncementController {
	
	@Autowired
	private SimpleEmployeeRepository employeeDao;

	@Autowired
	private SimpleDepartmentRepository departmentDao;

	@Autowired
	private SimpleTimeRecordRepository timeRecordDao;

	@Autowired
	private SimpleNewsRepository newsRepository;

	@Autowired
	private SimpleUserRoleRepository userRoleRepository;
	
	@Autowired
	private SimpleAnnouncementRepository announcementDao;

	@Autowired
	private ControllerSupport controllerSupport;
	
	
	@RequestMapping(value={"acceptBirthday"})
	public String acceptBirthday(@RequestParam int announcement, Model model){
		Announcement announce = announcementDao.findOne(announcement);
		announce.setDay(controllerSupport.updateAnnouncementYear(announce.getDay(), 1));
		announcementDao.save(announce);
		return "forward:start";
	}
	
	
	@RequestMapping(value={"denyVacation"})
	public String denyVacation(@RequestParam int announcement, Model model){
		Announcement announce = announcementDao.findOne(announcement);
		int timeRecord = announce.getNotRead();
		timeRecordDao.delete(timeRecord);
		announce.setNotRead(0);
		announcementDao.save(announce);
		return "forward:start";
	}
	
	
	@RequestMapping(value={"acceptVacation"})
	public String acceptVacation(@RequestParam int announcement, Model model){
		setRead(announcement);
		return "forward:start";
	}
	
	
	@RequestMapping(value={"acceptChangeRequest"})
	public String acceptChangeRequest(@RequestParam int announcement, Model model){
		setRead(announcement);
		return "forward:start";
	}
	
	private void setRead(int announcement){
		Announcement announce = announcementDao.findOne(announcement);
		announce.setNotRead(0);
		announcementDao.save(announce);
	}
}
