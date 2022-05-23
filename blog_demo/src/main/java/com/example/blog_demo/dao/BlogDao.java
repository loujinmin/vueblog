package com.example.blog_demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog_demo.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.awt.print.Book;

@Mapper
public interface BlogDao extends BaseMapper<Blog> {

}
