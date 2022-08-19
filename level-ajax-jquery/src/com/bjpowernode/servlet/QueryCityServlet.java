package com.bjpowernode.servlet;

import com.alibaba.fastjson.JSON;
import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/queryCity")
public class QueryCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsonString = "";
        String strProvinceId = request.getParameter("proid");
        if (strProvinceId != null && !"".equals(strProvinceId.trim())) {
            QueryDao dao = new QueryDao();
            List<City> cityList = dao.queryCityList(Integer.valueOf(strProvinceId));
            jsonString = JSON.toJSONString(cityList);

        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush();
        out.close();
    }


}
