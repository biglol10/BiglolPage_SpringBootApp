package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query("select S from Course S where S.courseType = ?1")
	List<Course> findByCourseType(String courseType);
}
