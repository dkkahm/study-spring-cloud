package com.example.university.controller;

import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.dto.response.StudentResponse;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable long id) {
        return studentService.getById(id);
    }
}
