package at.fh.swenga.jpa.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import at.fh.swenga.jpa.model.TimeRecord;

public class TimeRecordDTO {

	private Date startDate;

	private Date endDate;

	private Date startTime;

	private Date endTime;

	private String typ;

	public TimeRecordDTO() {
	}
	
	public TimeRecordDTO(Date startDate, Date endDate, Date startTime,
			Date endTime, String typ) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.typ = typ;
	}


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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public TimeRecord generateTimeRecord() {
		return new TimeRecord(startDate, endDate, startTime,
				endTime, typ);
	}
}
