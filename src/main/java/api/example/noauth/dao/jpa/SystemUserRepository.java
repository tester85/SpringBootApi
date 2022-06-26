package api.example.noauth.dao.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.example.noauth.domain.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
	
	SystemUser getUserByEmail(String email);
	Optional<SystemUser> findById(Long id);
	public Long countById(Long id);

}
