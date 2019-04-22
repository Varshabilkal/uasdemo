package com.cg.university.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.repository.ProgramsScheduledRepository;


@Service
public class ProgramsScheduledServ  {
	

	@Autowired
	private ProgramsScheduledRepository programsScheduledRepository;
	
	public List<ProgramsScheduled> getAllPrograms() {
		return programsScheduledRepository.findAll();
	}

	
	public ProgramsScheduled managePrograms(ProgramsScheduled programscheduled) {
		
		return programsScheduledRepository.save(programscheduled);
	}


	public ProgramsScheduled updatePrograms(ProgramsScheduled programscheduled) {
	    return programsScheduledRepository.save(programscheduled);
	}


	public String deleteProgramsScheduled(int scheduledProgramID) {
		programsScheduledRepository.deleteById(scheduledProgramID);
		return "Program got deleted successfully";
	}


	public ProgramsScheduled getParticularProgram(String startDate, String endDate) {
		return programsScheduledRepository.getParticularProgram(startDate,endDate);
	}


	

}
