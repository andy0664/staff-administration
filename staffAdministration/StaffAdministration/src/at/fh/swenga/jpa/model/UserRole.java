package at.fh.swenga.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class UserRole implements Serializable {

	private static final long serialVersionUID = -2229232044706691740L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String role;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmployee", nullable = false)
	private Employee employee;
	
	public UserRole() {
	}
	
	public UserRole(String role,Employee employee) {
		this.role = role;
		this.employee=employee;
	}

	
	
	public void setId(int userRoleId) {
		this.id = userRoleId;
	}

	public Integer getId() {
		return id;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
