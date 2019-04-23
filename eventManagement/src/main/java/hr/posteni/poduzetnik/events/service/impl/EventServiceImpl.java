package hr.posteni.poduzetnik.events.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.posteni.poduzetnik.events.model.Event;
import hr.posteni.poduzetnik.events.repository.EventRepository;
import hr.posteni.poduzetnik.events.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public void save(Event event) {
		eventRepository.save(event);		
	}

	@Override
	public List<Event> findAll() {		
		return eventRepository.findAll();
	}
	
}
