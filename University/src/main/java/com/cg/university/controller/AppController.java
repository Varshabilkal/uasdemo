package com.cg.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.university.service.ApplicationServ;
import com.cg.university.service.ProgramsOfferedServ;
import com.cg.university.service.ProgramsScheduledServ;

@Controller
public class AppController {
	@Autowired
	private ApplicationServ applicationServ;
	@Autowired
	private ProgramsScheduledServ programsScheduledServ;
	@Autowired
	private ProgramsOfferedServ programsOfferedServ;
	
	
	
	
}
