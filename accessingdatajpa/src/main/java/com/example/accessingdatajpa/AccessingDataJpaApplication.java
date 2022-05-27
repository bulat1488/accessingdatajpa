package com.example.accessingdatajpa;

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
	public CommandLineRunner demoOrder(ClickOrderRepository clickOrderRepository) {
		return (args) -> {
			// save a few customers
			clickOrderRepository.save(new ClickOrders("sneakers", "super","15.05.2021 12:08"));
			clickOrderRepository.save(new ClickOrders("cap", "-","18.09.2021 15:55"));
			clickOrderRepository.save(new ClickOrders("shorts", "++++++!!!","29.11.2021 09:18"));
			clickOrderRepository.save(new ClickOrders("swimsuit", "very open","06.01.2022 11:11"));
			clickOrderRepository.save(new ClickOrders("track suit", "not a high-quality suit","12.04.2021 16:15"));
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Orders found with findAll():");
			log.info("-------------------------------");
			for (ClickOrders clickOrders : clickOrderRepository.findAll()) {
				log.info(clickOrders.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			ClickOrders clickOrders = clickOrderRepository.findById(1L);
			log.info("Orders found with findById(1L):");
			log.info("--------------------------------");
			log.info(clickOrders.toString());
			log.info("");

			// fetch customers by last name
			log.info("Orders found with findValue('shorts'):");
			log.info("--------------------------------------------");
			clickOrderRepository.findByValue("shorts").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
