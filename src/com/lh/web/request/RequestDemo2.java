package com.lh.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
/**
  * @Description: 获取请求头数据
  * @Author: LuoH
  * @Date: 2020/01/18
  */
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }

        //3获取请求头数据：user-agent
        System.out.println("获取请求头数据：user-agent");
        String agent = request.getHeader("user-agent");
        //判断agant的浏览器版本
        if (agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌");
        }else if (agent.contains("Firefox")){
            //火狐
            System.out.println("火狐来了");
        }

        //4.获取请求头的数据：referer 告诉服务器我从哪里来
        //应该从一个超链接过来
        // http://localhost:8080/servletDemo/login.html
        System.out.println("获取请求头的数据：referer");
        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if (referer != null){
            if (referer.contains("/servletDemo")){
                //正常访问
                System.out.println("放电影");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("放电影");
            }else {
                //倒链
                System.out.println("想看吗？来正经官网呀！");
            }
        }
    }
}
