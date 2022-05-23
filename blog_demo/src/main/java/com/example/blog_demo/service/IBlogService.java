package com.example.blog_demo.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog_demo.domain.Blog;

import java.awt.print.Book;

public interface IBlogService extends IService<Blog> {

    boolean saveBlog(Blog blog);

    boolean modify(Blog blog);

    boolean delete(Integer id);

    IPage<Blog> getPage(int currentPage, int pageSize);

    IPage<Blog> getPage(int currentPage, int pageSize, Blog blog);
}
