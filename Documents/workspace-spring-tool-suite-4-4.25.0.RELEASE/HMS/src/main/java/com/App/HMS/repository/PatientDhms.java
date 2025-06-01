package com.App.HMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.App.HMS.model.PatientModelHMS;

public interface PatientDhms extends JpaRepository<PatientModelHMS, Long>{

	@Query("SELECT MAX(p.UHId) FROM PatientModelHMS p")
	Long findMaxUhid();

}
