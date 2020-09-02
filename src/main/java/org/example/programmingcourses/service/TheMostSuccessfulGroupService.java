package org.example.programmingcourses.service;

import org.apache.log4j.Logger;
import org.example.programmingcourses.dao.impl.GradeDaoImpl;
import org.example.programmingcourses.dao.impl.LessonDaoImpl;
import org.example.programmingcourses.dao.impl.StudentDaoImpl;
import org.example.programmingcourses.dao.impl.TeacherDaoImpl;
import org.example.programmingcourses.entity.Grade;
import org.example.programmingcourses.entity.Group;
import org.example.programmingcourses.entity.Lesson;
import org.example.programmingcourses.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheMostSuccessfulGroupService {

    private final static Logger log = Logger.getLogger(TheMostSuccessfulGroupService.class);

    private final StudentDaoImpl studentDao;
    private final LessonDaoImpl lessonDao;
    private final GradeDaoImpl gradeDao;
    private final TeacherDaoImpl teacherDao;

    public TheMostSuccessfulGroupService(StudentDaoImpl studentDao, LessonDaoImpl lessonDao, GradeDaoImpl gradeDao, TeacherDaoImpl teacherDao) {
        this.studentDao = studentDao;
        this.lessonDao = lessonDao;
        this.gradeDao = gradeDao;
        this.teacherDao = teacherDao;
    }

    public void GroupInit() {

        long teacherId = 1;
        Group group = this.getMostSuccessfulGroupByTeacherId(teacherId);
        if(group == null)
            log.info("No info");
        else {
            log.info("Teacher " + this.teacherDao.findById(teacherId).getLastName());
            log.info("Group = " + group.getName());
            log.info("Course = " + group.getCourse());
        }
    }

    private Group getMostSuccessfulGroupByTeacherId(Long teacherId) {

        List<Lesson> lessons = this.lessonDao.findLessonsByTeacherId(teacherId);
        if(lessons.isEmpty()) {
            return null;
        }

        float median = -1;
        Group bestGroup = null;

        for(Lesson lesson: lessons) {

            Group curGroup = lesson.getGroup();

            List<Student> students = this.studentDao.findStudentsByGroupId(curGroup.getId());
            List<Integer> grades = new ArrayList<>();

            for (Student student: students) {
                Grade grade = this.gradeDao.getGradeByStudentAndLessonId(lesson.getId(), student.getId());
                if(grade == null) {
                    continue;
                }
                grades.add(grade.getGrade());
            }
            Collections.sort(grades);

            float tempMedian;

            if(grades.size() == 0) {
                continue;
            }
            if(grades.size() == 1) {
                tempMedian = grades.get(0);
            } else if(grades.size() % 2 == 0) {
                tempMedian = (grades.get(grades.size() / 2) + grades.get(grades.size() / 2 + 1)) / 2;
            } else {
                tempMedian = grades.get(grades.size() / 2);
            }
            if (tempMedian > median) {
                median = tempMedian;
                bestGroup = curGroup;
            }
            grades.clear();
        }
        return bestGroup;
    }
}
