package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

//    @Autowired                      // Field Injection
//    private Laptop laptop;

    private final Computer comp;      // Constructor Injection

    public Dev(@Qualifier("desktop") Computer comp) {
        this.comp = comp;
    }

//    private Laptop laptop;          // Setter Injection
//
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public void build() {
        comp.compile();
        System.out.println("Working on great project!!");
    }
}
