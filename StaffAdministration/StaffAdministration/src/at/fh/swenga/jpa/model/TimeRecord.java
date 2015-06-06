package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class TimeRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "{0} is required")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message = "{0} is required")
	private Date endDate;
	
	@Temporal(TemporalType.TIME)
	@NotNull(message = "{0} is required")
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@NotNull(message = "{0} is required")
	private Date endTime;
	
	@Column(nullable=false)
	private String typ;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Employee employee;
	
	@Version
	private long version;

	public TimeRecord() {
	}
	
	public TimeRecord(Date startDate, Date endDate, Date startTime,
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
