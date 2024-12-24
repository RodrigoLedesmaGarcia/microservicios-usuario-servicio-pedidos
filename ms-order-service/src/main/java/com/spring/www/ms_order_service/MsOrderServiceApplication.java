package com.spring.www.ms_order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOrderServiceApplication.class, args);
	}

}
