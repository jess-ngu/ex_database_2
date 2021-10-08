package ca.sheridancollege.nguye399.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "ca.sheridancollege.nguye399.controllers", "ca.sheridancollege.nguye399.database",
		"ca.sheridancollege.nguye399.drinks", "ca.sheridancollege.nguye399.security" })
public class Exercise7Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise7Application.class, args);
	}

}
