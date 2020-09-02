package org.example.programmingcourses.main;

import org.example.programmingcourses.dao.impl.*;
import org.example.programmingcourses.entity.*;
import org.example.programmingcourses.service.TheMostSuccessfulGroupService;
import org.example.programmingcourses.service.TheNearestLessonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            CourseDaoImpl courseDao = new CourseDaoImpl(session);
            GradeDaoImpl gradeDao = new GradeDaoImpl(session);
            GroupDaoImpl groupDao = new GroupDaoImpl(session);
            LessonDaoImpl lessonDao = new LessonDaoImpl(session);
            StudentDaoImpl studentDao = new StudentDaoImpl(session);
            TeacherDaoImpl teacherDao = new TeacherDaoImpl(session);
            TopicDaoImpl topicDao = new TopicDaoImpl(session);

            LocalDate date = LocalDate.of(2020,9,1);
            LocalTime time = LocalTime.of(13,0);

            Topic topic = new Topic("Hibernate");
            Teacher teacher = new Teacher("Michael", "Voidaspect");
            Course course = new Course("Java");
            Group group = new Group("17a", course, teacher);
            Student student = new Student("Alex", "Mikaelyan", group);
            Lesson lesson = new Lesson("test", date, time, topic, group, teacher);
            Grade grade = new Grade(5, student, lesson);

            topicDao.create(topic);
            teacherDao.create(teacher);
            courseDao.create(course);
            groupDao.create(group);
            studentDao.create(student);
            lessonDao.create(lesson);
            gradeDao.create(grade);

            TheNearestLessonService nearestLessonService = new TheNearestLessonService(lessonDao, studentDao);
            nearestLessonService.lessonInit();

            TheMostSuccessfulGroupService mostSuccessfulGroupService = new TheMostSuccessfulGroupService(studentDao, lessonDao, gradeDao, teacherDao);
            mostSuccessfulGroupService.GroupInit();
        }
    }
}
