package com.example.blog_demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog_demo.domain.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogDaoTestCase {

    @Autowired
    private BlogDao blogDao;

    @Test
    void testGetById(){
        System.out.println(blogDao.selectById(1));
    }

    @Test
    void testSave(){
        Blog blog = new Blog();
        blog.setTitle("最值得学习的博客项目eblog");
        blog.setDescription("eblog是一个基于Springboot2.1.2开发的博客学习项目，为了让项目融合更多的知识点，达到学习目的，编写了详细的从0到1开发文档。主要学习包括：自定义Freemarker标签，使用shiro+redis完成了会话共享，redis的zset结构完成本周热议排行榜，t-io+websocket完成即时消息通知和群聊，rabbitmq+elasticsearch完成博客内容搜索引擎等。值得学习的地方很多！");
        blog.setContent("**推荐阅读：**\n" +
                "\n" +
                "[分享一套SpringBoot开发博客系统源码，以及完整开发文档！速度保存！](https://mp.weixin.qq.com/s/jz6e977xP-OyaAKNjNca8w)\n" +
                "\n" +
                "[Github上最值得学习的100个Java开源项目，涵盖各种技术栈！](https://mp.weixin.qq.com/s/N-U0TaEUXnBFfBsmt_OESQ)\n" +
                "\n" +
                "[2020年最新的常问企业面试题大全以及答案](https://mp.weixin.qq.com/s/lR5LC5GnD2Gs59ecV5R0XA)");
        blogDao.insert(blog);
    }

    @Test
    void testUpdate(){

    }

    @Test
    void testDelete(){

    }

    @Test
    void testGetAll(){

    }

    @Test
    void testGetPage(){
        IPage page = new Page(1,1);
        blogDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
        String title = "1";
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<>();
        lqw.like(title!=null,Blog::getTitle,title);
        blogDao.selectList(lqw);

    }

}
