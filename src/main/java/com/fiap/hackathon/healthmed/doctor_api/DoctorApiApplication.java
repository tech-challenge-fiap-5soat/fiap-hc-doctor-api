package com.fiap.hackathon.healthmed.doctor_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoctorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApiApplication.class, args);
	}

}
