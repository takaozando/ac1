package com.example.ac1.services;

import com.example.ac1.controllers.EventController;
import com.example.ac1.entidade.Event;
import com.example.ac1.repositorio.EventRepository;
import facens.example.ac1.dto.DTO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService 
{
    
    private String errorMessage = "Exceção lançada em" + getClass().getName();
    
    @Autowired
    private EventRepository repo;

    public Page<Event> getEvents(PageRequest pageRequest, String name, String place, String startDate, String description) 
    {
        return repo.find(pageRequest, name, place, startDate, description);
    }

    public Event getEventById(Long id) 
    {
        Optional<Event> op = repo.findById(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage));
    }

    public Event newEvent(DTO dto) 
    {
        Event event = new Event(dto);
        event = repo.save(event);
        return event;
    }

    public Event attEvent(Long id, DTO dto) 
    {
        try
        {
            Event event = repo.getOne(id);
            event.setName(dto.getName());
            event.setDescription(dto.getDescription());
            event.setPlace(dto.getPlace());
            event.setStartDate(dto.getStartDate());
            event.setEndDate(dto.getEndDate());
            event.setStartTime(dto.getStartTime());
            event.setEndTime(dto.getEndTime());
            event.setEmail(dto.getEmail());
            event = repo.save(event);
            return event;
        } 
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    public void deleteEvent(Long id) 
    {
        try 
        {
            repo.deleteById(id);
        } 
        catch (EmptyResultDataAccessException e) 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }
}
