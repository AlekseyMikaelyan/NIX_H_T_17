package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Teacher;
import org.hibernate.Session;

import java.util.List;

public class TeacherDaoImpl implements GeneralDao<Teacher> {

    private Session session;

    public TeacherDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Teacher teacher) {
        session.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return session.get(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teacherList =  session.createQuery("from Teacher").list();
        return teacherList;
    }
}
