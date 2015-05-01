package at.fh.swenga.jpa.dto;

import java.util.Date;

import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;

public class EmployeeDTO {

	private int ssn;

	private String firstName;

	private String lastName;
	private Date dayOfBirth;
	private Address address;
	private String jobDescription;
	private float salary;
	private Date dayOfEntry;
	private int role;
	private int department;

	public EmployeeDTO() {
	}

	public EmployeeDTO(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry, int role, int department) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.dayOfEntry = dayOfEntry;
		this.role = role;
		this.department = department;
	}

	public EmployeeDTO(int ssn, String firstName, String lastName,
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

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}
	
	public Employee generateEmployee() {
		return new Employee(ssn, firstName, lastName, dayOfBirth, address,
				jobDescription, salary,dayOfEntry, role);
	}

}
