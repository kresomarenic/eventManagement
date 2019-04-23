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
@Table(name="ORG_UNIT_TYPE")
@Data
public class OrgUnitType {
	
	public static final String OU_TYPE_REGION = "REG";
	public static final String OU_TYPE_COUNTY = "ZUP";
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OUT_ID")
	private Long id;
	
	@Column(name="OUT_CODE")
	private String code;
	
	@Column(name="OUT_NAME")
	private String name;
	
	@Column(name="OUT_ACTIVE")
	private Boolean isActive;
	
	@OneToMany(mappedBy="orgUnitType")
	private List<OrgUnit> orgUnits;

	@Override
	public String toString() {
		return super.toString();
	}

}
