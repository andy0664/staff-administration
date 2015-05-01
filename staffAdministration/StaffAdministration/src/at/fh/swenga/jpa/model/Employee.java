package at.fh.swenga.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 6258273242561430139L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//add unique=true
	 @Column(nullable=false)
	private int ssn;

	 @Column(nullable=false, length=250)
	private String firstName;

	 @Column(nullable=false, length=250)
	private String lastName;

	@NotNull(message = "{0} is required")
//	@Past(message = "{0} must be in the past")
	@Temporal(TemporalType.DATE)
	private Date dayOfBirth;

	@Embedded
	private Address address;

	@Column(nullable=false, length=250)
	private String jobDescription;

	@NotNull(message = "{0} is required")
	private float salary;

	@NotNull(message = "{0} is required")
//	@Past(message = "{0} must be in the past")
	@Temporal(TemporalType.DATE)
	private Date dayOfEntry;

	@NotNull(message = "{0} is required")
	private int role;

	@Version
	private long version;

	public Employee() {
	}

	

	public Employee(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry, int role) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.dayOfEntry = dayOfEntry;
		this.role = role;
	}


	public int getId() {
		return id;
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



	public float getSalary() {
		return salary;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	public Date getDayOfEntry() {
		return dayOfEntry;
	}



	public void setDayOfEntry(Date dayOfEntry) {
		this.dayOfEntry = dayOfEntry;
	}



	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}

	
	public void updateEmployee(Employee emp){
		this.ssn=emp.getSsn();
		this.firstName=emp.firstName;
		this.lastName=emp.lastName;
		this.dayOfBirth=emp.getDayOfBirth();
		this.address=emp.getAddress();
		this.jobDescription=emp.getJobDescription();
		this.dayOfEntry=emp.getDayOfEntry();
		this.salary=emp.getSalary();
		this.role=emp.getRole();
	}
	
	
}
