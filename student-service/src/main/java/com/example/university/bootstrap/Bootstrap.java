package com.example.university.bootstrap;

import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        CreateStudentRequest s1 = new CreateStudentRequest();
        s1.setFirstName("dongki");
        s1.setLastName("kam");
        s1.setEmail("kam.dongki@bbb.com");
        s1.setAddressId(1);
        studentService.saveStudent(s1);

        CreateStudentRequest s2 = new CreateStudentRequest();
        s2.setFirstName("fn2");
        s2.setLastName("ln2");
        s2.setEmail("em2");
        s2.setAddressId(2);
        studentService.saveStudent(s2);
    }
}
