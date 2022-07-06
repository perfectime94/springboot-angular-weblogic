package org.sanidadmadrid.parent.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * Creado por Lineu Martins el 27/06/2022 13:10
 */
@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
