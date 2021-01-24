package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.example.app"})
@EntityScan("com.example.app.model")
@EnableJpaRepositories("com.example.app.repository")
public class AppApplication {
	public static void main(String[] args) 
	{
		SpringApplication.run(AppApplication.class, args);
	}
}
