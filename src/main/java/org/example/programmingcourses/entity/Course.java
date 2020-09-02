package org.example.programmingcourses.entity;

import org.example.programmingcourses.entity.abstr.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course extends AbstractEntity {

    @Column(name = "name_of_course", nullable = false)
    private String name;

    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
