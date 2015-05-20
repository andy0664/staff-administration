package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.model.Employee;

public interface SimpleEmployeeRepository extends
		JpaRepository<Employee, Integer> {
	
	
	public Employee findEmployeeById(int id);
	
	//@Query("select new at.fh.swenga.jpa.dto.EmployeeDTO(e.id, e.firstname,e.lastname) from Employee e where e.department is null")
	@Query("select e from Employee e where e.department is null")
	public List<Employee> findEmployeeWithNoDepartment();
	public List<Employee> findEmployeeByOrderByDepartmentId();
	public List<Employee> findEmployeeByDepartmentId(int depId);
	public Employee findByUserName(String username);
	
	@Modifying
	@Query("update Employee e set e.status=:status where e.userName=:username")
	public int updateEmployeeStatus(@Param("username") String username, @Param("status") String status);

}
