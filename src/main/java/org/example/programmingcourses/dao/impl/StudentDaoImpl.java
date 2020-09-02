package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDaoImpl implements GeneralDao<Student> {

    private Session session;

    public StudentDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Student student) {
        session.save(student);
    }

    @Override
    public Student findById(Long id) {
        return session.get(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = session.createQuery("from Student").list();
        return studentList;
    }

    public List<Student> findStudentsByGroupId(Long id){
        List<Student> students = session.createQuery("from Student S where S.group = " + id).list();
        return students;
    }
}
