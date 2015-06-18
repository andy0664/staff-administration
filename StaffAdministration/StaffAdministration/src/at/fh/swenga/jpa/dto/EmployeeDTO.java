package at.fh.swenga.jpa.dto;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import at.fh.swenga.jpa.model.Address;
import at.fh.swenga.jpa.model.Department;
import at.fh.swenga.jpa.model.Employee;

public class EmployeeDTO {

	private int id;
	private int ssn;

	private String firstName;

	private String lastName;
	private String userName;
	private Date dayOfBirth;
	private Address address;
	private String jobDescription;
	private float salary;
	private Date dayOfEntry;
	private String role;
	private int department;
	private String password;
	private String mail;
	private String phone;

	public EmployeeDTO() {
	}

	public EmployeeDTO(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry, String role, int department, String mail, String phone) {
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
		this.mail=mail;
		this.phone=phone;
	}

	public EmployeeDTO(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry, String role,String password) {
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
	
	
	public EmployeeDTO(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void sanitize() {
		this.firstName=Jsoup.clean(this.firstName,Whitelist.simpleText());
		this.lastName=Jsoup.clean(this.lastName,Whitelist.simpleText());
		this.jobDescription=Jsoup.clean(this.jobDescription,Whitelist.simpleText());
		this.mail=Jsoup.clean(this.mail,Whitelist.simpleText());
		this.phone=Jsoup.clean(this.phone,Whitelist.simpleText());
		this.userName=Jsoup.clean(this.userName,Whitelist.simpleText());
	}

	public Employee generateEmployee() {
		sanitize();
		return new Employee(ssn, firstName, lastName, dayOfBirth, address,
				jobDescription, salary,dayOfEntry,userName,password,mail,phone);
	}

}
