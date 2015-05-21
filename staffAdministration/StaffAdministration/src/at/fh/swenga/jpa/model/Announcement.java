package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Announcement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String subject;
	private String message;
	private int notRead;
	private int month;
	private int day;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="managerId", nullable=false)
	private Employee manager;
	
	@Version
	private long version;
	
	public Announcement() {
	}
	
	//Constructor for every year Announcments
	public Announcement(String subject, String message, int month, int day,
			Employee manager) {
		this.subject = subject;
		this.message = message;
		this.month = month;
		this.day = day;
		this.manager = manager;
	}
	
	//Constructor for only once Announcments
	public Announcement(String subject, String message, int notRead,
			Employee manager) {
		this.subject = subject;
		this.message = message;
		this.notRead = notRead;
		this.manager = manager;
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
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
}
