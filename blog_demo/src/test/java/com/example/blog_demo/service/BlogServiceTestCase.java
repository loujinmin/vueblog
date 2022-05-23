package com.example.blog_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogServiceTestCase {

    @Autowired
    private IBlogService blogService;

    @Test
    void testGetById(){
        System.out.println(blogService.getById(1));
    }

    @Test
    void testGetPage(){
        System.out.println(blogService.getPage(1,1));
        System.out.println(blogService.getPage(1,1).getTotal());
    }
}
