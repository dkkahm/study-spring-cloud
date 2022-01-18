package com.example.university;

import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Value("${address.service.url}")
	private String addressServiceUrl;

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl(addressServiceUrl)
				.build();

		return webClient;
	}
}
