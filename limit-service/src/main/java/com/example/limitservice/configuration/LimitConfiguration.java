package com.example.limitservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("limit-service")
public class LimitConfiguration {
    private int minimum;
    private int maximum;
}
