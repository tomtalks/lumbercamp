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

    public static final int NEW_STOCK = 15;

    public static void main(String[] args) {SpringApplication.run(LumberCampApplication.class, args);}

	@Bean
	public CommandLineRunner demo(StockRepository repository) {
		return (args) -> {
			Random r = new Random();
			// sAdd Stock
			repository.save(new Stock("oak", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("teak", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("pine", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("cedar", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("ash", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("fir", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("maple", r.nextInt(NEW_STOCK)));
			repository.save(new Stock("walnut", r.nextInt(NEW_STOCK)));


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
			repository.save(new Stock("oak", -r.nextInt(NEW_STOCK)));
			repository.getStock("oak").forEach(s -> {
				log.info(s.toString());
			});

			log.info("");
		};
	}
}
