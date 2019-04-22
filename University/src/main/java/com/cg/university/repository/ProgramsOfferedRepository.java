package com.cg.university.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.university.entity.ProgramsOffered;

public interface ProgramsOfferedRepository extends JpaRepository<ProgramsOffered, String>{

	@Transactional
	@Modifying
	@Query("UPDATE ProgramsOffered e SET e.description=:description WHERE e.programName=:programName")
	int updateProgramsOffered(String programName, String description);

	

}
