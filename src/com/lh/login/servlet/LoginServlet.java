package com.lh.login.servlet;

import com.lh.login.dao.UserDao;
import com.lh.login.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description:
 * @author LuoH
 * @date 2020/01/18
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        /*法一
        //2.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
         */
        /*
        法二 beanUtils
            BeanUtils工具类，简化数据封装
            * 用于封装JavaBean的
            1. JavaBean：标准的Java类
                1. 要求：
                    1. 类必须被public修饰
                    2. 必须提供空参的构造器
                    3. 成员变量必须使用private修饰
                    4. 提供公共setter和getter方法
                2. 功能：封装数据
            2. 概念：
                成员变量：
                属性：setter和getter方法截取后的产物
                例如：getUsername() --> Username--> username
            3. 方法：
                1. setProperty()
                2. getProperty()
                3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
         */
        //2.获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        //3.创建User对象
        User loginUser = new User();
        //3.2 使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用UserDao的logn方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //5.判断user
        if (user == null) {
            //登陆失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        } else {
            //登陆成功
            //存储数据
            req.setAttribute("user", user);
            //转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
