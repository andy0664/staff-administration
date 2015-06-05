package at.fh.swenga.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.model.TimeRecord;

@Repository
@Transactional
public interface SimpleTimeRecordRepository extends
		JpaRepository<TimeRecord, Integer> {

	public List<TimeRecord> findRecordsByEmployeeIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByStartDate(
			int id, Date startDate, Date endDate);

	public TimeRecord findTop1ByOrderByStartDate();
	public TimeRecord findTop1ByOrderByEndDateDesc();
}
