package com.interview.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Root{
    private Long id;
    private String name;

    public Root(Long id, String name, ArrayList<String> photoUrls, ArrayList<Tag> tags, String status, Category category) {
        this.id = id;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
        this.category = category;
    }

    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;
    private Category category;
}
