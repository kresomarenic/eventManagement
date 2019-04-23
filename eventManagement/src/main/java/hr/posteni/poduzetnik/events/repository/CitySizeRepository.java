package hr.posteni.poduzetnik.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.posteni.poduzetnik.events.model.CitySize;

@Repository
public interface CitySizeRepository extends JpaRepository<CitySize, Long>{

}
