package hr.posteni.poduzetnik.events.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.posteni.poduzetnik.events.model.OrgUnit;
import hr.posteni.poduzetnik.events.model.OrgUnitType;
import hr.posteni.poduzetnik.events.repository.OrgUnitRepository;
import hr.posteni.poduzetnik.events.repository.OrgUnitTypeRepository;
import hr.posteni.poduzetnik.events.service.OrgUnitService;

@Service
public class OrgUnitServiceImpl implements OrgUnitService {
	
	@Autowired
	private OrgUnitRepository orgUnitRepository;
	
	@Autowired
	private OrgUnitTypeRepository orgUnitTypeRepository;

	@Override
	@Transactional
	public List<OrgUnit> findAllByType(String orgUnitTypeCode) {
		OrgUnitType orgUnitType = orgUnitTypeRepository.findByType(orgUnitTypeCode);
		return orgUnitRepository.findAllByType(orgUnitType);
	}

	@Override
	public List<OrgUnit> findAllByRegion(Set<OrgUnit> orgUnit) {		
		return orgUnitRepository.findAllByRegion(orgUnit);
	}

}
