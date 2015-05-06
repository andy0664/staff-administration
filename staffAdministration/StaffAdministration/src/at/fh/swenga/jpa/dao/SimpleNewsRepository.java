package at.fh.swenga.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import at.fh.swenga.jpa.model.News;

public interface SimpleNewsRepository extends JpaRepository<News, Integer> {

}
