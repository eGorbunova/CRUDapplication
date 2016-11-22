package com.crudapp.dao;

import com.crudapp.model.User;

import java.util.List;

/**
 * Created by Work on 18.11.2016.
 */
public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User getUserById(int id);

    public List<User> getListUsers();

    public List<User> getUser(String name);
}
