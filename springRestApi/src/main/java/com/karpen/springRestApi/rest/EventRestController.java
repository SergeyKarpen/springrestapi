package com.karpen.springRestApi.rest;

import com.karpen.springRestApi.model.Event;
import com.karpen.springRestApi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/karpen/api/")
public class EventRestController {

    private  final EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @ResponseBody
    @GetMapping(value = "/events")
    @PreAuthorize("hasAnyAuthority('user', 'moderator', 'admin')")
    public String findAll() {
        List<Event> events = eventService.findAll();
        return events.toString();
    }

    @ResponseBody
    @GetMapping(value = "/event/{id}")
    @PreAuthorize("hasAnyAuthority('user', 'moderator', 'admin')")
    public String findById(@PathVariable("id") Long id) {
        return eventService.findById(id).toString();
    }

    @ResponseBody
    @DeleteMapping(value = "/event-deleted/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deletedById (@PathVariable("id") Long id) {
        eventService.deletedById(id);
        return "deleted event with id = " + id;
    }

    @ResponseBody
    @PostMapping(value = "/event-save")
    @PreAuthorize("hasAuthority('admin')")
    public String save (@RequestBody Event event) {
        eventService.save(event);
        return "save event with id = " + event.getId();
    }
}
