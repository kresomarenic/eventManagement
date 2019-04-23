package hr.posteni.poduzetnik.events.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CITY_SIZE")
@Data
public class CitySize {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CS_ID")
	private Long id;
	
	@Column(name="CS_CODE")	
	private String code;
	
	@Column(name="CS_NAME")
	private String name;
	
	@Column(name="CS_ACTIVE")
	private Boolean isActive;
	
	@OneToMany(mappedBy="citySize")
	private List<City> cities;

	@Override
	public String toString() {
		return super.toString();
	}

}
