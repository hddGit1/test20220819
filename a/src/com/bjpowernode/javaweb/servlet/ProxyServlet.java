package com.bjpowernode.javaweb.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "http://localhost:8081/b/target";
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
        System.out.println("调用URL: " + httpGet.getURI());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 执行请求并获取返回
        HttpResponse resp = httpClient.execute(httpGet);
        HttpEntity entity = resp.getEntity();
        System.out.println("返回状态码：" + resp.getStatusLine());

        // 显示结果
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
        String line = null;
        StringBuffer responseSB = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            responseSB.append(line);
        }
        System.out.println("返回消息：" + responseSB);
        reader.close();

        httpClient.close();
        String s = responseSB.toString();
        Object parse = JSON.parse(s);
        response.getWriter().print(parse);
    }
}
