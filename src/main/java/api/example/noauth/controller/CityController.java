package api.example.noauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.example.noauth.domain.City;
import api.example.noauth.exception.DataFormatException;
import api.example.noauth.exception.ResourceNotFoundException;
import api.example.noauth.service.CityService;

@RestController
@RequestMapping(value="/v1/agency/city" )
public class CityController extends ApiAbstractHandler {
	
	@Autowired
	private CityService cityS;
	 
	@GetMapping() 
	@ResponseBody
	public ResponseEntity<List<City>> getCityList(){
		List<City> cityList = null;
		try {
			cityList = cityS.getAllCity();
		} catch (Exception e) {
			new ResourceNotFoundException("Error: ", e.getCause());
		}
		return new ResponseEntity<List<City>>(cityList,HttpStatus.OK);
	}
	
	@PostMapping(value="/add") 
	public ResponseEntity<City> addCity(@RequestBody City c) {
		City data = c;
		try {
			cityS.createCity(data);	
		} catch (Exception e) {
			new DataFormatException("There are errors on the data: ", e.getCause());
		}
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	

}
