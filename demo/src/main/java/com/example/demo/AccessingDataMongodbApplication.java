package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Thomas", "Brookshaw"));
        repository.save(new Customer("Jeff", "Brookshaw"));
        repository.save(new Customer("Charlie", "Brookshaw"));
        repository.save(new Customer("Quenton", "Dravis"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Thomas'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Thomas"));

        System.out.println("Customers found with findByLastName('Brookshaw'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Brookshaw")) {
            System.out.println(customer);
        }

    }

}