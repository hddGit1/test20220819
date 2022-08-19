package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ImplStudentDao implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Student> studentList = sqlSession.selectList("com.bjpowernode.dao.StudentDao.selectStudents");
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int insert = sqlSession.insert("com.bjpowernode.dao.StudentDao.insertStudent", student);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }
}
