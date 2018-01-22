package com.godlikehzj.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applicaiton {
    public static void main(String[] args) {
        SpringApplication.run(Applicaiton.class, args);
        try {
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
