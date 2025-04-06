package com.example.projetmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class ProjetMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMicroServiceApplication.class, args);
    }


    }



