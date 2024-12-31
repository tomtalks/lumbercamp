package com.soprasteria.lumbercamp;

import com.soprasteria.lumbercamp.model.Stock;
import com.soprasteria.lumbercamp.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class LumberCampApplication {

	public static void main(String[] args) {SpringApplication.run(LumberCampApplication.class, args);}

	@Bean
	public CommandLineRunner demo(StockRepository repository) {
		return (args) -> {
			Random r = new Random();
			// sAdd Stock
			repository.save(new Stock("oak", r.nextInt(50)));
			repository.save(new Stock("teak", r.nextInt(50)));
			repository.save(new Stock("pine", r.nextInt(50)));
			repository.save(new Stock("cedar", r.nextInt(50)));
			repository.save(new Stock("ash", r.nextInt(50)));
			repository.save(new Stock("fir", r.nextInt(50)));
			repository.save(new Stock("maple", r.nextInt(50)));
			repository.save(new Stock("walnut", r.nextInt(50)));


			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Stock stock : repository.findAll()) {
				log.info(stock.toString());
			}
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByType("oak").forEach(s -> {
				log.info(s.toString());
			});
			repository.save(new Stock("oak", -r.nextInt(50)));
			repository.getStock("oak").forEach(s -> {
				log.info(s.toString());
			});

			log.info("");
		};
	}
}
