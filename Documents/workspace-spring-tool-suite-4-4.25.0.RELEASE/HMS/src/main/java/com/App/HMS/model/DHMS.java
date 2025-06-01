package com.App.HMS.model;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "op_register")
public class DHMS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UHId;
	
	@Transient
	private String DisplayUhid;

	@Column(name = "patient_entry_number", nullable = false, unique = true)
	//@Column(name = "patient_entry_number") // Explicit column names to avoid case issues
	private String patientEntryNumber;

	@Column(name = "patient_name")
	private String patientName;

	public String getDisplayUhid() {
		return DisplayUhid;
	}

	public void setDisplayUhid(String displayUhid) {
		DisplayUhid = displayUhid;
	}

	@Column(name = "patient_age")
	private String patientAge;

	@Column(name = "patient_gender")
	private String patientGender; // 

	@Column(name = "patient_mobile")
	private String patientMobile;

	@Column(name = "patient_address")
	private String patientAddress;

	@Column(name = "patient_pincode")
	private String PatientPincode;

	@Column(name = "patient_case_type")
	private String PatientCasType;
	
	
	@Column(name = "patient_status")
	private String PatientStatus;
	
	// Link to PDHMS (One-to-One relationship)
    @OneToOne(mappedBy = "dhms", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PDHMS pdhms;

	public PDHMS getPdhms() {
		return pdhms;
	}

	public void setPdhms(PDHMS pdhms) {
		this.pdhms = pdhms;
	}
	

	public String getPatientStatus() {
		return PatientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		PatientStatus = patientStatus;
	}

	public Long getUHId() {
		return UHId;
	}

	public void setUHId(Long uHId) {
		UHId = uHId;
	}

	public String getPatientEntryNumber() {
		return patientEntryNumber;
	}

	public void setPatientEntryNumber(String patientEntryNumber) {
		if (patientEntryNumber != null && !patientEntryNumber.startsWith("OP-")) {
            this.patientEntryNumber = "OP-" + patientEntryNumber;
        } else {
            this.patientEntryNumber = patientEntryNumber;
        }
		
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

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
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

	public String getPatientPincode() {
		return PatientPincode;
	}

	public void setPatientPincode(String patientPincode) {
		PatientPincode = patientPincode;
	}

	public String getPatientCasType() {
		return PatientCasType;
	}

	public void setPatientCasType(String patientCasType) {
		PatientCasType = patientCasType;
	}

	public DHMS() {
		super();
		// TODO Auto-generated constructor stub
	}

}
