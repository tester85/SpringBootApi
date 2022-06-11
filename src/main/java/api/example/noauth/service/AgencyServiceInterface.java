package api.example.noauth.service;

import java.util.List;

import api.example.noauth.domain.Agency;

public interface AgencyServiceInterface {
	
	public Agency createAgencia(Agency agency);

	public Agency getAgencia(long id);

	public void updateAgency(Agency agency);

	public void deleteAgency(long id);
	
	public List<Agency> findAll();


}
