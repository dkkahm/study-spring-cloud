package com.example.university.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse {
    private Long addressId;
    private String street;
    private String city;
}
