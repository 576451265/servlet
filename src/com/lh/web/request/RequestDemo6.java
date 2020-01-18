package com.lh.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 请求转发问题
 * @Author: LuoH
 * @Date: 2020/01/18
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    /*
        请求转发：一种在服务器内部的资源跳转方式
        1. 步骤：
            1. 通过request对象获取请求转发器对象：RequestDispatcher
            getRequestDispatcher(String path)
            2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request,
            ServletResponse response)
        2. 特点：
            1. 浏览器地址栏路径不发生变化
            2. 只能转发到当前服务器内部资源中
            3. 转发是一次请求
         */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("66666被访问");
        //转发到RequestDemo7
        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestDemo7");
        requestDispatcher.forward(request, response);
         */

        //存贮数据到request域中
        request.setAttribute("msg","hello好");

        //不能转发到服务器外部eg：wwww.baidu.com
        request.getRequestDispatcher("/RequestDemo7").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
