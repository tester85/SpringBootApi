package api.example.noauth.rest;
import api.example.noauth.domain.Agency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import api.example.noauth.service.AgencyService;

@RestController
@RequestMapping(value="/v1/agency")
public class AgencyController extends ApiAbstractHandler{

	@Autowired
	private AgencyService agencyServ;
	
	@GetMapping	
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
}
