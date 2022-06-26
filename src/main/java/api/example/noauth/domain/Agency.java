package api.example.noauth.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Agencia")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Agency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1732528687425875767L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(length = 120)
    String city;

    @Column()
    private int reservation;
    
    public Agency() {
    	
    }
   /* public Agency(Long id, String name, String description, String city, int reservation) { 
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.reservation = reservation;
	}*/
    
	public Agency(String name, String description, String city, int reservation) { 
		this.name = name;
		this.description = description;
		this.city = city;
		this.reservation = reservation;
	}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	 
	public int getReservation() {
		return reservation;
	}
	public void setReservation(int reservation) {
		this.reservation = reservation;
	}
	@Override
    public String toString() {
        return "Agencia {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", reservation=" + reservation +
                '}';
    }
    
}
