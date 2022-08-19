package com.bjpowernode.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/queryProvince")
public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QueryDao dao = new QueryDao();
        String jsonString ="";
        List<Province> provinces = dao.queryProvinceList();
        if (provinces != null) {
            jsonString = JSON.toJSONString(provinces);

        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush();
        out.close();
    }
}
