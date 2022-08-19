package com.bjpowernode;

import com.bjpowernode.entity.Student;
import com.bjpowernode.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Student> studentList = sqlSession.selectList("com.bjpowernode.dao.StudentDao.selectStudents");
        for (Student stu:studentList) {
            System.out.println(stu); }
        sqlSession.close();
    }
}
