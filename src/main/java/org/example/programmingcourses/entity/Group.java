package org.example.programmingcourses.entity;

import org.example.programmingcourses.entity.abstr.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group extends AbstractEntity {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Group() {

    }


    public Group(String name, Course course, Teacher teacher) {
        this.name = name;
        this.course = course;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
