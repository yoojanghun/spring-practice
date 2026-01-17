package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "hello world!!";
    }

    @RequestMapping("/about")
    public String about() {
        return "We don't teach, we Educate!!";
    }
}
