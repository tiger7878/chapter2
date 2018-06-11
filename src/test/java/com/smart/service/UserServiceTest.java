package com.smart.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.testng.Assert.*;

/**
 * User: monkey
 * Date: 2018-06-11 19:24
 */
@ContextConfiguration("classpath*:/spring-context.xml")//启动spring容器
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","111111");
        assertTrue(b1);
        assertTrue(!b2);
    }

}
