package at.fh.swenga.jpa.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.fh.swenga.jpa.model.News;

@Repository
@Transactional
public interface SimpleNewsRepository extends JpaRepository<News, Integer> {

}
