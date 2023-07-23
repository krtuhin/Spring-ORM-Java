package com.springorm.dao;

import com.springorm.entities.Student;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //insert method
    @Transactional      //for enable transaction
    public int insert(Student student) {

        int r = (int) this.hibernateTemplate.save(student);

        return r;
    }

    //select single object
    public Student getStudent(int id) {

        Student st = this.hibernateTemplate.get(Student.class, id);

        return st;
    }

    //select multiple object
    public List<Student> getStudents() {

        List<Student> students = this.hibernateTemplate.loadAll(Student.class);

        return students;
    }

    //delete method
    @Transactional
    public void delete(int id) {

        Student student = this.hibernateTemplate.get(Student.class, id);

        this.hibernateTemplate.delete(student);
    }

    //update method
    @Transactional
    public void updateStudent(Student student) {

        //any of these two method
        this.hibernateTemplate.saveOrUpdate(student);

        //this.hibernateTemplate.update(student);
    }
}
