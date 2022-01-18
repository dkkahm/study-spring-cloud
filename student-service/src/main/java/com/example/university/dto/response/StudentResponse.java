package com.example.university.dto.response;

import com.example.university.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private AddressResponse addressResponse;

    public StudentResponse(Student student) {
        studentId = student.getStudentId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
    }
}
