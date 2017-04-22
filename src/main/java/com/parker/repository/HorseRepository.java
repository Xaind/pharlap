package com.parker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.parker.domain.Horse;

/**
 * Repository for a horse.
 */
public interface HorseRepository extends MongoRepository<Horse, String> {

	Horse findByName(String name);
}
