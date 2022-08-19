package com.bjpowernode.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/save.do","/delete.do","/uadate.do","/select.do"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/save.do".equals(servletPath)){
            save(request,response);
        }else if("/delete.do".equals(servletPath)){
           delete(request,response);
        }else if("/uadate.do".equals(servletPath)){
            update(request,response);
        }else if("/select.do".equals(servletPath)){
            select(request,response);
        }
    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("查询方法执行成功！");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("修改方法执行成功！");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("删除方法执行成功！");
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加方法执行成功！");
    }

}
