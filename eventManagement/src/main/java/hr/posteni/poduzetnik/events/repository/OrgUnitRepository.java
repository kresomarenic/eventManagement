package hr.posteni.poduzetnik.events.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hr.posteni.poduzetnik.events.model.OrgUnit;
import hr.posteni.poduzetnik.events.model.OrgUnitType;

@Repository
public interface OrgUnitRepository extends JpaRepository<OrgUnit, Long>{
	
	@Query("SELECT ou FROM OrgUnit ou WHERE ou.orgUnitType = :orgUnitType")
	public List<OrgUnit> findAllByType(@Param("orgUnitType") OrgUnitType type);
	
	@Query("SELECT ou FROM OrgUnit ou WHERE ou.orgUnit IN (:orgUnit)")
	List<OrgUnit> findAllByRegion(@Param("orgUnit") Set<OrgUnit> orgUnit);

}
