package com.thonglam.tedprojectbackend;

import com.thonglam.tedprojectbackend.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class TedprojectbackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TedprojectbackendApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TedprojectbackendApplication.class);
	}



	@Bean
	public CorsFilter corsFilter(){
		final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
