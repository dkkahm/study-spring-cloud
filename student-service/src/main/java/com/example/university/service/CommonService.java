package com.example.university.service;

import com.example.university.dto.response.AddressResponse;
import com.example.university.feignclients.AddressFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommonService {

    @Autowired
    private AddressFeignClient addressFeignClient;

    private long count = 1;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById(long addressId) {
        log.info("count = {}", count);
        ++ count;
        return addressFeignClient.getById(addressId);
    }

    public AddressResponse fallbackGetAddressById(long addressId, Throwable ex) {
        log.error("Error", ex);
        return new AddressResponse();
    }
}
