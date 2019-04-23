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
@Table(name="ORG_UNIT")
@Data
public class OrgUnit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OU_ID")
	private Long id;
	
	@Column(name="OU_NAME")
	private String name;
	
	@Column(name="OU_DESCR")
	private String description;
	
	@ManyToOne
    @JoinColumn(name="OU_TYPE_ID")	
    private OrgUnitType orgUnitType;
	
	@OneToMany
	private List<City> cities;
	
	@ManyToOne
	@JoinColumn(name="OU_PARENT_ID")
	private OrgUnit orgUnit;
	
	@OneToMany(mappedBy="orgUnit")
	private List<OrgUnit> orgUnits;

	@Override
	public String toString() {
		return super.toString();
	}

}
