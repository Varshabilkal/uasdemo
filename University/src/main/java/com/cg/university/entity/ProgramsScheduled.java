package com.cg.university.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Data
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
@Table(name="ProgramsScheduled")
public class ProgramsScheduled implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="scheduledProgramID")
	@SequenceGenerator(name="myseq",sequenceName ="program_seq", initialValue= 100, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	private int scheduledProgramID;
	@NotEmpty(message = "ProgramName is Mandatory")	
	private String programName;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="programName",insertable = false,updatable = false)
	private ProgramsOffered programsOffered;
	@NotEmpty(message = "Location is mandatory")
	private String location;
	@NotEmpty(message = "StartDate is mandatory")
	private String startDate;
	@NotEmpty(message = "EndDate is mandatory")
	private String endDate;
	@NotNull(message = "SessionPerWeek is mandatory")
	private String sessionPerWeek;
	@JsonIgnore
	@OneToMany(mappedBy = "programsScheduled")
	private List<Application> application;
	
	
	

	 
	
}
