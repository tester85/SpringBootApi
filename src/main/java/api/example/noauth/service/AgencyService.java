package api.example.noauth.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.example.noauth.dao.jpa.AgencyRepository;
import api.example.noauth.domain.Agency;

@Service
public class AgencyService {

	public static final Logger Log = LoggerFactory.getLogger(Agency.class);

	// @Autowired
	// CounterService counterService;

	@Autowired
	private AgencyRepository agencyR;

	public AgencyService() {
	}

	public Agency createAgencia(Agency agency) {
		return agencyR.save(agency);
	}

	public Agency getAgencia(long id) {
		return agencyR.getAgenciaById(id);
	}

	public void updateAgency(Agency agency) {
		agencyR.save(agency);
	}

	public void deleteAgency(long id) {
		agencyR.deleteById(id);
	}
	
	public List<Agency> findAll(){
		return (List<Agency>) agencyR.findAll(); 
	}

	/*
	 * -- Probar paginado próximas versiones //http://goo.gl/7fxvVf public
	 * Page<Agency> getAllAgencies(Integer page, Integer size) { Page
	 * pageOfAgencies = agencyR.findAll(new PageRequest(page, size)); // example
	 * of adding to the /metrics if (size > 50) {
	 * counterService.increment("api.AgencyService.getAll.largePayload"); }
	 * return pageOfAgencies; }
	 * 
	 */
}
