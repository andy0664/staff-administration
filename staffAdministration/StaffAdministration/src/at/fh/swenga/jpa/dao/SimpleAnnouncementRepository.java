package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.model.Employee;

public interface SimpleAnnouncementRepository extends
		JpaRepository<Announcement, Integer> {

	public List<Announcement> findAnnouncementByManagerAndEnabledTrueAndNotReadGreaterThanOrDayIs(
			Employee manager, int notRead, Date day);
	
	
	@Modifying
	@Query("update Announcement a set a.enabled=:enabled where a.employee=:employeeId")
	public void changeEnableStateAnnouncement(@Param("enabled")boolean enabled,@Param("employeeId")Employee emp);
	
}
