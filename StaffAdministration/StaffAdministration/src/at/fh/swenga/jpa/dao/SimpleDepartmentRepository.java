package at.fh.swenga.jpa.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.model.Department;

@Repository
@Transactional
public interface SimpleDepartmentRepository extends JpaRepository<Department, Integer>{

	public Department findDepartmentById(int id);
	
}
