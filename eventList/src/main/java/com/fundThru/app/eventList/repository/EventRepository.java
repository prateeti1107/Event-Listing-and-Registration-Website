package com.fundThru.app.eventList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundThru.app.eventList.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

	@Query("select e from Event e")
	List<Event> getAllEvents();
	
	@Query(nativeQuery = true, value ="select * from Event e where e.event_id = :eventId")
	Event findEventById(@Param("eventId")Long eventId);
}
