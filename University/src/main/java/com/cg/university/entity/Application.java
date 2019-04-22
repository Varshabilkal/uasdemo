package com.cg.university.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Application implements Serializable {
	  
	  @Id	  
	  @Column(name="applicationId")	  
	  @SequenceGenerator(name="applicationseq",
	  sequenceName="application_seq",initialValue= 100,allocationSize=1)	  
	  @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applicationseq")
		private int applicationId;
	    
	    @NotNull(message="fullname is mandatory")
        private String fullName;
	    @NotNull(message="DateOfBirth is mandatory")
	    private String dateOfBirth;
	    @NotNull(message="HighestQualification is mandatory")
        private String highestQualification;
	    @NotNull(message="MarksObtained is mandatory")
		private int marksObtained;
	    @NotNull(message="Goal is mandatory")
		private String goals;
	    @NotNull(message="EmailID is mandatory")
		private String emailID;
		private String status="applied";
	    private Date dateOfInterview;
	    @NotNull(message="ScheduledProgramID is mandatory")
	    private int scheduledProgramID;
	    @JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinColumn(name = "scheduledProgramID",insertable = false,updatable = false)
		private ProgramsScheduled programsScheduled;
		
	
	
	
}