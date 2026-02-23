package com.ddi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class that contains the main entry point of the application.
 *
 * @author Antonio
 */
@SpringBootApplication
public class DdiApplication {

    /**
     * Pre: args not null.
     * Post: the Spring Boot application is started.
     */
    public static void main(String[] args) {
        SpringApplication.run(DdiApplication.class, args);
    }
}
