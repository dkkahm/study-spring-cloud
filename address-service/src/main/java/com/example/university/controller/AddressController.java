package com.example.university.controller;

import com.example.university.dto.request.CreateAddressRequest;
import com.example.university.dto.response.AddressResponse;
import com.example.university.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Value("${address.test}")
    private String test;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id) {
        log.info("servicing getById");
        return addressService.getById(id);
    }

    @GetMapping("/test")
    public String getTest() {
        return test;
    }
}
