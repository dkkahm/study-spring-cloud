package com.example.university.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAddressRequest {
    private String street;
    private String city;
}
