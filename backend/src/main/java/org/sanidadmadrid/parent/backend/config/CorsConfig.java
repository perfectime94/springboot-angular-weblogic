package org.sanidadmadrid.parent.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Creado por Lineu Martins el 06/07/2022 22:53
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	/*
	Permite acceder a los recursos del rest api desde el servidor del frontend levantado con ng serve en desarrollo
	backend localhost:7001 frontend localhost:4200
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
				.exposedHeaders("Authorization");
	}
}
