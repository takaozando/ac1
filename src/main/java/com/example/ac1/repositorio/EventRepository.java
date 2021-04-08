package com.example.ac1.repositorio;

import com.example.ac1.entidade.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    
    @Query(value = " select ev from TB_event ev where " + 
                   " upper(ev.name) like upper(CONCAT('%', :ev.name,  '%')) and " +
                   " upper(ev.place) like upper(CONCAT('%', :ev.place, '%')) and " +
                   " upper(ev.description) like upper(CONCAT('%', :ev.description, '%')) and " +
                   " CAST(ev.start_date AS VARCHAR) like CONCAT('%', :ev.startDate, '%')", nativeQuery = true
    )
    public Page<Event> find(Pageable pageRequest, String name, String place, String startDate, String description);
}
