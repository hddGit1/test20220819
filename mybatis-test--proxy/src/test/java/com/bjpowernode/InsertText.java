package com.bjpowernode;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InsertText {
    @Test
    public void insertText() throws IOException {
        //1.定义mybatis主配置文件,读取主配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2.创建SqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        //3.创建SqlSessionFactory对象
        SqlSessionFactory factory = bulider.build(in);
        //4.从SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5.执行sql语句
        Student student = new Student(6,"王大",32);
        int insert = sqlSession.insert("com.bjpowernode.dao.StudentDao.insertStudent", student);
        //6.输出结果
        sqlSession.commit();
        System.out.println("成功插入"+insert+"行数据");
        //7.关闭SqlSession对象
        sqlSession.close();


    }
}
