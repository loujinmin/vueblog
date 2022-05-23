package com.example.blog_demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.blog_demo.domain.Blog;
import com.example.blog_demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/blogs")
public class BlogController2 {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public List<Blog> getAll(){
        return blogService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    @PutMapping
    public Boolean update(@RequestBody Blog blog){
        return blogService.modify(blog);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return blogService.delete(id);
    }

    @GetMapping("{id}")
    public Blog getById(@PathVariable Integer id){
        return blogService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Blog> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return blogService.getPage(currentPage,pageSize);
    }


}
