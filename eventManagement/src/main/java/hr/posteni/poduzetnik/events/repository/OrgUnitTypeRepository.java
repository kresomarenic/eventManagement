package hr.posteni.poduzetnik.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hr.posteni.poduzetnik.events.model.OrgUnitType;

@Repository
public interface OrgUnitTypeRepository extends JpaRepository<OrgUnitType, Long>{
	
	@Query("SELECT out FROM OrgUnitType out WHERE out.code = :code")
	public OrgUnitType findByType(@Param("code") String code);

}
