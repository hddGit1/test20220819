package com.bjpowernode.servlet;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bbb")
public class BmiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");

        float h = Float.valueOf(height);
        float w = Float.valueOf(weight);
        float bmi = w / (h * h);

        String msg ;
        if (bmi <= 18.5){
            msg = "您身体比较瘦";
        }else if (bmi > 18.5 && bmi <=24){
            msg = "您身体是正常的";
        }else if (bmi > 24 && bmi <=27){
            msg = "您身体比较胖";
        }else {
            msg = "您身体肥胖了";}

        msg = "您好，"+ name +"先生/女士，您的bmi值是:"+ bmi +","+ msg;

       response.setContentType("text/html;charset=UTF-8");
       response.getWriter().print(msg);
        response.getWriter().flush();
        response.getWriter().close();
     }

}
