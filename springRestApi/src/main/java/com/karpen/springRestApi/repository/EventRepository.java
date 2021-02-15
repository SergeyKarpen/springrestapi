package com.karpen.springRestApi.repository;

import com.karpen.springRestApi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
