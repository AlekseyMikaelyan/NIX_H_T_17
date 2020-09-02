package org.example.programmingcourses.service;

import org.apache.log4j.Logger;
import org.example.programmingcourses.dao.impl.LessonDaoImpl;
import org.example.programmingcourses.dao.impl.StudentDaoImpl;
import org.example.programmingcourses.entity.Group;
import org.example.programmingcourses.entity.Lesson;
import org.example.programmingcourses.entity.Student;

import java.util.List;

public class TheNearestLessonService {

    private final static Logger log = Logger.getLogger(TheNearestLessonService.class);

    private final LessonDaoImpl lessonDao;
    private final StudentDaoImpl studentDao;

    public TheNearestLessonService(LessonDaoImpl lessonDao, StudentDaoImpl studentDao) {
        this.lessonDao = lessonDao;
        this.studentDao = studentDao;
    }

    public void lessonInit() {
        long studentId = 1;
        Lesson lesson = this.getClosesStudentLesson(studentId);
        if(lesson == null) {
            log.info("Student does not have a Lesson");
        } else {
            log.info("lesson = " + lesson.getName());
            log.info("Date = " + lesson.getDate());
            log.info("Time = " + lesson.getTime());
            log.info("Teacher = " + lesson.getTeacher().getLastName());
            log.info("Topic = " + lesson.getTopic().getName());
        }
    }

    public Lesson getClosesStudentLesson(Long studentId) {
        Student student = this.studentDao.findById(studentId);
        Group group = student.getGroup();
        List<Lesson> lessons = this.lessonDao.findLessonByGroupId(group.getId());
        if (lessons.isEmpty()) {
            return null;
        }
        return lessons.get(0);
    }
}
