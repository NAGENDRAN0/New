package com.App.HMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.App.HMS.dto.UserModelDto;
import com.App.HMS.serviceImpl.UserServiceModelImpl;

@Controller
public class UserModelController {

	@Autowired
	private UserServiceModelImpl userServiceModelImpl;

	@GetMapping("/create/account")
	private String getreguster(Model model) {
		model.addAttribute("Umodel", new UserModelDto());
		return "account";
	}

	@PostMapping("/create/account")
	private String saveaccount(@ModelAttribute("Umodel") UserModelDto dto, RedirectAttributes attributes) {
		userServiceModelImpl.save(dto);
		attributes.addFlashAttribute("message", "Registered Succesfully");
		return "redirect:/create/account";
	}
	
	
	@GetMapping("/login")
	private String login() {
		return"login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
	    return "dashboard";
	}

	
	
	
	
	
	
	
	
	
}
