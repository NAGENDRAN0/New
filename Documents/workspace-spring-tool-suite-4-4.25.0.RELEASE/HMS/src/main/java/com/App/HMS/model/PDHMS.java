package com.App.HMS.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescription")
public class PDHMS {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UHId;
	
	
	@Column(name="next_visit")
	private LocalDate nextvisit;
	
	@Column(name="provisional_diagnosis")
	private String provisionaldiagnosis;

	
	public Long getUHId() {
		return UHId;
	}
	
	public void setUHId(Long uhid) {
		UHId = uhid;
	}

	public LocalDate getNextvisit() {
		return nextvisit;
	}

	public void setNextvisit(LocalDate nextvisit) {
		this.nextvisit = nextvisit;
	}

	public String getProvisionaldiagnosis() {
		return provisionaldiagnosis;
	}

	public void setProvisionaldiagnosis(String provisionaldiagnosis) {
		this.provisionaldiagnosis = provisionaldiagnosis;
	}

	public String getInitialassesment() {
		return initialassesment;
	}

	public void setInitialassesment(String initialassesment) {
		this.initialassesment = initialassesment;
	}

	public String getFinalassesment() {
		return finalassesment;
	}

	public void setFinalassesment(String finalassesment) {
		this.finalassesment = finalassesment;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="initial_assesment")
	private String initialassesment;
	
	
	@Column(name="final_assesment")
	private String finalassesment;
	
	@Column(name="height")
	private String height;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="body_temperature")
	private String temperature;
	
	@Column(name="status")
	private String status;
	
	@Column(name="bp")
	private String bp;
	
	

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	@OneToOne
	    @JoinColumn(name = "UHId")
	    private DHMS dhms;

	    // Getters & Setters
	    public DHMS getDhms() {
	        return dhms;
	    }

	    public void setDhms(DHMS dhms) {
	        this.dhms = dhms;
	    }

	public PDHMS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
