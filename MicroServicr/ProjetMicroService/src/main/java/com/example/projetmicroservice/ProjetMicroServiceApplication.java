package com.example.projetmicroservice;

import com.example.projetmicroservice.entities.Candidat;
import com.example.projetmicroservice.repository.CandidatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMicroServiceApplication.class, args);
    }
    @Autowired
    private CandidatRepo candidatRepo;

    @Bean
    ApplicationRunner init() {
        return args -> {

            //ADD
            candidatRepo.save(new Candidat(1 ,"Ramez", "Zorgui", "Ramez@esprit.tn"));
            candidatRepo.save(new Candidat(2 ,"Halim", "Trabelsi", "Halim@esprit.tn"));
            candidatRepo.save(new Candidat(3,"Mighri" , "Yassine", "Yassine@esprit.tn"));
            candidatRepo.save(new Candidat(4,"Mariem" , "Ch", "ma@esprit.tn"));

            //FETCH
            candidatRepo.findAll().forEach(System.out::println);


        };


    }

}

