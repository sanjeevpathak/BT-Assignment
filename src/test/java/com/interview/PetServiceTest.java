package com.interview;


import com.interview.DTO.Category;
import com.interview.DTO.Root;
import com.interview.DTO.Tag;
import com.interview.service.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    PetService petService;



    @Test
    public void testgetPetCount() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://petstore.swagger.io/v2/pet");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(new Tag());
        Category category = new Category();

        List<Root> mockRootResponse = Arrays.asList(
                new Root(1L, "TestName", photoUrls, tags, "active", category),
                new Root(2L, "TestName", photoUrls, tags, "active", category)
        );

        ResponseEntity<List<Root>> mockResponse = ResponseEntity.ok(mockRootResponse);

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                isNull(),
                any(ParameterizedTypeReference.class)))
                .thenReturn(mockResponse);
        long count = petService.getPetCount("available");
        assertEquals(2, count);
    }


}
