package com.App.HMS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.App.HMS.model.DHMS;
import com.App.HMS.model.PDHMS;
import com.App.HMS.model.PatientModelHMS;
import com.App.HMS.repository.PatientDhms;
import com.App.HMS.repository.Pdhmsrepo;
import com.App.HMS.serviceImpl.HomeServiceImpl;
import com.App.HMS.serviceImpl.PatientServiceImpl;

@Controller
public class hmshome {

	@Autowired
	private HomeServiceImpl homeServiceImpl;
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	
	@Autowired
	private Pdhmsrepo pdhmsrepo;
	
	@Autowired
	private PatientDhms patentdhms;

	@GetMapping("/")
	public String Home() {
		return "home";
	}

//	@GetMapping("/OP")
//	public String OutPatient() {
//		return "outpatient";
//	}

//	@GetMapping("/regi")
//	public String OPRegistrtion(Model model) {
//		DHMS ghms = new DHMS();
//		Long nextId = homeServiceImpl.generateNextUHID();
//		ghms.setUHId(nextId); // Store numeric value
//		ghms.setDisplayUhid("P00" + nextId.toString());
//		model.addAttribute("dhms", ghms);
//		return "register";
//	}
	
	@GetMapping("/outpatient/registration")
	public String OPRegistration(Model model) {
	    DHMS ghms = new DHMS();

	    // Generate the next UHID
	    Long nextId = homeServiceImpl.generateNextUHID();
	    ghms.setUHId(nextId);
	    ghms.setDisplayUhid("P00" + nextId.toString());

	    // Generate the next OP Number
	    String nextOpNumber = homeServiceImpl.generateNextOpNumber();
	    ghms.setPatientEntryNumber(nextOpNumber);

	    model.addAttribute("dhms", ghms); 
	    return "register"; //
	    
	    
	}



//	@PostMapping("/save")
//	public String save(@ModelAttribute DHMS d, RedirectAttributes redirectAttributes, Model model) {
//		String nextOpNumber = homeServiceImpl.generateNextOpNumber();
//	    DHMS newPatient = new DHMS();
//	    newPatient.setPatientEntryNumber(nextOpNumber); // Set the OP number
//
//	    model.addAttribute("patient", newPatient); // Pass to the frontend
//		if (!d.getPatientEntryNumber().startsWith("OP-")) {
//	        d.setPatientEntryNumber("OP-" + d.getPatientEntryNumber());
//	    }
//		homeServiceImpl.save(d); // Save the record
//		redirectAttributes.addFlashAttribute("successMessage", "Record saved successfully!");
//		return "redirect:/regi"; // Redirect to the registration page
//	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute DHMS d, RedirectAttributes redirectAttributes) {
	    // Generate OP Number only if it's missing
	    if (d.getPatientEntryNumber() == null || d.getPatientEntryNumber().isEmpty()) {
	        String nextOpNumber = homeServiceImpl.generateNextOpNumber();
	        d.setPatientEntryNumber(nextOpNumber);
	    }

	   
	    homeServiceImpl.save(d);

	    
	    redirectAttributes.addFlashAttribute("successMessage", "Record saved successfully!");

	    return "redirect:/outpatient/registration";
	}


	@GetMapping("/outpatient/list")
	public String ListAll(Model model) {
		model.addAttribute("dh", homeServiceImpl.Listall());
		return "outpatient";
	}
	
	@GetMapping("/outpatient/edit/{UHId}")
	public String EditPatient(@PathVariable("UHId") Long UHId,Model model){
		DHMS pate=homeServiceImpl.editbyid(UHId);
		if(pate==null) {
			return "redirect:/error";
		}
	    System.out.println("Editing Patient: " + pate);  // Debugging Line
		model.addAttribute("pate", pate);
		return "registerEdit";
		
	}
	
	
//	@GetMapping("/prescription")
//	public String docPrescription(Model model) {
//		PDHMS phms=new PDHMS();
//		model.addAttribute("dh", homeServiceImpl.Listall());
//		
//		return "docprescription";
//	}
	
	
	@GetMapping("/outpatient/prescription")
	public String docPrescription(Model model) {
	    List<DHMS> dhList = homeServiceImpl.Listall(); // Fetch patient list
	    
	    // Fetch status from pdhms for each patient
	    Map<Long, String> patientStatusMap = new HashMap<>();
	    for (DHMS dh : dhList) {
	        Optional<PDHMS> pdhms = pdhmsrepo.findByUHId(dh.getUHId());
	        patientStatusMap.put(dh.getUHId(), pdhms.map(PDHMS::getStatus).orElse("Registered"));
	    }

	    
	    
	    
	    model.addAttribute("dh", dhList);
	    model.addAttribute("patientStatusMap", patientStatusMap);

	    return "docprescription"; 
	}


	@GetMapping("/outpatient/prescription/details/{UHId}")
	private String prescrip(@PathVariable("UHId") Long UHId,Model model) {
		DHMS patien=homeServiceImpl.editbyid(UHId);
		model.addAttribute("patients", patien);
		
		Optional<PDHMS> presc=pdhmsrepo.findByUHId(UHId);
		
		PDHMS prescription=presc.orElse(null);
		
		if(prescription==null) {
			prescription=new PDHMS();
		}else {
			System.out.println("Precription" + prescription);
		}
		
		model.addAttribute("patients", patien);
		model.addAttribute("prescription", prescription);
		return "prescriptiondetail";
	}

//	@PostMapping("/prescriptionSave")
//	private String saveprescription(@ModelAttribute PDHMS p,RedirectAttributes redirectAttributes ) {
//		homeServiceImpl.save(p);
//		 // Set the UHId from patient
//	    p.setUHId(p.getUHId()); 
//
//		redirectAttributes.addFlashAttribute("Saved Message", "Record Saved Sucesfully");
//		return "redirect:/prescrip/details/{UHId}";
//	}
	
	
	@PostMapping("/prescriptionSave")
	private String savePrescription(@ModelAttribute PDHMS p, RedirectAttributes redirectAttributes) {
	    if (p.getUHId() == null) {
	        redirectAttributes.addFlashAttribute("errorMessage", "UHId is missing!");
	        return "redirect:/errorPage";
	    }

	    
	    DHMS patient = homeServiceImpl.editbyid(p.getUHId());

	    if (patient == null) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Patient not found!");
	        return "redirect:/errorPage";
	    }

	    
	    p.setDhms(patient);

	   
	    homeServiceImpl.save(p);

	    redirectAttributes.addFlashAttribute("successMessage", "Prescription Saved Successfully");
	    return "redirect:/prescrip/details/" + p.getUHId();
	}

	
	@GetMapping("/works")
	public String erro() {
		return"er";
	}

	@PostMapping("/NewPatient")
	public String patientSave(@ModelAttribute PatientModelHMS pathms, RedirectAttributes redirectAttributes) {
		
		
		
		patientServiceImpl.save(pathms);
		 redirectAttributes.addFlashAttribute("successMessage", "UHID Created Successfully");
		return "redirect:/patientsaveview";
	}
	
	@GetMapping("/patientsaveview")
	public String patientsaveview(Model model) {
		
		PatientModelHMS pathms=new PatientModelHMS();
		long nextuhid=patientServiceImpl.generateuhid();
		pathms.setUHId(nextuhid);
		model.addAttribute("pathms", pathms);
		
		return "uhid";

	}
	
	
	
	@GetMapping("/logout")
	public String logouthms() {
		return "login";
	}
	
	

	
}
