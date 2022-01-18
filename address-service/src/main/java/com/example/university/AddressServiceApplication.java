package com.example.university;

import com.example.university.dto.request.CreateAddressRequest;
import com.example.university.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddressServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

	@Autowired
	private AddressService addressService;

	@Override
	public void run(String... args) throws Exception {
		CreateAddressRequest a1 = new CreateAddressRequest();
		a1.setStreet("sanbon");
		a1.setCity("gunpo");
		addressService.createAddress(a1);

		CreateAddressRequest a2 = new CreateAddressRequest();
		a1.setStreet("st2");
		a1.setCity("ct2");
		addressService.createAddress(a1);
	}
}
