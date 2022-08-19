package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.ImplStudentDao;
import com.bjpowernode.entity.Student;
import org.junit.Test;

import java.util.List;

public class DaoTest {
    @Test
    public void selectStudentDaoTest(){
        StudentDao implStudentDao = new ImplStudentDao();
        List<Student> students = implStudentDao.selectStudents();
        for (Student stu: students) {
            System.out.println(stu);
        }
    }

    @Test
    public void insertStudentDaoTest(){
        StudentDao implStudentDao = new ImplStudentDao();
        Student stu = new Student(8, "周中", 26);
        int i = implStudentDao.insertStudent(stu);
        System.out.println("导入的数据条数："+ i +"条");
    }
}
