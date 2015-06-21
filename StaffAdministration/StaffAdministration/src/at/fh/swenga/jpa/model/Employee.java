package at.fh.swenga.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.support.Constant;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 6258273242561430139L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//add unique=true
//	@Column(nullable=false)
	@Column(nullable=false, unique=true)
	private int ssn;

	 @Column(nullable=false)
	private String firstName;

	 @Column(nullable=false)
	private String lastName;

	@NotNull(message = "{0} is required")
	@Past(message = "{0} must be in the past")
	@Temporal(TemporalType.DATE)
	private Date dayOfBirth;

	@Embedded
	private Address address;

	@Column(nullable=false)
	private String jobDescription;

	@NotNull(message = "{0} is required")
	private float salary;
	
	@Column(unique=true)
	private String mail;
	
	@Column(unique=true)
	private String phone;

	@NotNull(message = "{0} is required")
	@Temporal(TemporalType.DATE)
	private Date dayOfEntry;

	private String role;
	
	private String status=Constant.STATUS_AVAILABLE;
	
	@Column(unique=true)
	private String userName;
	
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade=CascadeType.ALL)
	private Set<UserRole> userRoles;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.REMOVE)
	private Set<TimeRecord> timeRecords;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	private Set<Announcement> announcementsManager;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade=CascadeType.ALL)
	private Set<Announcement> announcementsEmployee;
	
	@Version
	private long version;



	public Employee() {
	}

	public Employee(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry, int role, Department department, String username) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.dayOfEntry = dayOfEntry;
//		this.role = role;
		this.department=department;
		this.userName=username;
	}

	public Employee(int ssn, String firstName, String lastName,
			Date dayOfBirth, Address address, String jobDescription,
			float salary, Date dayOfEntry,String username, String password,String eMail, String phone) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.jobDescription = jobDescription;
		this.salary = salary;
		this.dayOfEntry = dayOfEntry;
		this.userName=username;
		this.password=password;
		this.mail=eMail;
		this.phone=phone;
//		this.role = role;
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

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

//	public int getRole() {
//		return role;
//	}
//
//
//
//	public void setRole(int role) {
//		this.role = role;
//	}
	
	public Department getDepartment() {
		return department;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserRole> getUserRole() {
		return userRoles;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRoles = userRole;
	}
	
	
	public void addUserRole(UserRole role){
		if(userRoles==null){
			userRoles=new HashSet<UserRole>();
		}
		userRoles.add(role);
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<TimeRecord> getTimeRecords() {
		return timeRecords;
	}

	public void setTimeRecords(Set<TimeRecord> timeRecords) {
		this.timeRecords = timeRecords;
	}
	
	public void addTimeRecord(TimeRecord record){
		if(timeRecords==null){
			timeRecords=new HashSet<TimeRecord>();
		}
		timeRecords.add(record);
	}
	
	
	
	public String getMail() {
		return mail;
	}

	public void seteMail(String eMail) {
		this.mail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Announcement> getAnnouncmentsEmployee() {
		return announcementsEmployee;
	}

	public void setAnnouncmentsEmployee(Set<Announcement> announcments) {
		this.announcementsEmployee = announcments;
	}
	
	public void addAnnouncementEmployee(Announcement announcement){
		if(announcementsEmployee==null){
			announcementsEmployee = new HashSet<Announcement>();
		}
		announcementsEmployee.add(announcement);
	}
	
	public Set<Announcement> getAnnouncmentsManager() {
		return announcementsManager;
	}

	public void setAnnouncmentsManager(Set<Announcement> announcments) {
		this.announcementsManager = announcments;
	}
	
	public void addAnnouncementManager(Announcement announcement){
		if(announcementsManager==null){
			announcementsManager = new HashSet<Announcement>();
		}
		announcementsManager.add(announcement);
	}

	public void updateEmployee(EmployeeDTO emp){
//		emp.sanitize();
		this.ssn=emp.getSsn();
		this.firstName=emp.getFirstName();
		this.lastName=emp.getLastName();
		this.dayOfBirth=emp.getDayOfBirth();
		this.address=emp.getAddress();
		this.jobDescription=emp.getJobDescription();
		this.dayOfEntry=emp.getDayOfEntry();
		this.salary=emp.getSalary();
//		this.role=emp.getRole();
		if(emp.getUserName()!=null){
			this.userName=emp.getUserName();
		}
		this.mail=emp.getMail();
		this.phone=emp.getPhone();
//		if(!"".equals(emp.getPassword())){
//			this.password=emp.getPassword();
//		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}
