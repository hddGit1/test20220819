package com.bjpowernode;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //1.定义mybatis主配置文件,读取主配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2.创建SqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        //3.创建SqlSessionFactory对象
        SqlSessionFactory factory = bulider.build(in);
        //4.从SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5.执行sql语句，返回实体类对象的集合
        List<Student> studentList = sqlSession.selectList("com.bjpowernode.dao.StudentDao.selectStudents");
        //6.foreach遍历集合，输出结果
        for (Student stu:studentList) {
            System.out.println(stu); }
        //7.关闭SqlSession对象
        sqlSession.close();
    }
}
