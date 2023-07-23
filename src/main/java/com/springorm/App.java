package com.springorm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/config/config.xml");

        StudentDao studentDao = context.getBean("std", StudentDao.class);

        Student student = context.getBean("st", Student.class);

        //call insert method
        int r = studentDao.insert(student);

        //call single object select query
        Student st = studentDao.getStudent(543);

        System.out.println("Selected: " + st);

        //call multiple object query
        List<Student> list = studentDao.getStudents();

        System.out.println("Selected : " + list);

        //call delete query
        studentDao.delete(5234);

        System.out.println("Deleted...!");

        Student stt = new Student(5447, "Sourav", "Kolkata");

        studentDao.updateStudent(stt);
    }
}
