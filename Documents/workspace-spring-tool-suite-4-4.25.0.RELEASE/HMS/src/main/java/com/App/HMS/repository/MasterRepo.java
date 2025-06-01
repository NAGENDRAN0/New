package com.App.HMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.HMS.model.MasterModel;


@Repository
public interface MasterRepo  extends JpaRepository<MasterModel, Long>{
	List<MasterModel> findByItemnameContainingIgnoreCase(String itemname);

}
