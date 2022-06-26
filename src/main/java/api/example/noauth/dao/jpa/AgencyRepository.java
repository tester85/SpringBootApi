package api.example.noauth.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.example.noauth.domain.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

	Agency findAgenciaByCity(String city);
	Agency getAgenciaById(long id);
	public Long countById(Long id);
}
