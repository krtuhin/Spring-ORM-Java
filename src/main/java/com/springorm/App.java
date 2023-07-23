package com.springorm;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/config/config.xml");

        StudentDao studentDao = context.getBean("std", StudentDao.class);

        Student student = context.getBean("st", Student.class);

        int r = studentDao.insert(student);
    }
}
