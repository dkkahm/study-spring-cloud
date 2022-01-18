package com.example.university.service;

import com.example.university.domain.Student;
import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.dto.response.AddressResponse;
import com.example.university.dto.response.StudentResponse;
import com.example.university.feignclients.AddressFeignClient;
import com.example.university.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressFeignClient addressFeignClient;

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

    @CircuitBreaker(name = "addressService")
    public AddressResponse getAddressById(long addressId) {
        return addressFeignClient.getById(addressId);
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
