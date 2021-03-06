package com.example.ac1.entidade;

import com.example.ac1.dto.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_event")
public class Event implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String email;

    public Long getId() 
    {
        return id;
    }
    public void setId(long id) 
    {
        this.id = id;
    }
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public String getDescription() 
    {
        return description;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }
    public String getPlace() 
    {
        return place;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }
    public LocalDate getStartDate() 
    {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) 
    {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() 
    {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) 
    {
        this.endDate = endDate;
    }
    public LocalTime getStartTime() 
    {
        return startTime;
    }
    public void setStartTime(LocalTime starTime) 
    {
        this.startTime = starTime;
    }
    public LocalTime getEndTime() 
    {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) 
    {
        this.endTime = endTime;
    }
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id != other.id)
            return false;
        else
            return true;
    }

    public Event(DTO dto) 
    {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.place = dto.getPlace();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.email = dto.getEmail();
    }

}
