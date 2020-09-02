package org.example.programmingcourses.entity;

import org.example.programmingcourses.entity.abstr.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class Grade extends AbstractEntity {

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Grade() {

    }

    public Grade(Integer grade, Student student, Lesson lesson) {
        this.grade = grade;
        this.student = student;
        this.lesson = lesson;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
