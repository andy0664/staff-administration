package at.fh.swenga.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.jpa.model.Department;

public interface SimpleDepartmentRepository extends JpaRepository<Department, Integer>{

	public Department findDepartmentById(int id);
	
}
