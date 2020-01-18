package com.lh.login.dao;

import com.lh.login.domain.User;
import com.lh.login.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description: 数据库中user表的类
 * @author LuoH
 * @date 2020/01/18
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getdaDataSource());

    /**
     * @Description: 登陆方法
     * @Author: LuoH
     * @Date: 2020/01/18
     * @param: [loginUser]
     */
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
