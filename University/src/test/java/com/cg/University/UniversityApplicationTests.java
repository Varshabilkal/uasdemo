package com.cg.University;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.cg.university.entity.Application;
import com.cg.university.entity.ProgramsOffered;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.repository.ApplicationRep;
import com.cg.university.repository.ProgramsOfferedRepository;
import com.cg.university.repository.ProgramsScheduledRepository;
import com.cg.university.service.ApplicationServ;
import com.cg.university.service.ProgramsOfferedServ;
import com.cg.university.service.ProgramsScheduledServ;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UniversityApplicationTests {

	@Mock
	private ApplicationRep applicationRep;
	@Mock
	private ProgramsOfferedRepository programsOfferedRepository;
	@Mock
	private ProgramsScheduledRepository programsScheduledRepository;

	@InjectMocks
	private ApplicationServ applicationServ;
	@InjectMocks
	private ProgramsOfferedServ programsOfferedServ;
	@InjectMocks
	private ProgramsScheduledServ programsScheduledServ;

	// ----Application(post method)
	@Test
	public void applyTest() throws Exception{
		Application application = new Application();
		application.setApplicationId(1);
		
		application.setDateOfBirth("22-08-2019");
		application.setEmailID("jahnavi@gmail.com");
		application.setFullName("jahnavi");
		application.setGoals("happylife");
		application.setHighestQualification("b.tech");
		application.setMarksObtained(72);
		application.setStatus("applied");
		ProgramsScheduled programsScheduled = new ProgramsScheduled();
		programsScheduled.setScheduledProgramID(123);
		application.setProgramsScheduled(programsScheduled);
		when(programsScheduledRepository.getOne(123)).thenReturn(programsScheduled);
		when(applicationRep.save(application)).thenReturn(application);
		Application expectedApplication = applicationServ.applyApplication(application);
		System.out.println(application.toString());
		System.out.println(expectedApplication.toString());
		assertEquals(application, expectedApplication);
	}

	//-------ProgramsOffered(post method)
	@Test
	public void addTest() throws Exception{
		ProgramsOffered actualProgramsOffered = new ProgramsOffered();
		actualProgramsOffered.setProgramName("java");
		actualProgramsOffered.setApplicantEligibility("b.tech");
		actualProgramsOffered.setDegreeCertificate("yes");
		actualProgramsOffered.setDescription("language");
		actualProgramsOffered.setDuration("2months");
		when(programsOfferedRepository.save(actualProgramsOffered)).thenReturn(actualProgramsOffered);
		ProgramsOffered excepted=programsOfferedServ.add(actualProgramsOffered);
		System.out.println(actualProgramsOffered.toString());
		System.out.println(excepted.toString());
		assertEquals(excepted, actualProgramsOffered);
	  }
   //---------ProgramsOffered(put method)

	@Test
	public void updateTest() throws Exception{
		ProgramsOffered programsOfferedActual=new ProgramsOffered();
		programsOfferedActual.setProgramName("Java");
		programsOfferedActual.setDescription("Language");
		programsOfferedActual.setDuration("2months");
		programsOfferedActual.setApplicantEligibility("B.tech");
		programsOfferedActual.setDegreeCertificate("Yes");
		when(programsOfferedRepository.getOne("Java")).thenReturn(programsOfferedActual);
		
		ProgramsOffered programsOfferedExpected=programsOfferedServ.update(programsOfferedActual, programsOfferedActual.getProgramName());
		assertEquals(programsOfferedExpected, programsOfferedActual);
	}
	
	//----------ProgramsScheduled(get method)
	
	
	@Test
	public void getProgramsScheduled() {
		ProgramsScheduled programsScheduledActual = new ProgramsScheduled();
		programsScheduledActual.setScheduledProgramID(123);
		programsScheduledActual.setProgramName("Java");
		programsScheduledActual.setLocation("Hyderabad");
		programsScheduledActual.setStartDate("22-09-2019");
		programsScheduledActual.setEndDate("30-09-2019");
		programsScheduledActual.setSessionPerWeek("12");

		when(programsScheduledRepository.getOne(123)).thenReturn(programsScheduledActual);
		List<ProgramsScheduled> programsScheduledExpected = programsScheduledServ.getAllPrograms();
		assertNotEquals(programsScheduledExpected, programsScheduledActual);
     }
	 
	//-----ProgramsScheduled(get method)
	@Test
	public void getApplicationsTest() {
	    Application application = new Application();
		application.setApplicationId(1);
		application.setDateOfBirth("22-08-2019");
		application.setEmailID("jahnavi@gmail.com");
		application.setFullName("jahnavi");
		application.setGoals("happylife");
		application.setHighestQualification("b.tech");
		application.setMarksObtained(72);
		application.setStatus("applied");
		ProgramsScheduled programsScheduled = new ProgramsScheduled();
		programsScheduled.setScheduledProgramID(123);
		application.setProgramsScheduled(programsScheduled);
		when(programsScheduledRepository.getOne(123)).thenReturn(programsScheduled);
		when(applicationRep.getOne(1)).thenReturn(application);
		
		Application applicationExpected=applicationServ.getApplications(application.getApplicationId());
		assertEquals(applicationExpected, application);
	}

}



