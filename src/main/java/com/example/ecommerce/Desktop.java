package com.example.ecommerce;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class Desktop implements Computer{

    public void compile() {
        System.out.println("Compiling with 404 bugs but faster!!");
    }
}
