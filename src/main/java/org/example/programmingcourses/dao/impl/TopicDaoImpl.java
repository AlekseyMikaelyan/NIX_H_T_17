package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Topic;
import org.hibernate.Session;

import java.util.List;

public class TopicDaoImpl implements GeneralDao<Topic> {

    private Session session;

    public TopicDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Topic topic) {
        session.save(topic);
    }

    @Override
    public Topic findById(Long id) {
        return session.get(Topic.class, id);
    }

    @Override
    public List<Topic> findAll() {
        List<Topic> topicList = session.createQuery("from Topic").list();
        return topicList;
    }
}
