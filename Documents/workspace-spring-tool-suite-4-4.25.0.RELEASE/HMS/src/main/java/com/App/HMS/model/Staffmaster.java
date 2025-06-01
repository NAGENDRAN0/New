package com.App.HMS.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Table(name = "staff_master")
@Data
public class Staffmaster {

	@Id
	private Long Id;

	private String staffcode;
	private String staffname;
	private String gender;
	private LocalDate dateofbirth;
	private String bloodgroup;
	private String email;
	private String qualificaton;
	private String address;
	private String pin;

	private String desicode;
	private String desiname;

	private String deptcode;
	private String deptname;

	private LocalDate joindate;
    private LocalDate conformdate;
    private String emailoff;
    private String accomodation;
    private String service;
    private String status;
    
    private String aadharnumber;
    private String passsportnumber;
    private String religion;
    private String martialstatus;
    
    private String salarypaymode;
    private String bankname;
    private String accountnumber;
    private String pan;
    private String epf;
    private String esi;
    private String welfarenumber;
    








}
