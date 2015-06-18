package at.fh.swenga.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Version;

import at.fh.swenga.jpa.dto.DepartmentDTO;



@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = -5284027148643593640L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	//add unique=true
	@Column(nullable=false,unique=true, length=5)
	private String shortcut;
	
	@OneToMany(mappedBy="department")
	private Set<Employee> employees;
	
	@OneToOne
	private Employee manager;
	
	@Version
	private long version;
	
	public Department() {
	}
	
	public Department(String name, String shortcut) {
		this.name = name;
		this.shortcut = shortcut;
	}
	
	
	public Department(String name, String shortcut, Employee manager) {
		this.name = name;
		this.shortcut = shortcut;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
	
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee){
		if(employees==null){
			employees=new HashSet<Employee>();
		}
		employees.add(employee);
	}

	public void updateDepartment(DepartmentDTO dep){
		dep.sanitize();
		this.name=dep.getName();
		this.shortcut=dep.getShortcut();
	}
}
