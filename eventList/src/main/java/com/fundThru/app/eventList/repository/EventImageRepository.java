package com.fundThru.app.eventList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fundThru.app.eventList.model.EventImage;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage, Long>{

	
//	@Modifying
//	@Query(nativeQuery = true, value = "update event_image ei set ei.event_id = :eventId where ei.pic_id = :picId")
//	@Transactional
//	int updateEventIdforImage(@Param("pic_id") Long picId, @Param("event_id") Long eventId);

	@Query(nativeQuery = true, value = "select * from event_image e where e.pic_id = :picId")
	EventImage getPicture(@Param("picId") Long picId);
	
	@Query(nativeQuery = true, value = "select p.filename from event_image p where p.pic_id = :picId")
	String getFilename(@Param("picId") Long picId);
}
