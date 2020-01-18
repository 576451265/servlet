package com.lh.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 获取请求体数据
 * @Author: LuoH
 * @Date: 2020/01/18
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //POST获取请求参数

        //1.根据参数名获取参数值
        String username = request.getParameter("username");

        //2.根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
            response.getWriter().write(hobby);
        }

        //3.获取所有请求的参数名称
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);//只能获取一个
            System.out.println("name:" + name + " value:" + value);
            String[] values = request.getParameterValues(name);
            System.out.println("values:");
            for (String item : values) {
                System.out.println(item);
            }
            System.out.println("-----------------------");
        }

        //4.获取所有参数的map集合
        System.out.println("获取所有参数的map集合");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取健值
            String[] values = parameterMap.get(name);
            System.out.println("name:" + name);
            for (String value : values) {
                System.out.println("value:" + value);
            }
            System.out.println("---------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //GET获取请求参数
        /*
        //根据参数名获取参数值
        String username = request.getParameter("username");
        System.out.println("get:" + " " + username);
         */
        //通用
        this.doPost(request, response);
    }
}
