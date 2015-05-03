package at.fh.swenga.jpa.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import at.fh.swenga.jpa.model.TimeRecord;

public class TimeRecordDTO {
	

	private Date startDate;
	
	private Date endDate;

	private String startTime;
	

	private String endTime;

	private String typ;
	
	public TimeRecordDTO() {
	}
	
//	public TimeRecordDTO(Date startDate, Date endDate, Date startTime,
//			Date endTime, String typ) {
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.typ = typ;
//	}
	
	public TimeRecordDTO(Date startDate, Date endDate, String startTime,
			String endTime, String typ) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.typ = typ;
	}

	
//
//	public Date getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(Date startTime) {
//		this.startTime = startTime;
//	}
//
//	public Date getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(Date endTime) {
//		this.endTime = endTime;
//	}
	
	



	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public TimeRecord generateTimeRecord(){
		return new TimeRecord(startDate,endDate, parseTime(startTime),parseTime(endTime),typ);
	}
	
	private Date parseTime(String time){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		try {
			return timeFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
