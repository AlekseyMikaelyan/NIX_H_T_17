package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Course;
import org.hibernate.Session;

import java.util.List;

public class CourseDaoImpl implements GeneralDao<Course> {

    private Session session;

    public CourseDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Course course) {
        session.save(course);
    }

    @Override
    public Course findById(Long id) {
        return session.get(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = session.createQuery("from Course").list();
        return courseList;
    }
}
