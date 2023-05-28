package com.yang.shardingjdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.shardingjdbc.entity.Course;
import com.yang.shardingjdbc.entity.Udict;
import com.yang.shardingjdbc.entity.User;
import com.yang.shardingjdbc.mapper.CourseMapper;
import com.yang.shardingjdbc.mapper.UdictMapper;
import com.yang.shardingjdbc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;


@SpringBootTest
class ShardingjdbcApplicationTests {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UdictMapper udictMapper;
    //=======================测试公共表udict===================================
    //删除
    @Test
    void deleDict() {
        QueryWrapper<Udict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","lisizzz");
        udictMapper.delete(queryWrapper);
    }
    //查询
    @Test
    void selectDict() {
        QueryWrapper<Udict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","lisizzz");
        List<Udict> udicts = udictMapper.selectList(queryWrapper);
        udicts.forEach(System.out::println);
    }
    //添加
    @Test
    void addUdict() {
        Udict udict = new Udict();
        udict.setUsername("lisizzz");
        udict.setUstatus("已启用");
        udictMapper.insert(udict);
    }

    //=======================测试专表专库===================================
    //查询user
    @Test
    void selectUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("user_id",869233019720826881L);
        List<User> courses = userMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }
    //添加user
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("lucy");
        user.setUstatus("cc");
        userMapper.insert(user);
    }

    //=======================测试水平分库===================================

    //查询course
    @Test
    void selectCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("user_id",100);
        queryWrapper.ge("cid",869225298145574913L);
        List<Course> courses = courseMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }

    //添加course
    @Test
    void addCourse() {
        Course course = new Course();
        course.setCname("java");
        course.setCid(869225427644710914L);
        course.setUserId(106L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

    //=======================测试水平分表===================================
    //查询课程
    @Test
    void findCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("cid",869211959097032704L);
        List<Course> courses = courseMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }

    //插入课程
    @Test
    void contextLoads() {
        Course course = new Course();
        for (int i = 0; i < 10; i++) {
            course.setCname("java"+i);
            course.setUserId(100L);
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
    }

}
