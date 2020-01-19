package com.lh.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 重定向
 * @author LuoH
 * @date 2020/01/19
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    /*
    * 重定向的特点:redirect
     1. 地址栏发生变化
     2. 重定向可以访问其他站点(服务器)的资源
     3. 重定向是两次请求。不能使用request对象来共享数据
     * 转发的特点：forward
     1. 转发地址栏路径不变
     2. 转发只能访问当前服务器下的资源ServletContext对象：
     3. 转发是一次请求，可以使用request对象来共享数据
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //访问/responseDemo1 自动跳转到/responseDemo2资源
        System.out.println("demo1....");
        /*
        //1.设置状态码为302
        resp.setStatus(302);
        //2.设置响应头location
        resp.setHeader("location","/servletDemo/responseDemo2");
        */
        //重定向request不能用来共享数据
        req.setAttribute("msg", "11111");

        //动态获取虚拟目录
        String contextPath = req.getContextPath();

        //简单的重定向方法 需要加虚拟目录
//        resp.sendRedirect("/servletDemo/responseDemo2");
//        resp.sendRedirect("http://www.baidu.com");
        resp.sendRedirect(contextPath + "/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
