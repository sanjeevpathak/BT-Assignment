package com.interview;

import com.interview.service.PetService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewApplication {
    @Autowired
    PetService petService;

    public static void main(String[] args) {

        SpringApplication.run(InterviewApplication.class, args);
    }


}
