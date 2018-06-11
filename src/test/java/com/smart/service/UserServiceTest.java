package com.smart.service;

import java.util.Date;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.smart.domain.User;
import static org.testng.Assert.*;

/**
 * User: monkey
 * Date: 2018-06-11 19:24
 */
@ContextConfiguration("classpath*:/smart-context.xml")//启动spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","111111");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals("admin",user.getUserName());
    }

    //使测试数据不对数据库造成污染，在使用Spring-test进行的单元测试的时候，默认会对事务进行回滚，即@Rollback 默认是true，
    // 如果想要测试数据不回滚，可设置@Rollback(value = false)
    @Test
    @Rollback(value = false)
    public void testAddLoginLog(){
        User user = userService.findUserByUserName("admin");
        user.setCredits(10);
        user.setLastIp("192.168.1.10");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }

}
