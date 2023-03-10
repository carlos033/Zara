package com;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.precarga.PrecargaBD;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title = "Zara API", version = "1.0", description = "Informacion stock Zara"))
@SpringBootApplication
public class OxigentApplication {
	@Autowired
	private PrecargaBD myDatabaseSeeder;

	public static void main(String[] args) {
		SpringApplication.run(OxigentApplication.class, args);
	}

	@Bean
	InitializingBean seedDatabase() {
		return () -> {
			myDatabaseSeeder.precargarBaseDeDatos();
		};
	}
}
