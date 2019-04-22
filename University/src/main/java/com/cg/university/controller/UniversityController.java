package com.cg.university.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.university.entity.Application;
import com.cg.university.entity.ProgramsOffered;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.exception.UniversityManagementException;
import com.cg.university.service.ApplicationServ;
import com.cg.university.service.ProgramsOfferedServ;
import com.cg.university.service.ProgramsScheduledServ;

@RestController
//@RequestMapping("rest")
public class UniversityController {

	
	@Autowired
	private ApplicationServ applicationServ;
/******************Applicant ************************************/

	
//-----ProgramsScheduled(get method)
@RequestMapping(value="/ProgramsScheduled")	
public List<ProgramsScheduled> getAllPrograms() throws UniversityManagementException{
	try{
		return programsScheduledServ.getAllPrograms();
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}


//-----Application(post method)
@RequestMapping(value="/Application",method=RequestMethod.POST)
public Application applyApplication(@RequestBody Application application) throws UniversityManagementException {
	try {
	return applicationServ.applyApplication(application);
	}
	catch(Exception e) {
		throw new UniversityManagementException(500,e.getMessage());
	}
}

//-----Application(get method)
@RequestMapping(value="/getStatusApplication/{applicationId}")
public String getStatusApplication(@PathVariable int applicationId) throws UniversityManagementException {
	try{
		return applicationServ.getStatusApplication(applicationId);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
	
}


/***************************MAC ***************************************/
//-----Application(get method)

@RequestMapping(value="/Application/{scheduledProgramID}")
public Application getApplications(@PathVariable int scheduledProgramID) throws UniversityManagementException {
	try{
		return applicationServ.getApplications(scheduledProgramID);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}

//-----Application(put method)

@RequestMapping(value="/Application/{applicationId}",method=RequestMethod.PUT)
public Application acceptOrReject(@RequestBody Application application,@PathVariable int applicationId) throws UniversityManagementException {
	try{
		return applicationServ.acceptOrReject(application,applicationId);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}


//-----Application(put method)

@RequestMapping(value="/confirmOrRejectApplication/{applicationId}",method=RequestMethod.PUT)
public Application confirmOrReject(@RequestBody Application application,@PathVariable int applicationId) throws UniversityManagementException {
	try{
		return applicationServ.confirmOrReject(application,applicationId);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}




/**********************Admin(managing ProgramsScheduled)****************************/
@Autowired
private ProgramsScheduledServ programsScheduledServ;

//-----ProgramsScheduled(post method)

@RequestMapping(value="/ProgramsScheduled",method=RequestMethod.POST)
public ProgramsScheduled managePrograms(@RequestBody ProgramsScheduled programscheduled) throws UniversityManagementException {
	try{
		return programsScheduledServ.managePrograms(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityManagementException(400,e.getMessage());
	}
}

//-----ProgramsScheduled(put method)
@RequestMapping(value="/ProgramsScheduled",method=RequestMethod.PUT)
public ProgramsScheduled updatePrograms(@RequestBody ProgramsScheduled programscheduled) throws UniversityManagementException {
	try{
		return programsScheduledServ.updatePrograms(programscheduled);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}

//-----ProgramsScheduled(delete method)
@RequestMapping(value="/ProgramsScheduled/{scheduledProgramID}",method=RequestMethod.DELETE)
public String deleteProgramsScheduled(@PathVariable int scheduledProgramID) throws UniversityManagementException {
	try{
		return programsScheduledServ.deleteProgramsScheduled(scheduledProgramID);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}

}
/**********************Admin(managing ProgramsOffered)***************************/

@Autowired
private ProgramsOfferedServ programsOfferedServ;

//-----ProgramsOffered(post method)

@RequestMapping(value="/ProgramsOffered",method=RequestMethod.POST)
public ProgramsOffered addPrograms(@RequestBody ProgramsOffered programsOffered) throws UniversityManagementException {
	try{
		return programsOfferedServ.add(programsOffered);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}

//-----ProgramsOffered(put method)

@RequestMapping(value="/ProgramsOffered",method=RequestMethod.PUT)
public ProgramsOffered update(@RequestBody ProgramsOffered programsOffered,@PathVariable String programName) throws UniversityManagementException {
	try{
		return programsOfferedServ.update(programsOffered,programName);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}
//-----ProgramsOffered(delete method)
@RequestMapping(value="/ProgramsOffered/{programName}",method=RequestMethod.DELETE)
public String deleteProgramsOffered(@PathVariable String programName) throws UniversityManagementException {
	try{
		return programsOfferedServ.deleteProgramsOffered(programName);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}

//-----ProgramsOffered(get method)
@RequestMapping(value="/ProgramsOffered")	
public List<ProgramsOffered> getPrograms() throws UniversityManagementException{
	try{
		return programsOfferedServ.getPrograms();
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}
/***************************Admin(Report) ******************************/
//-----Application(get method)

@RequestMapping(value="/ApplicationGet/{status}",method=RequestMethod.GET)
public List<Application> getAllApplicants(@PathVariable String status) throws UniversityManagementException {
	try{
		return applicationServ.getApplicants(status);
	}
	catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}
//-----ProgramsScheduled(get method)

@RequestMapping(value="/ProgramsScheduledProgram/{startDate}/{endDate}")
public ProgramsScheduled getParticularProgram(@PathVariable String startDate,@PathVariable String endDate) throws UniversityManagementException {
	startDate=startDate.replace('-', '/');
	endDate=endDate.replace('-', '/');
    try{
    	return programsScheduledServ.getParticularProgram(startDate,endDate);
    }
    catch(Exception e) {
		throw new UniversityManagementException(204,e.getMessage());
	}
}


}
