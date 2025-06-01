package com.App.HMS.service;

import java.util.List;


import com.App.HMS.model.DHMS;

public interface HomeService {

	List<DHMS> Listall();

	DHMS save(DHMS d);
	
	Long generateNextUHID(); 
	
	
	DHMS editbyid(Long id);
	
	String generateNextOpNumber();

}
