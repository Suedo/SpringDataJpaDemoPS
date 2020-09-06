package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {
    List<Speaker> findByFirstNameAndLastName(String firstName, String LastName);
    List<Speaker> findByFirstNameOrLastName(String firstName, String LastName);
}
