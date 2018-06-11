package com.smart.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志
 * User: monkey
 * Date: 2018-06-11 15:41
 */
@Getter
@Setter
public class LoginLog implements Serializable {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;
}
