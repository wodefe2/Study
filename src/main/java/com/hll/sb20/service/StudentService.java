package com.hll.sb20.service;

import com.hll.sb20.dao.StudentDAO;
import com.hll.sb20.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/8/9
 */
@Component
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public Student addStudent(String name, int age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        studentDAO.addStudent(student);
        return student;
    }

    public List<Student> listStudents(int currentPage, int pageSize) {
        List<Student> studentList = studentDAO.listStudent(currentPage, pageSize);
        return studentList;
    }

    public List<Student> findStudents(Student student) {
        return studentDAO.findStudents(student);
    }
}
