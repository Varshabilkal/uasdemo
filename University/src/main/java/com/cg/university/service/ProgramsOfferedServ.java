package com.cg.university.service;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.university.entity.ProgramsOffered;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.repository.ProgramsOfferedRepository;

@Service
public class ProgramsOfferedServ {
	
	@Autowired
	private ProgramsOfferedRepository programsOfferedRepository;

	
	public ProgramsOffered add(ProgramsOffered programsOffered) {
		return programsOfferedRepository.save(programsOffered);
	}

	public ProgramsOffered update(ProgramsOffered programsOffered, String programName) {
		ProgramsOffered programsOfferedExisting = programsOfferedRepository.getOne(programName);
		programsOffered.setProgramName(programName);
		BeanUtils.copyProperties(programsOfferedExisting,programsOffered);
		int status=programsOfferedRepository.updateProgramsOffered(programName,programsOfferedExisting.getDescription());
		return programsOfferedRepository.getOne(programName);
	}

	public String deleteProgramsOffered(String programName) {
		programsOfferedRepository.deleteById(programName);
		return "Program got deleted";
	}

	public List<ProgramsOffered> getPrograms() {
		
		return programsOfferedRepository.findAll();
	}

	
	

}
