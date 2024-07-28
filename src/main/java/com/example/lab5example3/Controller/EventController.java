package com.example.lab5example3.Controller;

import com.example.lab5example3.APIController.API;
import com.example.lab5example3.Model.Event;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")

public class EventController {
    ArrayList<Event> events = new ArrayList<Event>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {

        return events;
    }

    @PostMapping("/add")
    public API addEvent(@RequestBody Event event) {
        events.add(event);
        return new API("Successfully added event");
    }

    @PutMapping("/update/{index}")
    public API updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new API("Successfully updated event");
    }

    @DeleteMapping("/delete/{index}")
    public API deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new API("Successfully deleted event");
    }

    @PutMapping("/set/{index1}/{capacity}")
    public API setEvent(@PathVariable int index1, @PathVariable int capacity) {
        for (Event event : events) {
            events.get(index1).setCapacity(capacity);
        }
        return new API("Successfully changed capacity");
    }
    @GetMapping("/search/{id}")
    public Event searchEvent(@PathVariable String id) {
        for (Event event : events) {
           if (event.getId().equals(id)){
               return event;
        }}return null;
    }

}
