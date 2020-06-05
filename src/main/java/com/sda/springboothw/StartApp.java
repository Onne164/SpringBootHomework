package com.sda.springboothw;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApp implements CommandLineRunner {

    @Autowired
    PurchaseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Purchase("milk", 2.28));
        repository.save(new Purchase("eggs", 1.35));
        repository.save(new Purchase("apple", 32.61));
        repository.save(new Purchase("banana", 19.57));
        repository.save(new Purchase("pear", 30.13));

        Iterable<Purchase> iterator = repository.findAll();

        System.out.println("All items: ");
        iterator.forEach(item -> System.out.println(item));

        List<Purchase> myItem = repository.findByItem("banana");
        System.out.println("\nMy last purchase: ");
        myItem.forEach(item -> System.out.println(item));

        List<Purchase> expensiveItems = repository.listItemsWithPriceOver(30);
        System.out.println("\nExpensive items: ");
        expensiveItems.forEach(item -> System.out.println(item));

    }
}

