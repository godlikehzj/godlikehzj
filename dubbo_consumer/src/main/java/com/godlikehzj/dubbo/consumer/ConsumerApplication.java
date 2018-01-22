package com.godlikehzj.dubbo.consumer;

import com.godlikehzj.api.DemoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConsumerApplication{


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConsumerApplication.class, args);
        DemoService demoService = (DemoService) run.getBean("demoService");

        try {
            while (true){
                Thread.sleep(1000);
                System.out.println(demoService.dubboTest());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
