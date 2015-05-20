package at.fh.swenga.jpa.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.jpa.dao.SimpleEmployeeRepository;
import at.fh.swenga.jpa.dao.SimpleTimeRecordRepository;
import at.fh.swenga.jpa.dto.TimeRecordDTO;
import at.fh.swenga.jpa.dto.TimeRecordRequestDTO;
import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.TimeRecord;
import at.fh.swenga.jpa.support.Constant;
import at.fh.swenga.jpa.support.ControllerSupport;
import at.fh.swenga.jpa.support.DateTimeEditor;

@Controller
public class TimeRecordController {
	
	
	@Autowired
	private SimpleEmployeeRepository employeeDao;


	@Autowired
	private SimpleTimeRecordRepository timeRecordDao;
	
	@Autowired
	private ControllerSupport controllerSupport;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateTimeEditor());
	}
	
	/*
	 * ########### listTimeRecords.jsp ############
	 */
	@Transactional
	@RequestMapping(value = { "timeRecordEmployee" })
	public String timeRecordManagerView(
			@Valid @ModelAttribute TimeRecordRequestDTO request,
			BindingResult bindingResult, Model model) {
		if (!controllerSupport.checkBinding(bindingResult, model)) {
			return prepareTimeRecordManager(request, model);
		}
		return Constant.PAGE_LIST_TIME_RECORDS;
	}
	
	@Transactional
	@RequestMapping(value = { "timeRecordEmployees" })
	public String timeRecordManagerViewForAllEmployees(
			@Valid @ModelAttribute TimeRecordRequestDTO request,
			BindingResult bindingResult, Model model) {
		if (!controllerSupport.checkBinding(bindingResult, model)) {
			model.addAttribute(Constant.KEY_EMPLOYEE_LIST, employeeDao.findAll());
			return prepareTimeRecordManager(request, model);
		}
		return Constant.PAGE_LIST_TIME_RECORDS;
	}

	@Transactional
	@RequestMapping(value = { "deleteTimeRecord" })
	public String deleteTimeRecord(@RequestParam int timerecord,
			@RequestParam int id, @RequestParam Date dateFrom,
			@RequestParam Date dateTo, Model model) {
		try {
			timeRecordDao.delete(timerecord);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute(Constant.KEY_ERROR_MESSAGE,
					"Couldn't delete timerecord");
		}
		return prepareTimeRecordManager(new TimeRecordRequestDTO(id, dateFrom,
				dateTo), model);
	}

	@Transactional
	@RequestMapping(value = { "timeRecordExcelExport" })
	public String timeRecordExcelExport(
			@Valid @ModelAttribute TimeRecordRequestDTO request,
			BindingResult bindingResult, Model model) {
		if (!controllerSupport.checkBinding(bindingResult, model)) {
			Map<Employee, List<TimeRecord>> timeRecords = new HashedMap<Employee, List<TimeRecord>>();
			Employee emp = employeeDao.findEmployeeById(request.getEmployee());
			List<TimeRecord> records = timeRecordDao
					.findRecordsByEmployeeIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByStartDate(
							request.getEmployee(), request.getDateFrom(),
							request.getDateTo());
			timeRecords.put(emp, records);
			model.addAttribute(Constant.KEY_TIME_RECORD_LIST, timeRecords);
			return Constant.CLASS_EXPORT_TIME_RECORD;
		}
		return Constant.PAGE_LIST_TIME_RECORDS;

	}
	
	/*
	 * ########### editTimeRecord.jsp ############
	 */

	@Transactional
	@RequestMapping(value = { "addTimeRecord" }, method = RequestMethod.POST)
	public String addTimeRecord(@Valid @ModelAttribute TimeRecordDTO newRecord,
			@RequestParam int employee, Model model, BindingResult bindingResult) {
		if (controllerSupport.checkBinding(bindingResult, model)) {
			return "forward:/start";
		}
		Employee emp = employeeDao.findEmployeeById(employee);
		TimeRecord record = newRecord.generateTimeRecord();
		record.setEmployee(emp);
		timeRecordDao.save(record);
		return Constant.PAGE_INDEX;
	}


	private String prepareTimeRecordManager(TimeRecordRequestDTO request,
			Model model) {
		List<TimeRecord> list = timeRecordDao
				.findRecordsByEmployeeIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByStartDate(
						request.getEmployee(), request.getDateFrom(),
						request.getDateTo());
		model.addAttribute(Constant.KEY_TIME_RECORD_LIST, list);
		model.addAttribute(Constant.KEY_TIME_RECORD_DATE_FROM,
				request.getDateFrom());
		model.addAttribute(Constant.KEY_TIME_RECORD_DATE_TO,
				request.getDateTo());
		model.addAttribute(Constant.KEY_EMPLOYEE,
				employeeDao.findEmployeeById(request.getEmployee()));
		return Constant.PAGE_LIST_TIME_RECORDS;
	}
	
}