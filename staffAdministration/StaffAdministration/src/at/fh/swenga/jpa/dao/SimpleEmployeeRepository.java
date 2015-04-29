package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.jpa.model.Employee;

public interface SimpleEmployeeRepository extends
		JpaRepository<Employee, Integer> {
	
	
	public Employee findEmployeeById(int id);

}
