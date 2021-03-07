package com.biglolPage.introducingBiglolPage.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills, Long> {
	// @Query("select S.name, S.path, S.opinion, S.description from Skills S where S.name = ?1") // doesn't work
	@Query("select S from Skills S where S.name = ?1")
	Skills findBySkillname(String skillname);
}
