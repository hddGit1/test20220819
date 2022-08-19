package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.entity.Student2;
import com.bjpowernode.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DaoTest {
    @Test
    public void selectStudentDaoTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }


    @Test
    public void insertStudentDaoTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student(9, "李苏阳", 27);
        int i = dao.insertStudent(stu);
        sqlSession.commit();
        System.out.println("导入的数据条数：" + i + "条");
    }

    @Test
    public void selectMultiParam() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectMultiStudents("李四", 20);
        for (Student stu : studentList) {
            System.out.println(stu);
        }
    }

    @Test
    public void selectMultiObject() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student(null, "李四", 20);
        List<Student> studentList = dao.selectMultiObject(stu);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void deleteStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.deleteStudent("李苏阳");
        System.out.println("成功删除" + i + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.updateStudent("张三", 40);
        System.out.println("成功修改" + i + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student2> student2s = dao.selectStudent2s();
        for (Student2 stu : student2s) {
            System.out.println(stu);
        }
    }

    @Test
    public void selectStudentLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String a = "%周%";
        List<Student> students = dao.selectStudentLike(a);
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void WW() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        ArrayList<Student> stus = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);
        stus.add(s1);

        s1 = new Student();
        s1.setId(2);
        stus.add(s1);
        List<Student> studentList = dao.selectStudentFor(stus);
        System.out.println(studentList);

    }

    @Test
    public void duoBiaoLianCha() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Map<String, Object>> mapList = dao.selectStudentAndClass();
        for (Map<String, Object> map : mapList){
            /*Set<String> sets = map.keySet();
            for (Object key : sets) {
                System.out.println("key:" + key + "," + "value:" + map.get(key));*/

        }
       /* System.out.println(mapList);*/
    }
}