package com.example.university.service;

import com.example.university.domain.Student;
import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.dto.response.AddressResponse;
import com.example.university.dto.response.StudentResponse;
import com.example.university.feignclients.AddressFeignClient;
import com.example.university.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CommonService commonService;

    @Transactional
    public StudentResponse createStudent(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setAddressId(request.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

        return studentResponse;
    }

    @Transactional
    public StudentResponse getById(long id) {
        log.info("Inside Student getById");

        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse;
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
