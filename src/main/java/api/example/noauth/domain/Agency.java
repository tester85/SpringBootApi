package api.example.noauth.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Agencia")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Agency {

	@Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    String city;

    @Column()
    private int reservaciones;
    
    public Agency() {
    	
    }
	public Agency(String name, String description, String city, int reservaciones) { 
		this.name = name;
		this.description = description;
		this.city = city;
		this.reservaciones = reservaciones;
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
	public int getReservaciones() {
		return reservaciones;
	}
	public void setReservaciones(int reservaciones) {
		this.reservaciones = reservaciones;
	}
	@Override
    public String toString() {
        return "agencia {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", reservaciones=" + reservaciones +
                '}';
    }
    
}
