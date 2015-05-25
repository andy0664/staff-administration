package at.fh.swenga.jpa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import at.fh.swenga.jpa.model.Employee;
import at.fh.swenga.jpa.model.UserRole;

public interface SimpleUserRoleRepository extends JpaRepository<UserRole, Integer> {
	

	public List<UserRole> findByEmployee(Employee emp);
	
	
}
