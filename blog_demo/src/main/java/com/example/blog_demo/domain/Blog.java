package com.example.blog_demo.domain;

import lombok.Data;

@Data
public class Blog {
    private Integer id;
    private String title;
    private String description;
    private String content;
}
