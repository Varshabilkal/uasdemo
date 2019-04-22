package com.cg.university.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="ProgramsOffered")
public class ProgramsOffered implements Serializable{

    @Id
    @Column(name="programName")
    @NotEmpty(message = "Description is mandatory")
    @Size(min=3,max=15,message="minimum 3 letters")
	private String programName;
    @NotEmpty(message = "Description is mandatory")
    @Size(min=3,max=20,message="minimum 3 letters")
	private String description;	
    @NotEmpty(message = "ApplicantEligibility is mandatory")
    @Size(min=3,max=15,message="minimum 3 letters")
	private String applicantEligibility;	
    @NotEmpty(message = "Duration is mandatory")
    @Size(min=2,max=10,message="minimum 3 letters")
	private String duration;	
    @NotEmpty(message = "DegreeCertificate is mandatory")
	private String degreeCertificate;
	
	@JsonIgnore
    @OneToMany(mappedBy = "programsOffered")
	private List<ProgramsScheduled> programScheduled;


	 
}
