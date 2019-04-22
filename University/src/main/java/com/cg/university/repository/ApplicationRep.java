package com.cg.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.university.entity.Application;

@Repository
public interface ApplicationRep extends JpaRepository<Application, Integer> {
	
	List<Application> findByStatus(String status);

	@Query("SELECT e.status FROM Application e WHERE e.applicationId=:applicationId")
	String findByApplicationId(int applicationId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Application  m SET m.status=:status where m.applicationId =:applicationId")
	int updateApplicantDetails(@Param(value="applicationId") int applicationId,@Param(value="status") String status);

	

}
