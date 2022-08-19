package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        /*Student s = session.selectOne("test1.getById", "1");
        System.out.println(s);
        session.close();*/
       /* List<Student> sList = session.selectList("test1.getAll");
        for (Student s:sList) {
            System.out.println(s);*/
        /*Student student = new Student();
        student.setId("6");
        student.setName("Fullwar");
        student.setAge(30);*/

        /*session.insert("test1.save",student);*/
        /*session.update("test1.update",student);*/
        session.delete("test1.delete","6");
        session.commit();




    }
}
