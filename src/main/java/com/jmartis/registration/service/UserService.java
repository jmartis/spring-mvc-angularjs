package com.jmartis.registration.service;

import com.jmartis.registration.model.User;

import java.util.List;

/**
 * Created by magic on 8/20/2016.
 */
public interface UserService {
    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    void deleteAllUsers();
    public boolean isUserExist(User user);
}
