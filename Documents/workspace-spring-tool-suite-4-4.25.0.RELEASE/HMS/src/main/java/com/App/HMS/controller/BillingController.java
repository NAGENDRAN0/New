package com.App.HMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.App.HMS.model.MasterModel;
import com.App.HMS.serviceImpl.MasterServiceImpl;

@Controller
public class BillingController {

	@Autowired
	private MasterServiceImpl masterimpl;
	
	@GetMapping("/billing/list")
	public String billigListPage() {
	return "billList";	
	}
	
	
	@GetMapping("/billing/new")
	public String billing() {
		return "billing";
	}
	
	@GetMapping("/master/search")
	@ResponseBody
	public List<MasterModel> searchItems(@RequestParam("query") String query) {
	    return masterimpl.searchByName(query); 
	}

}
