package hr.posteni.poduzetnik.events.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CITY")
@Data
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="C_ID")
	private Long id;
	
	@Column(name="C_CODE")
	private String code;
	
	@Column(name="C_NAME")
	private String name;
	
	@ManyToOne
    @JoinColumn(name="C_SIZE_ID")
    private CitySize citySize;
	
	@ManyToOne
    @JoinColumn(name="C_OU_ID")
    private OrgUnit orgUnit;
	
	@OneToMany(mappedBy="city")
	private List<Event> events;

	@Override
	public String toString() {		
		return super.toString();
	}

}
