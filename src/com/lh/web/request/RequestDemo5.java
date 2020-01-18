package com.lh.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 中文乱码问题
 * @Author: LuoH
 * @Date: 2020/01/18
 */
@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    /*
     * 中文乱码问题：
     * get方式：tomcat 8 已经将get方式乱码问题解决了
     * post方式：会乱码
     * 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置溜的编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数username
        String username = request.getParameter("username");
        System.out.println(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
