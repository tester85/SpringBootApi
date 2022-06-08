package api.example.noauth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.example.noauth.dao.jpa.AgencyRepository;
import api.example.noauth.domain.Agency; 

@RestController
@RequestMapping(value="/")
public class AgencyWebController {
		
	@Autowired
	private AgencyRepository agencyR;
	
	@GetMapping("/signup")
	public String showSignUpAgency(Agency agency) {		
		return "add-agency";
	}
	
	@PostMapping("/addagency")
	public String addAgency(@Validated Agency agency, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "add-agency";
		}
		agencyR.save(agency);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("agency",agencyR.findAll());
		return "index"; 
	}
}
