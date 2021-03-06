package com.newcoder.community;

import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);
    }
    @Test
    public void testSelectName(){
        User user=userMapper.selectByName("liubei");
        System.out.println(user);
    }
    @Test
    public void testSelectEmail(){
        User user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setSalt("123");
        user.setEmail("test@sina.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/101.png");
        user.setCreateTime(new Date());
        int rows=userMapper.insertUser(user);

        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdataUser(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"http://images.nowcoder.com/head/1001.png");
        System.out.println(rows);
        rows=userMapper.updatePassword(150,"123456");
        System.out.println(rows);
    }
    @Test
    public  void testSelectPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost post:list){
            System.out.println(post);
        }
        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
