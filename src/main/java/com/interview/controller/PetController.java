package com.interview.controller;

import com.interview.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("getcount/{status}")
    public long getPetCount(@PathVariable String status) {
        long petCount = petService.getPetCount(status);
        return petCount;


    }

}
