package com.josh.order_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Order("Coffee", "Hot Drink")));
            log.info("Preloading " + repository.save(new Order("Latte", "Hot Drink")));
        };
    }
}
