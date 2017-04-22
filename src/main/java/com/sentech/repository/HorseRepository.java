package com.sentech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sentech.domain.Horse;

/**
 * Repository for a horse.
 */
public interface HorseRepository extends MongoRepository<Horse, String> {

	Horse findByName(String name);
}
