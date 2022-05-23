package com.example.blog_demo.service;

import com.example.blog_demo.domain.Blog;

import java.util.List;

public interface BlogService {
    Boolean save(Blog blog);
    Boolean update(Blog blog);
    Boolean delete(Integer id);
    Blog getById(Integer id);
    List<Blog> getAll();
}
