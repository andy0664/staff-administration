package at.fh.swenga.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.jpa.model.Announcement;
import at.fh.swenga.jpa.model.Employee;

public interface SimpleAnnouncementRepository extends
		JpaRepository<Announcement, Integer> {

	public List<Announcement> findAnnouncementByManagerAndNotReadGreaterThanOrMonthIsAndDayIs(
			Employee manager, int notRead, int month, int year);

}
