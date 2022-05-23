package com.example.blog_demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.blog_demo.controller.utils.R;
import com.example.blog_demo.domain.Blog;
import com.example.blog_demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public R getAll(){
        return new R(true,blogService.list());
    }

    @PostMapping
    public R save(@RequestBody Blog blog){

        return new R(blogService.save(blog));
    }

    @PutMapping
    public R update(@RequestBody Blog blog){
        return new R(blogService.modify(blog));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(blogService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,blogService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Blog blog){


        IPage<Blog> page = blogService.getPage(currentPage,pageSize, blog);
        if(currentPage > page.getPages()){
            page = blogService.getPage((int)page.getPages(),pageSize, blog);
        }

        return new R(true,page);
    }


}
