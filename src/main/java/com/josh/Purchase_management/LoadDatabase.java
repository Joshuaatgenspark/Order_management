package com.josh.Purchase_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PurchaseRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Purchase("Coffee", "Hot Drink")));
            log.info("Preloading " + repository.save(new Purchase("Latte", "Hot Drink")));
        };
    }
}
