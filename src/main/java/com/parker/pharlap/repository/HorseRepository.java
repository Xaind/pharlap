package com.parker.pharlap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.parker.pharlap.domain.Horse;

/**
 * Repository for a horse.
 */
public interface HorseRepository extends MongoRepository<Horse, String> {

	Horse findByName(String name);
}
