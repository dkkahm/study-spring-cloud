package com.example.university.dto.response;

import com.example.university.domain.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressResponse {
    private Long addressId;
    private String street;
    private String city;

    public AddressResponse(Address address) {
        this.addressId = address.getAddressId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }
}
