package api.example.noauth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.example.noauth.dao.jpa.CityRepository;
import api.example.noauth.domain.City;
import api.example.noauth.exception.ResourceNotFoundException;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepo;
	
	public City createCity(City city) {
		return cityRepo.save(city);
	}
	
	public Optional<City> getCity(Long id){
		Optional<City> city = cityRepo.findById(id);
		if(city.isPresent()) {
			return cityRepo.findById(id);
		}
		else throw new ResourceNotFoundException("City with id = "+String.valueOf(id)+"isn't found");
	}
	
	public List<City> getAllCity(){
		List<City> city = cityRepo.findAll();
		if(city.isEmpty()) {
			throw new ResourceNotFoundException("There aren't Cities on the DB");
		}
		else return cityRepo.findAll();
	}
	
	public City updateCity(City city) {
		return cityRepo.save(city);
	}
	
	public void deleteCity(Long id) {
		Long count = cityRepo.countById(id);
		if(count == 0 || count == null ){
			throw new ResourceNotFoundException("City with id = "+String.valueOf(id)+"isn't found");
		}
		else cityRepo.deleteById(id);
	}
	
}
