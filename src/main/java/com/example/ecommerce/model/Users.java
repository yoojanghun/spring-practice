package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Users {
    @Id
    private int id;

    private String username;
    private String password;

}
