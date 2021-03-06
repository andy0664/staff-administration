package at.fh.swenga.jpa.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.model.Department;

@Repository
@Transactional
public interface SimpleDepartmentRepository extends JpaRepository<Department, Integer>{

	public Department findDepartmentById(int id);
	
	@Query("select d from Department d where d.shortcut=:shortcut and d.id !=:id")
	public Department checkUniqueShortcut(@Param("shortcut") String shortcut, @Param("id") int id);
	
}
