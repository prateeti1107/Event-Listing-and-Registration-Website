package com.fundThru.app.eventList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundThru.app.eventList.model.UserEvent;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long>{

	@Query(nativeQuery = true, value = "select * from user_event u where u.user_id = :userId")
	List<UserEvent> getUserEvent(@Param("userId")Long userId);
}
