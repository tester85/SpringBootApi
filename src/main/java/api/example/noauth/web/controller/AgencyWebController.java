package api.example.noauth.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.example.noauth.dao.jpa.AgencyRepository;
import api.example.noauth.domain.Agency;
import api.example.noauth.service.AgencyService; 

@Controller 
public class AgencyWebController {
		
	@Autowired
	private AgencyService agencyS;
	
	@Autowired
	private AgencyRepository agencyR;
	
	@GetMapping("/signup")
	public String showSignUpAgency(Agency agency) {		
		return "add-agency";
	}	

	@GetMapping("/agency")
	public String showMainPage(Model model) {
		List<Agency> agencies = agencyS.findAll();
		model.addAttribute("agency",agencies);
		return "agency"; 
	}	
	
	@PostMapping("/addagency")
	public String addAgency(@Validated Agency agency, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "addagency";
		}
		agencyR.save(agency);
		return "redirect:/agency";
	}
	@PostMapping("/updagency")
	public String updAgency(@Validated Agency agency, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "updAgency";
		}
		agencyR.save(agency);
		return "redirect:/agency";
	}
	
	@PostMapping("/delagency")
	public String delAgency(@Validated Agency agency, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "delAgency";
		}
		agencyR.delete(agency);
		return "redirect:/agency";
	}
}
