package api.example.noauth.controller;
import api.example.noauth.domain.Agency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import api.example.noauth.service.AgencyService;

@RestController
@RequestMapping(value="/v1/agency")
public class AgencyController extends ApiAbstractHandler{

	@Autowired
	private AgencyService agencyServ;
	
	@GetMapping("/v1/agency")
	@ResponseBody
	public ResponseEntity<List<Agency>> getAllAgencies() {
		List<Agency> agencyList = null;		
		try {
			agencyList = agencyServ.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return new ResponseEntity<List<Agency>>(agencyList,HttpStatus.OK);		
	}
	
	@GetMapping("/find{id}")	
	public ResponseEntity<Agency> getAgencyById(@PathVariable("id") Integer id) {
		Agency agencyData = new Agency();		
		try {
			agencyData = this.agencyServ.getAgencia(id);			
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}		 
		return new ResponseEntity<Agency>(agencyData,HttpStatus.OK);		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Agency> addUser(@RequestBody Agency agencyPost){
		Agency data = agencyPost;
		try {
			agencyServ.createAgencia(data); 
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return new ResponseEntity<Agency>(data,HttpStatus.OK);		
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
		try {
			agencyServ.deleteAgency(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
}
