package com.example.limitservice.controller;

import com.example.limitservice.configuration.LimitConfiguration;
import com.example.limitservice.dto.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private LimitConfiguration limitConfiguration;

    @GetMapping("/limit")
    public Limit getLimit() {
        return new Limit(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
    }
}
