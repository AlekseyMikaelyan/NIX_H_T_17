package org.example.programmingcourses.dao.impl;

import org.example.programmingcourses.dao.interfaces.GeneralDao;
import org.example.programmingcourses.entity.Group;
import org.hibernate.Session;

import java.util.List;

public class GroupDaoImpl implements GeneralDao<Group> {

    private Session session;

    public GroupDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void create(Group groups) {
        session.save(groups);
    }

    @Override
    public Group findById(Long id) {
        return session.get(Group.class, id);
    }

    @Override
    public List<Group> findAll() {
        List<Group> groupList = session.createQuery("from Group").list();
        return groupList;
    }
}
