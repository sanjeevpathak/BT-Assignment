package com.interview.service;

import com.interview.DTO.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class PetService {


    @Autowired
    RestTemplate restTemplate;

    public long getPetCount(String status) {
        String url = "https://petstore.swagger.io/v2/pet/findByStatus";

        String finalUrl = UriComponentsBuilder.fromHttpUrl(url).queryParam("status", status).toUriString();
        ResponseEntity<List<Root>> response = restTemplate.exchange(
                finalUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Root>>() {
                }
        );
        return response.getBody().stream().count();

    }


}
