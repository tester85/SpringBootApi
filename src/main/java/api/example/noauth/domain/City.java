package api.example.noauth.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	
	@Column(length = 25, nullable = false, unique = true)
	private String name;
	
	public City() {
	}
	
	public City(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	} 

	@Override
	public String toString() {
		return "City {" +
				"id=" + id +
				", name='" + name + '\'' +				  
				'}';
	}
	

}
