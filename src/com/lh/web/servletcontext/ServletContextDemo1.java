package com.lh.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: ServletContext
 * @Author: LuoH
 * @Date: 2020/01/19
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        一、ServletContext对象获取:
        1. 通过request对象获取
        request.getServletContext();
        2. 通过HttpServlet获取
        this.getServletContext();
         */
        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println("context1:" + context1);
        System.out.println("context2:" + context2);
        System.out.println(context1 == context2);//true
        System.out.println("==========ServletContext对象功能==========");
        /*
        二、ServletContext对象功能
        1. 获取MIME类型：
            * MIME类型:在互联网通信过程中定义的一种文件数据类型
            * 格式： 大类型/小类型 text/html image/jpeg
            * 获取：String getMimeType(String file)
        2. 域对象：共享数据
            1. setAttribute(String name,Object value)
            2. getAttribute(String name)
            3. removeAttribute(String name)
            ServletContext对象范围：所有用户所有请求的数据
        3. 获取文件的真实(服务器)路径
            1. 方法：String getRealPath(String path)
            String b = context.getRealPath("/b.txt");//web目录下资源访问
            System.out.println(b);
            String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
            System.out.println(c);
            String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
            System.out.println(a);
         */
        //功能一：获取MIME类型
        System.out.println("===========功能一：获取MIME类型===========");
        //1.通过HttpServlet对象
        ServletContext context = this.getServletContext();
        //2.定义文件名称
        String filename = "a.jpg";//image/jpeg
        //3.获取MIME类型
        String mime = context.getMimeType(filename);
        System.out.println(mime);

        //功能二 域对象：共享数据
        System.out.println("============功能二 域对象：共享数据============");
        //设置数据 任何一个用户都能获取到 范围较大 生命周期长
        context.setAttribute("msg", "haha");

        //功能三 获取文件的真实(服务器)路径
        System.out.println("============功能三 获取文件的真实(服务器)路径============");
        String realPath = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(realPath);
//        File file = new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下资源访问
        System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
