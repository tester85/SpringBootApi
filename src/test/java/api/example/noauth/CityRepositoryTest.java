package api.example.noauth;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import api.example.noauth.dao.jpa.CityRepository;
import api.example.noauth.domain.City;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class CityRepositoryTest {
	
	@Autowired 
	private CityRepository cityRepo;
	
	@Test
	public void addNew() {
		City city = new City();
		city.setName("");
		City savedCity = cityRepo.save(city);
		
		Assertions.assertThat(savedCity.getName()).isNotEmpty();
	}
	
	@Test
	public void testListAll() {
		List<City> city = cityRepo.findAll();
		Assertions.assertThat(city).hasSizeGreaterThanOrEqualTo(0);
	}
	
}
