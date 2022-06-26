package api.example.noauth.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.example.noauth.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	Optional<City> findById(Long id);
	public Long countById(Long id);
	List<City> findAll();

}
