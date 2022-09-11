package com.revature.tarotcards.p2scapegoats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication enable this three features:
 * @EnableAutoconfiguration: automatically crates and registers beans based on both the included jar files in the classpath and the beans defined by us.
 * @ComponentScan: enables Spring to scan for things like configuration, controllers, services, and other components we define.
 * @Configuration: allow to register extra beans in the context or import additional configuration classes
 */
@SpringBootApplication
public class P2ScapeGoatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(P2ScapeGoatsApplication.class, args);
    }

}
