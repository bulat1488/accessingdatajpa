package com.example.accessingdatajpa;

import com.example.accessingdatajpa.dto.ClickOrders;
import com.example.accessingdatajpa.dto.Customer;
import com.example.accessingdatajpa.service.ClickOrderRepository;
import com.example.accessingdatajpa.service.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demoOrder(ClickOrderRepository clickOrderRepository, CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			clickOrderRepository.save(new ClickOrders("sneakers", "super","15.05.2021 12:08"));
			clickOrderRepository.save(new ClickOrders("cap", "-","18.09.2021 15:55"));
			clickOrderRepository.save(new ClickOrders("shorts", "++++++!!!","29.11.2021 09:18"));
			clickOrderRepository.save(new ClickOrders("swimsuit", "very open","06.01.2022 11:11"));
			clickOrderRepository.save(new ClickOrders("track suit", "not a high-quality suit","12.04.2021 16:15"));
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers and orders
			log.info("Orders found with findAll():");
			log.info("-------------------------------");
			for (ClickOrders clickOrders : clickOrderRepository.findAll()) {
				log.info(clickOrders.toString());
			}
			log.info("");

			log.info("Customer found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer and orders by ID
			ClickOrders clickOrders = clickOrderRepository.findById(4L);
			log.info("Orders found with findById(4L):");
			log.info("--------------------------------");
			log.info(clickOrders.toString());
			log.info("");

			Customer customer = repository.findById(8L);
			log.info("Customer found with findById(8L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers and orders by last name
			log.info("Orders found with findValue('shorts'):");
			log.info("--------------------------------------------");
			clickOrderRepository.findByValue("shorts").forEach(shorts -> {
				log.info(shorts.toString());
			log.info("");
			});

			log.info("Customer found with findValue('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());

			});
			log.info("");
		};
	}

}
