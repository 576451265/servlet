package com.lh.login.test;

import com.lh.login.dao.UserDao;
import com.lh.login.domain.User;
import org.junit.Test;

/**
 * @Description:
 * @author LuoH
 * @date 2020/01/18
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("123");
        
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
