package com.example.university.service;

import com.example.university.domain.Address;
import com.example.university.dto.request.CreateAddressRequest;
import com.example.university.dto.response.AddressResponse;
import com.example.university.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Transactional
    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());
        address = repository.save(address);

        return new AddressResponse(address);
    }

    @Transactional
    public AddressResponse getById(long id) {
        log.info("Inside Address getById");

        return new AddressResponse(repository.findById(id).get());
    }
}
