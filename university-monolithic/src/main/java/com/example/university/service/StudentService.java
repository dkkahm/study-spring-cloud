package com.example.university.service;

import com.example.university.domain.Address;
import com.example.university.domain.Student;
import com.example.university.dto.request.CreateStudentRequest;
import com.example.university.dto.response.StudentResponse;
import com.example.university.repository.AddressRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public StudentResponse createStudent(CreateStudentRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address = addressRepository.save(address);

        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());

        student.setAddress(address);

        student = studentRepository.save(student);

        return new StudentResponse(student);
    }

    public StudentResponse getById(long id) {
        return new StudentResponse(studentRepository.findById(id).get());
    }
}
