package com.cg.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.university.entity.ProgramsScheduled;
@Repository
public interface ProgramsScheduledRepository extends JpaRepository<ProgramsScheduled, Integer>{

	@Query("SELECT e FROM ProgramsScheduled e WHERE e.startDate=:startDate and e.endDate=:endDate")
	ProgramsScheduled getParticularProgram(@Param(value="startDate") String startDate,
			                               @Param(value="endDate") String endDate);

	

}
