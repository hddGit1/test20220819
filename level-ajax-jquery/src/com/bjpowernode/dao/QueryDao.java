package com.bjpowernode.dao;

import com.bjpowernode.entity.City;
import com.bjpowernode.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private String sql = null;
    private String url = "jdbc:mysql://localhost:3306/bjpowernode";
    private String username = "root";
    private String password = "root";


    public List<Province> queryProvinceList(){

        List<Province> provinces = new ArrayList<>();
        Province p = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            sql = "select id,name,jiancheng,shenghui from province order by id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
                provinces.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(provinces);
        return provinces;
    }

    public List<City> queryCityList(Integer prvinceId){

        List<City> cities = new ArrayList<>();
        City c = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            sql = "select id,name from city where provinceid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,prvinceId);
            rs = pst.executeQuery();
            while(rs.next()){
               c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                cities.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return cities;
    }
}
