package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;
import com.bjpowernode.entity.Student2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student student);
    public int deleteStudent(String name);
    public int updateStudent(@Param("myname") String name,@Param("myage") Integer age);
    public List<Student> selectMultiStudents(@Param("myname") String name,@Param("myage") Integer age);
    public List<Student> selectMultiObject(Student student);
    public List<Student2> selectStudent2s();
    public List<Student> selectStudentLike(String name);
    public List<Student> selectStudentFor(List<Student> list);
    public List<Map<String,Object>>  selectStudentAndClass();
}
