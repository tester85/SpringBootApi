package api.example.noauth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import api.example.noauth.dao.jpa.SystemUserRepository;
import api.example.noauth.domain.SystemUser;
import api.example.noauth.exception.ResourceNotFoundException;

@Service
public class SystemUserService{
	
	@Autowired
	private SystemUserRepository repoUser;

	public SystemUser createUser(SystemUser user) {
		return repoUser.save(user);
	}
	
	public Optional<SystemUser> getUser(Long id) {
		Optional<SystemUser> user = repoUser.findById(id);
		if(user.isPresent()) {
			return repoUser.findById(id);
		}
		else throw(new ResourceNotFoundException("User not found with id = "+String.valueOf(id)));		
	}
	
	public void updateSystemUser(SystemUser user) {
		repoUser.save(user);
	}
	
	public void deleteUser(Long id) {
		Long count = repoUser.countById(id);
		if(count ==0 || count == null){
			throw(new ResourceNotFoundException("User not found with id = "+String.valueOf(id)));
		}
		else repoUser.deleteById(id);
	}
	
	public List<SystemUser> findAll() {
		return repoUser.findAll();
	}
	
	
	

}
