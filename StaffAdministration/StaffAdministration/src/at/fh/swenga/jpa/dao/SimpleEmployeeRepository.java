package at.fh.swenga.jpa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.dto.EmployeeDTO;
import at.fh.swenga.jpa.model.Employee;

@Repository
@Transactional
public interface SimpleEmployeeRepository extends
		JpaRepository<Employee, Integer> {
	
	
	public List<Employee> findEmployeeById(int id);
	
	//@Query("select new at.fh.swenga.jpa.dto.EmployeeDTO(e.id, e.firstname,e.lastname) from Employee e where e.department is null")
	@Query("select e from Employee e where e.department is null")
	public List<Employee> findEmployeeWithNoDepartment();
	public List<Employee> findEmployeeByOrderByDepartmentId();
	public List<Employee> findEmployeeByDepartmentId(int depId);
	public Employee findEmployeeByUserName(String username);
	public Employee findEmployeeByRole(String role);
	
	@Query("select e from Employee e where e.ssn =:ssn and e.id !=:id")
	public Employee checkUniqueSSN(@Param("ssn") int ssn, @Param("id") int id);
	
	@Query("select e from Employee e where e.mail =:mail and e.id !=:id")
	public Employee checkUniqueMail(@Param("mail") String mail, @Param("id") int id);
	
	@Query("select e from Employee e where e.phone =:phone and e.id !=:id")
	public Employee checkUniquePhone(@Param("phone") String phone, @Param("id") int id);
	
	@Query("select e from Employee e where e.userName =:username and e.id !=:id")
	public Employee checkUniqueUserName(@Param("username") String username, @Param("id") int id );
	
	@Modifying
	@Query("update Employee e set e.status=:status where e.userName=:username")
	public int updateEmployeeStatus(@Param("username") String username, @Param("status") String status);
	
	@Query("select e from Employee e where e.id=(Select d.manager from Department d where d.id=:employeDepartment)")
	public Employee findManagerFromEmployee(@Param("employeDepartment")int employeDepartment);
	
	@Query("select e from Employee e where e.department=(Select ie.department from Employee ie where ie.userName=:managerUserName)")
	public List<Employee> findEmployeeFromManager(@Param("managerUserName") String userName);

}
