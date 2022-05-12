package com.foodorderingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class FoodOrderingAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingAppApiApplication.class, args);
		log.info("succes");
	}

}
