package io.infinitydown.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The entry point for the Spring Boot application.
 * This class contains the main method that starts the application.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"io.infinitydown.library"})
public class LibraryApplication {

	/**
	 * The main method that launches the Spring Boot application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
