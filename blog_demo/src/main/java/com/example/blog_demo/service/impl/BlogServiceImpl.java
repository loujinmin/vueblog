package com.example.blog_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog_demo.dao.BlogDao;
import com.example.blog_demo.domain.Blog;
import com.example.blog_demo.service.IBlogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogDao, Blog> implements IBlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public boolean saveBlog(Blog blog) {
        return blogDao.insert(blog) > 0;
    }

    @Override
    public boolean modify(Blog blog) {
        return blogDao.updateById(blog) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return blogDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Blog> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        blogDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Blog> getPage(int currentPage, int pageSize, Blog blog) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>();
        lqw.like(Strings.isNotEmpty(blog.getTitle()),Blog::getTitle,blog.getTitle());
        lqw.like(Strings.isNotEmpty(blog.getDescription()),Blog::getDescription,blog.getDescription());
        lqw.like(Strings.isNotEmpty(blog.getContent()),Blog::getContent,blog.getContent());

        IPage page = new Page(currentPage,pageSize);
        blogDao.selectPage(page,lqw);
        return page;
    }
}
