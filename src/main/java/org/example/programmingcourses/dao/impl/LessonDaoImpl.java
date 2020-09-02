package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Lesson;
import org.hibernate.Session;

import java.util.List;

public class LessonDaoImpl implements GeneralDao<Lesson> {

    private Session session;

    public LessonDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Lesson lesson) {
        session.save(lesson);
    }

    @Override
    public Lesson findById(Long id) {
        return session.get(Lesson.class, id);
    }

    @Override
    public List<Lesson> findAll() {
        List<Lesson> lessonList = session.createQuery("from Lesson").list();
        return lessonList;
    }

    public List<Lesson> findLessonsByTeacherId(Long teacherId){
        List<Lesson> lessons = session.createQuery("from Lesson L where L.teacher = " + teacherId).list();
        return lessons;
    }

    public List<Lesson> findLessonByGroupId(Long groupId) {
        List<Lesson> lessons =  session.createQuery("from Lesson L where L.group = "+groupId + " order by date asc, time asc").list();
        return lessons;
    }
}
