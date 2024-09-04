package io.infinitydown.library;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Configures the Spring Boot application when deployed as a WAR.
 * This class extends SpringBootServletInitializer to configure the application context.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configures the Spring application builder.
	 *
	 * @param application the Spring application builder
	 * @return the configured application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibraryApplication.class);
	}

}
