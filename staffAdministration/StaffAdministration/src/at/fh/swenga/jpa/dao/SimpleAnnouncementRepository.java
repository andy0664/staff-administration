package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.model.Employee;

public interface SimpleAnnouncementRepository extends
		JpaRepository<Announcement, Integer> {

	public List<Announcement> findAnnouncementByManagerAndNotReadGreaterThanOrDayIs(
			Employee manager, int notRead, Date day);

}
