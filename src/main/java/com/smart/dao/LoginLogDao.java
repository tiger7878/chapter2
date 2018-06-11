package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * User: monkey
 * Date: 2018-06-11 18:44
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //保存登录日志的sql
    private final static String INSERT_LOGIN_LOG_SQL="INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";

    public void insertLoginLog(LoginLog loginLog){
        Object[] args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,args);
    }
}
