package ru.itis.PdfGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.itis.repositories")
@ComponentScan(basePackages = "ru.itis")
@EntityScan(basePackages = "ru.itis")
public class PdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
	}
}
