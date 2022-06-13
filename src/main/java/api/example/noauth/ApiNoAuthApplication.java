package api.example.noauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.example.noauth.dao.jpa.AgencyRepository; 

@SpringBootApplication
public class ApiNoAuthApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiNoAuthApplication.class, args);
	}

	@Autowired
	AgencyRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// get more information
		//Agency agency1 = new Agency("Chucal", "Compra y Venta", "Nicaragua", 300);
		//repository.save(agency1);
		
	}

}
	