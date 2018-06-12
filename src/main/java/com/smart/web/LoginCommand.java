package com.smart.web;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于登录的类
 * User: monkey
 * Date: 2018-06-12 9:21
 */
@Getter
@Setter
public class LoginCommand {
    private String userName;

    private String password;
}
