package com.example.university.service;

import com.example.university.domain.Student;
import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.dto.response.AddressResponse;
import com.example.university.dto.response.StudentResponse;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private WebClient webClient;

    @Transactional
    public StudentResponse createStudent(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddressId(request.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        return studentResponse;
    }

    @Transactional
    public StudentResponse getById(long id) {
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        return studentResponse;
    }

    public AddressResponse getAddressById(long addressId) {
        return webClient.get()
                .uri("/getById/" + addressId)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
    }

    @Transactional
    public void saveStudent(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddressId(request.getAddressId());
        student = studentRepository.save(student);
    }
}
