package hr.posteni.poduzetnik.events.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hr.posteni.poduzetnik.events.model.City;
import hr.posteni.poduzetnik.events.model.OrgUnit;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query("SELECT c FROM City c WHERE c.orgUnit IN (:orgUnit)")
	List<City> findAllByCounties(@Param("orgUnit") Set<OrgUnit> orgUnit);

}
