package org.safebank.consumersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumersServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumersServiceApplication.class, args);
    }
}
