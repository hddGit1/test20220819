package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student student);
}
