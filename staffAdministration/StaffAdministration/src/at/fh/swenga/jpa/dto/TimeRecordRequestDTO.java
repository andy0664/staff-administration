package at.fh.swenga.jpa.dto;

import java.util.Date;

public class TimeRecordRequestDTO {
	
	private int employee;
	private Date dateFrom;
	private Date dateTo;
	
	public TimeRecordRequestDTO() {
	}
	
	

	public TimeRecordRequestDTO(int employee, Date dateFrom, Date dateTo) {
		this.employee = employee;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}



	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	

}
