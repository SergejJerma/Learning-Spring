package com.serjer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serjer.domain.LastLetter;

public interface LastLetterRepo extends JpaRepository<LastLetter, Long>{

}
