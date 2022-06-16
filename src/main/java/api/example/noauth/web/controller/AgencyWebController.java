package api.example.noauth.web.controller;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import api.example.noauth.domain.Agency;
import api.example.noauth.exception.ResourceNotFoundException;
import api.example.noauth.service.AgencyService;

@Controller
public class AgencyWebController {

	@Autowired
	private AgencyService agencyS;

	@GetMapping("/signup")
	public String showSignUpAgency(Agency agency) {
		return "/";
	}

	@GetMapping("/agency")
	public String showMainPage(Model model) {
		List<Agency> agencies = agencyS.findAll();
		model.addAttribute("agency", agencies);
		return "agency";
	}

	@GetMapping("/agency/new")
	public String addNewAgency(Model model) {
		model.addAttribute("agency", new Agency());
		model.addAttribute("pageTitle", "Add a new agency");
		return "addAgency";
	}

	@Transactional
	@PostMapping("/agency/save")
	public String addAgency(Agency agency, RedirectAttributes ra,
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/";
		}
		agency.setId(new Random().nextLong());
		agencyS.createAgencia(agency);
		ra.addFlashAttribute("message", "The agency has been correctly added");
		return "redirect:/agency";
	}
	@Transactional
	@PostMapping("/agency/update")
	public String updAgency(Agency agency, RedirectAttributes ra,
			BindingResult result) {
		if (result.hasErrors()) {
			ra.addFlashAttribute("message", "Some Errors where found");
			return "redirect:/agency";
		}
		agencyS.updateAgency(agency);
		ra.addFlashAttribute("message",
				"The agency has been correctly updated");
		return "redirect:/agency";
	}

	@GetMapping("/agency/update/{id}")
	public String showEditAgency(@PathVariable Long id, RedirectAttributes ra,
			Model model) {
		try {
			Agency agency = agencyS.getAgencia(id);
			model.addAttribute("agency", agency);
			model.addAttribute("pageTitle", "Edit Agency: " + agency.getName());
			return "updateAgency";
		} catch (ResourceNotFoundException e) {
			ra.addFlashAttribute("message",
					"The agency has been correctly updated");
			return "redirect:/agency";
		}
	}

	@GetMapping("/agency/delete/{id}")
	public String delAgency(@PathVariable Long id, RedirectAttributes ra,
			Model model) {
		try {
			agencyS.deleteAgency(id);
			ra.addFlashAttribute("message",
					"The agency has been correctly deleted");
		} catch (Exception e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/agency";
	}
}
