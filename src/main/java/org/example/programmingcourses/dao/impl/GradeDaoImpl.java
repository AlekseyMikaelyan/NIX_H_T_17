package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Grade;
import org.hibernate.Session;

import java.util.List;

public class GradeDaoImpl implements GeneralDao<Grade> {

    private Session session;

    public GradeDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Grade grade) {
        session.save(grade);
    }

    @Override
    public Grade findById(Long id) {
        return session.get(Grade.class, id);
    }

    @Override
    public List<Grade> findAll() {
        List<Grade> gradeList = session.createQuery("from Grade").list();
        return gradeList;
    }

    public Grade getGradeByStudentAndLessonId(Long lessonId, Long studentId){
        List<Grade> grades = session.createQuery("from Grade G where G.lesson = " + lessonId + " and G.student = " + studentId).list();
        if(grades.isEmpty()) {
            return null;
        }
        return grades.get(0);
    }
}
