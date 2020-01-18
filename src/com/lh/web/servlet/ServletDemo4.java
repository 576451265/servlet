package com.lh.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Description: servlet路径配置
 * @author LuoH
 * @date 2020/01/17
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet({"/user/demo4"})
//@WebServlet({"/user/*"})
//@WebServlet({"/*"})//别的都访问不到了才访问他 优先级低
@WebServlet({"*.do"})//不能加斜杠
public class ServletDemo4 extends HttpServlet {
    /*
    urlpartten:Servlet访问路径
			1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
			2. 路径定义规则：
				1. /xxx：路径匹配
				2. /xxx/xxx:多层路径，目录结构
				3. *.do：扩展名匹配
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");
    }


}
