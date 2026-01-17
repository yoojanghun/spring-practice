package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);

        Dev obj = context.getBean(Dev.class);

        obj.build();
    }

}

// 내가 직접 new 를 사용하여 객체를 만들지 않음.
// @Component로 어떤 class를 관리해야할 지 spring에게 말하면 spring이 객체 자동 생성