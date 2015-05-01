package at.fh.swenga.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;



@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = -5284027148643593640L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, length=200)
	private String name;
	
	//add unique=true
	@Column(nullable=false,length=5)
	private String shortcut;
	
	@Version
	private long version;
	
	public Department() {
	}
	
	public Department(String name, String shortcut) {
		this.name = name;
		this.shortcut = shortcut;
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
	
	public void updateDepartment(Department dep){
		this.name=dep.getName();
		this.shortcut=dep.shortcut;
	}
}
