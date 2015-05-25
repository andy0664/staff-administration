package at.fh.swenga.jpa.dto;

import at.fh.swenga.jpa.model.Department;

public class DepartmentDTO {

	private String name;
	private String shortcut;

	public DepartmentDTO() {
	}
	
	public DepartmentDTO(String name, String shortcut) {
		this.name = name;
		this.shortcut=shortcut;
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
	
	public Department generateDepartment(){
		return new Department(this.name,this.shortcut);
	}
	
	
}
