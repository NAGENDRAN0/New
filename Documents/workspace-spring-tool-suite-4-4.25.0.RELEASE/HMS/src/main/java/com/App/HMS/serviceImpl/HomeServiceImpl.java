package com.App.HMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.HMS.model.DHMS;
import com.App.HMS.model.PDHMS;
import com.App.HMS.repository.HmsRepo;
import com.App.HMS.repository.Pdhmsrepo;
import com.App.HMS.service.HomeService;


@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HmsRepo hmsrepo;
	
	@Autowired
	private Pdhmsrepo pdhmsrepo;

	public HomeServiceImpl(HmsRepo hmsrepo) {
		super();
        this.hmsrepo=hmsrepo;
	}

	@Override
	public List<DHMS> Listall() {
		return hmsrepo.findAll();
		 
	}

	@Override
	public DHMS save(DHMS d) {
	    if (d.getPatientEntryNumber() == null || d.getPatientEntryNumber().isEmpty()) {
	        // Generate the next OP Number
	        String nextOpNumber = generateNextOpNumber();
	        d.setPatientEntryNumber(nextOpNumber);
	    } else if (!d.getPatientEntryNumber().startsWith("OP-")) {
	        d.setPatientEntryNumber("OP-" + d.getPatientEntryNumber());
	    }

	    return hmsrepo.save(d);
	}
	
//	@Override
//	public DHMS save(DHMS d) {
//	    // Fetch the last OP Number from the database
//	    String lastOpNumber = hmsrepo.findLastOpNumber();
//	    
//	    int nextNumber = 1001; // Default starting number
//
//	    if (lastOpNumber != null && lastOpNumber.startsWith("OP-")) {
//	        try {
//	            // Extract the number part and increment it
//	            int lastNumber = Integer.parseInt(lastOpNumber.substring(3));
//	            nextNumber = lastNumber + 1;
//	        } catch (NumberFormatException e) {
//	            e.printStackTrace(); // Handle error properly
//	        }
//	    }
//
//	    // Assign the new OP number if it's not already set
//	    if (d.getPatientEntryNumber() == null || !d.getPatientEntryNumber().startsWith("OP-")) {
//	        d.setPatientEntryNumber("OP-" + nextNumber);
//	    }
//
//	    return hmsrepo.save(d);
//	}

	
	

	@Override
	public Long generateNextUHID() {
		Long Latid=hmsrepo.findmaxuhid();
		return (Latid == null) ? 1L : Latid + 1;
		
	}

	@Override
	public DHMS editbyid(Long id) {
		
		return hmsrepo.findById(id).orElse(null);
		
	}

	@Override
	public String generateNextOpNumber() {
		String lastOpNumber = hmsrepo.findLastOpNumber();

        int nextNumber = 1; // Default start number

        if (lastOpNumber != null && lastOpNumber.startsWith("OP-")) {
            // Extract the number part and increment
            try {
                nextNumber = Integer.parseInt(lastOpNumber.substring(3)) + 1;
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Handle error properly
            }
        }

        return "OP-" + nextNumber;
    }

	public PDHMS save(PDHMS p) {
		return pdhmsrepo.save(p);
		
	}
	}

	


