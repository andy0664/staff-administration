package at.fh.swenga.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int ssn;
	
	@Column(nullable=false, length=250)
	private String firstName;
	
	@Column(nullable=false, length=250)
	private String lastName;
	
	@NotNull(message = "{0} is required")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past(message = "{0} must be in the past")
	private Date dayOfBirth;
	
	@Embedded
	private Address address;
	
	@Column(nullable=false, length=250)
	private String jobDescription;
	
	@NotNull(message = "{0} is required")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past(message = "{0} must be in the past")
	private Date entryDate;
	
	@NotNull
	private int role;
	
	@Version
	private long version;
	
	public Employee() {
	}

	public Employee(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			Date entryDate, int role) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.jobDescription = jobDescription;
		this.entryDate = entryDate;
		this.role = role;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
