package com.springorm.dao;

import com.springorm.entities.Student;
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
}
