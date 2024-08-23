package Bezos.workshop.services;

import Bezos.workshop.entities.Event;
import Bezos.workshop.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(String id){
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }

    public void deleteEvent(String id){
        eventRepository.deleteById(id);
    }

}