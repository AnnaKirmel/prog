package org.example;

import org.example.Controllers.ControllerWeapon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example", "org.example.Controllers"})
public class Start {
    public static void main(String[] args){
        SpringApplication.run(Start.class, args);

    }
}