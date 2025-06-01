package com.App.HMS.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.App.HMS.dto.UserModelDto;
import com.App.HMS.model.UserModel;
import com.App.HMS.repository.UserModelRepo;
import com.App.HMS.service.UserModelService;

@Service
public class UserServiceModelImpl implements UserModelService {
	
	@Autowired
	private UserModelRepo umrepo;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserModel save(UserModelDto usermodeldto) {
		UserModel userM=new UserModel(usermodeldto.getFirstname(),usermodeldto.getEmail(),usermodeldto.getRole(),bCryptPasswordEncoder.encode(usermodeldto.getPass())
				                   );
		
		return umrepo.save(userM);
	}

	

}
