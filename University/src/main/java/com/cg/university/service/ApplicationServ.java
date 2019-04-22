package com.cg.university.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.university.entity.Application;
import com.cg.university.repository.ApplicationRep;
import com.cg.university.repository.ProgramsScheduledRepository;

@Service
public class ApplicationServ {

	@Autowired
	private ApplicationRep applicationRep;
	
	
	public Application applyApplication(Application application) {
		
		return applicationRep.save(application);
	}

	public String getStatusApplication(int applicationId) {
	    return applicationRep.findByApplicationId(applicationId);
	    
	}

	public Application getApplications(int scheduledProgramID) {
		return applicationRep.getOne(scheduledProgramID);
		
	}

	public Application acceptOrReject(Application application, int applicationId) {
		Application existingApplicant = (Application) applicationRep.getOne(applicationId);
		application.setApplicationId(applicationId);
		BeanUtils.copyProperties(application, existingApplicant);
		int status=applicationRep.updateApplicantDetails(applicationId,existingApplicant.getStatus());
		return applicationRep.getOne(applicationId);
	}

	public Application confirmOrReject(Application application, int applicationId) {
		Application existingApplicant = (Application) applicationRep.getOne(applicationId);
		application.setApplicationId(applicationId);
		BeanUtils.copyProperties(application, existingApplicant);
		int status=applicationRep.updateApplicantDetails(applicationId,existingApplicant.getStatus());
		applicationRep.getOne(applicationId);
		
		return applicationRep.getOne(applicationId);
		
	}

	public List<Application> getApplicants(String status) {
		return applicationRep.findByStatus(status);
	}

	

}
