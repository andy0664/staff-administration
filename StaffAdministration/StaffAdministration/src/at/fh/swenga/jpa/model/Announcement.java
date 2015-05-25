package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String subject;
	private String message;
	private int notRead;

	@Temporal(TemporalType.DATE)
	private Date day;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId", nullable = false)
	private Employee manager;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	private boolean enabled = true;

	@Version
	private long version;

	public Announcement() {
	}

	// Constructor for every year Announcments
	public Announcement(String subject, String message, int notRead,
			Employee manager, Employee employee) {
		this.subject = subject;
		this.message = message;
		this.notRead = notRead;
		this.manager = manager;
		this.employee = employee;
	}

	// Constructor for only once Announcments
	public Announcement(String subject, String message, Date date,
			Employee manager, Employee employee) {
		this.subject = subject;
		this.message = message;
		this.day = date;
		this.manager = manager;
		this.employee = employee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNotRead() {
		return notRead;
	}

	public void setNotRead(int notRead) {
		this.notRead = notRead;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
