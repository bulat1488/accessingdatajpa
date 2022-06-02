package com.example.accessingdatajpa;

import com.example.accessingdatajpa.dto.ClickOrders;
import com.example.accessingdatajpa.dto.Customer;
import com.example.accessingdatajpa.repository.ClickOrderRepository;
import com.example.accessingdatajpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}
}

