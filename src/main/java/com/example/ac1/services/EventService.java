package com.example.ac1.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ac1.controllers.EventController;
import com.example.ac1.entidade.Event;
import com.example.ac1.repositorio.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EventService {
    

@Service
public class FuncionarioService {
    
    @Autowired
    EventRepository eventRepository;
    EventService eventService;
    EventController eventController;

    public Event saveEvent(Event e){
        eventRepository.save(e);
        return e;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(int id){
        for(Event e: eventRepository.findAll()){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

	public void deleteEvent(Event e) {
        if(getEventById(e.getId()) != null){
            eventRepository.deleteById(e.getId());
        }
    }

    public void deleteEventById(Integer codigo) {
        eventRepository.deleteById(codigo);
	}

    //rever funçao update
	public Event updateEvent(Event e) {

        Event alterar = getEventById(e.getId());
        
        if(alterar != null){
            alterar.setId(e.getId());
            alterar.setName(e.getName());
            alterar.setDescription(e.getDescription());
            alterar.setPlace(e.getPlace());
            alterar.setStartDate(e.getStartDate());
            alterar.setEndDate(e.getEndDate());
            alterar.setStartTime(e.getStartTime());
            alterar.setEndTime(e.getEndTime());
            alterar.setEmailContact(e.getEmailContact());
            alterar.setName(e.getName());
            return alterar;     
       }
       else
       {
           return null;
       }
    }
    
    ////////TESTING////////
    public void insereListaFunc(){
        LocalDateTime time = LocalDateTime.now();
        //eventRepository.save(new Event("Joao",52,"CEO","Escritorio A","CEO da empresa",time,1200.00,null));
    }
}
