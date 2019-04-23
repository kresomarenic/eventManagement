package hr.posteni.poduzetnik.events.service;

import java.util.List;
import java.util.Set;

import hr.posteni.poduzetnik.events.model.OrgUnit;

public interface OrgUnitService {
			
	List<OrgUnit> findAllByType(String type);
	
	List<OrgUnit> findAllByRegion(Set<OrgUnit> orgUnits);

}
