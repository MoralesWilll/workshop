package Bezos.workshop.controllers;

import Bezos.workshop.entities.Event;
import Bezos.workshop.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping()
    public String listAll(Model model){
        model.addAttribute("events", eventService.findAll());
        return "list";
    }

    @GetMapping("/{id}")
    public String getEventById(@PathVariable String id, Model model){
        Optional<Event> event = eventService.findEventById(id);
        if(event.isPresent()){
            model.addAttribute("event", event.get());
            return "detail";
        }
        else {
            return "redirect:/events";
        }
    }

    @GetMapping("/create")
    public String createEvent(Model model){
        model.addAttribute("event", new Event());
        return "form";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String editEventForm(@PathVariable String id, Model model) {
        Optional<Event> event = eventService.findEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "form";
        } else {
            return "redirect:/events";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable String id, @ModelAttribute Event event) {
        event.setId(id);
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

}
