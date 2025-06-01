package com.App.HMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="full_detail")

public class PatientModelHMS {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uhid")
    private Long UHId;
	
	
	@Column(name = "patient_name")
	private String patientName;
	
	
	@Column(name = "patient_age")
	private String patientAge;
	
	@Column(name = "patient_mobile")
	private String patientMobile;

	@Column(name = "patient_address")
	private String patientAddress;
	
	@Column(name = "patient_gender")
	private String patientGender; //
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="gaurdian_name")
	private String gaurdian;

	public Long getUHId() {
		return UHId;
	}

	public void setUHId(Long uHId) {
		
		
		UHId = uHId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGaurdian() {
		return gaurdian;
	}

	public void setGaurdian(String gaurdian) {
		this.gaurdian = gaurdian;
	}

	public PatientModelHMS() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	 
}
