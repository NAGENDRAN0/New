package com.App.HMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.HMS.model.MasterModel;
import com.App.HMS.repository.MasterRepo;
import com.App.HMS.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterRepo masterRepo;

	@Override
	public MasterModel save(MasterModel master) {

		return masterRepo.save(master);
	}

	@Override
	public List<MasterModel> getallItem() {
		// TODO Auto-generated method stub
		return masterRepo.findAll();
	}

	@Override
	public List<MasterModel> searchByName(String query) {
		// TODO Auto-generated method stub
	    return masterRepo.findByItemnameContainingIgnoreCase(query);	}

}
