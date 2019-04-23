package hr.posteni.poduzetnik.events.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.model.OrgUnit;
import hr.posteni.poduzetnik.events.repository.CityRepository;
import hr.posteni.poduzetnik.events.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> findAllByCounties(Set<OrgUnit> counties) {		
		return cityRepository.findAllByCounties(counties);
	}

}
