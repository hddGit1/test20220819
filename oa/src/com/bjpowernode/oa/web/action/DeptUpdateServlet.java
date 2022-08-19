package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
           conn = DBUtil.getConnection();
           String sql = "update dept set dname = ?, loc = ? where deptno = ?";
           ps = conn.prepareStatement(sql);
           ps.setString(1,dname);
           ps.setString(2,loc);
           ps.setString(3,deptno);
           count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }

        if (count == 1){
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            response.sendRedirect(request.getContextPath()+"/error.html");

        }
    }
}
