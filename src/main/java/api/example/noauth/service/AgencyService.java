package api.example.noauth.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.example.noauth.dao.jpa.AgencyRepository;
import api.example.noauth.domain.Agency;
import api.example.noauth.exception.ResourceNotFoundException;

@Service
public class AgencyService implements AgencyServiceInterface {

	public static final Logger Log = LoggerFactory.getLogger(Agency.class);

	@Autowired
	private AgencyRepository agencyR;

	public AgencyService() {
	}

	public Agency createAgencia(Agency agency) {
		return agencyR.save(agency);
	}

	public Agency getAgencia(long id) {
		Optional<Agency> result = agencyR.findById(id);
		if (result.isPresent()) {
			return agencyR.getAgenciaById(id);
		}
		throw new ResourceNotFoundException(
				"Agency not Found ->" + String.valueOf(id));
	}

	public void updateAgency(Agency agency) {
		agencyR.save(agency);
	}

	public void deleteAgency(long id) {
		Long count = agencyR.countById(id);
		if (count == null || count == 0) {
			throw new ResourceNotFoundException(
					"Agency not Found: " + String.valueOf(id));
		} else
			agencyR.deleteById(id);

	}

	public List<Agency> findAll() {
		return (List<Agency>) agencyR.findAll();
	}

}
