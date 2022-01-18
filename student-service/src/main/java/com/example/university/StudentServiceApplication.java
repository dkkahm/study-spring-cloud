package com.example.university;

import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		CreateStudentRequest s1 = new CreateStudentRequest();
		s1.setStreet("sanbon");
		s1.setCity("gunpo");
		s1.setFirstName("dongki");
		s1.setLastName("kam");
		s1.setEmail("kam.dongki@bbb.com");
		studentService.createStudent(s1);

		CreateStudentRequest s2 = new CreateStudentRequest();
		s2.setStreet("st2");
		s2.setCity("ct2");
		s2.setFirstName("fn2");
		s2.setLastName("ln2");
		s2.setEmail("em2");
		studentService.createStudent(s2);
	}
}
