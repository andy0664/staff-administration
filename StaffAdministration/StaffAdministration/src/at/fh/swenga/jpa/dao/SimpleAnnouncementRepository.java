package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.model.Employee;

@Repository
@Transactional
public interface SimpleAnnouncementRepository extends
		JpaRepository<Announcement, Integer> {

	public List<Announcement> findAnnouncementByManagerAndEnabledTrueAndNotReadGreaterThanOrDayIs(
			Employee manager, int notRead, Date day);
	
	public Announcement findAnnouncementByEmployeeAndSubjectIs(Employee emp, String subject);
	
	@Modifying
	@Query("update Announcement a set a.enabled=:enabled where a.employee=:employeeId")
	public void changeEnableStateAnnouncement(@Param("enabled")boolean enabled,@Param("employeeId")Employee emp);
	
	@Modifying
	public void deleteAnnouncementByEmployeeAndSubjectIs(Employee emp,String subject);
	
}
