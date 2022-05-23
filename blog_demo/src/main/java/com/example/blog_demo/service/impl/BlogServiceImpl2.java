package com.example.blog_demo.service.impl;

import com.example.blog_demo.dao.BlogDao;
import com.example.blog_demo.domain.Blog;
import com.example.blog_demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl2 implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Boolean save(Blog blog) {

        return blogDao.insert(blog) > 0;
    }

    @Override
    public Boolean update(Blog blog) {
        return blogDao.updateById(blog) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return blogDao.deleteById(id) > 0;
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.selectById(id);
    }

    @Override
    public List<Blog> getAll() {
        return blogDao.selectList(null);
    }
}
