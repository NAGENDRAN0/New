package com.App.HMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.App.HMS.model.DHMS;
import com.App.HMS.model.PDHMS;

@Repository
public interface HmsRepo extends JpaRepository<DHMS, Long>{

	@Query("SELECT COALESCE(MAX(d.UHId), 0) FROM DHMS d")
	Long findmaxuhid();

	@Query("SELECT p.patientEntryNumber FROM DHMS p ORDER BY p.UHId DESC LIMIT 1")
    String findLastOpNumber();
	
	@Query("SELECT p FROM PDHMS p WHERE p.UHId = :uhid")
    String findDiagnosisByUhid(@Param("uhid") Long uhid);
	
	PDHMS findByUHId(Long UHId);
	
}
