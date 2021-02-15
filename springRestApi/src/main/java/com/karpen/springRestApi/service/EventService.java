package com.karpen.springRestApi.service;

import com.karpen.springRestApi.model.Event;
import com.karpen.springRestApi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findById(Long id) {
        return eventRepository.getOne(id);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deletedById(Long id) {
        eventRepository.deleteById(id);
    }
}
