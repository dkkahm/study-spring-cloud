package com.example.university.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private long addressId;
}
