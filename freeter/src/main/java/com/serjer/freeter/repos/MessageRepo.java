package com.serjer.freeter.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serjer.freeter.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
	
	List<Message> findByTag(String tag);

}
