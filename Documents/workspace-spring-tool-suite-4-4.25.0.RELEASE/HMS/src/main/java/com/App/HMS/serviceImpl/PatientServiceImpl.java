package com.App.HMS.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.HMS.model.PatientModelHMS;
import com.App.HMS.repository.PatientDhms;
import com.App.HMS.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDhms patientrepo;
	
	@Override
	public PatientModelHMS save(PatientModelHMS pm) {
		
		return patientrepo.save(pm);
	}
	
	

	
	public long generateuhid() {
		
		long last=patientrepo.findMaxUhid();
		long next=1;
		if(last==0) {
			next=1;
		}else {
			next=last+1;
		}
		
		return next;
	}

}
