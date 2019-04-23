package hr.posteni.poduzetnik.events.service;

import java.util.List;
import java.util.Set;

import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.model.OrgUnit;

public interface CityService {
	
	List<City> findAllByCounties(Set<OrgUnit> counties);

}
