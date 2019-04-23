package hr.posteni.poduzetnik.events.service;

import java.util.List;

import hr.posteni.poduzetnik.events.model.Event;

public interface EventService {
	
	void save(Event event);

	List<Event> findAll();

}
