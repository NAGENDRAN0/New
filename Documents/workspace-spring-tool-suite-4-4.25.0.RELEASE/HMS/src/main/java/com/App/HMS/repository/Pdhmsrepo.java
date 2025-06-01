package com.App.HMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.HMS.model.PDHMS;


@Repository
public interface Pdhmsrepo extends JpaRepository<PDHMS, Long>{

	Optional<PDHMS> findByUHId(Long UHId);
	
	//PDHMS findByUHId(Long UHId);
}
