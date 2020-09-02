package org.example.programmingcourses.dao.interfaces;

import org.example.programmingcourses.entity.abstr.AbstractEntity;

import java.util.List;

public interface GeneralDao<T extends AbstractEntity> {
    void create(T t);
    T findById(Long id);
    List<T> findAll();
}
