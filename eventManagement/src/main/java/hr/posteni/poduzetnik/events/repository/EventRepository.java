package hr.posteni.poduzetnik.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.posteni.poduzetnik.events.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
