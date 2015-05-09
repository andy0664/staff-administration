package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.jpa.model.TimeRecord;

public interface SimpleTimeRecordRepository extends
		JpaRepository<TimeRecord, Integer> {

	public List<TimeRecord> findRecordsByEmployeeIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
			int id, Date startDate, Date endDate);
}
