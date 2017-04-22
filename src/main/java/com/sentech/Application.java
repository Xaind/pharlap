package com.sentech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sentech.domain.Horse;
import com.sentech.repository.HorseRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private HorseRepository horseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//horseRepository.deleteAll();

		// save a couple of customers
		//horseRepository.save(new Horse("Alice"));
		//horseRepository.save(new Horse("Bob"));

		// fetch all customers
		System.out.println("Horses found with findAll():");
		System.out.println("-------------------------------");
		for (Horse horse : horseRepository.findAll()) {
			System.out.println(horse);
		}
		System.out.println();

		// fetch an individual horse
		System.out.println("Horse found with findByName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(horseRepository.findByName("Alice"));

		System.out.println("Horse found with findByName('Bob'):");
		System.out.println("--------------------------------");
		System.out.println(horseRepository.findByName("Bob"));
	}
}