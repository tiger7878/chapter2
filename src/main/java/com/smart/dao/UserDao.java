package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: monkey
 * Date: 2018-06-11 15:44
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private  final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
            " WHERE user_name =? and password=? ";

    private final static String FIND_USER_BY_USERNAME_SQL=" SELECT user_id,user_name,credits "
            + " FROM t_user WHERE user_name =? ";

    private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    /**
     * 根据用户名和密码查询用户记录数
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public int getMatchCount(String userName,String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[]{userName,password},Integer.class);
    }

    //在方法参数前面加final关键字就是为了防止数据在方法体中被修改
    public User findUserByUserName(final String userName){
        //引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的
        final User user=new User();
        jdbcTemplate.query(FIND_USER_BY_USERNAME_SQL, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{
                user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()
        });
    }

}
