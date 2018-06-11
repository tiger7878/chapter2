package com.smart.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * User: monkey
 * Date: 2018-06-11 15:28
 */
@Getter
@Setter
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private int credits;//积分
    private String lastIp;//最后一次登录ip
    private Date lastVisit;//最后一次登录时间
}
