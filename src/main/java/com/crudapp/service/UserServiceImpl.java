package com.crudapp.service;

import com.crudapp.dao.UserDao;
import com.crudapp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Work on 18.11.2016.
 */
@Service

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getListUsers() {
        return this.userDao.getListUsers();
    }

    @Override
    @Transactional
    public List<User> getUser(String name) {
        return this.userDao.getUser(name);
    }
}
