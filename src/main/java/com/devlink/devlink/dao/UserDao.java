package com.devlink.devlink.dao;

import com.devlink.devlink.model.User;

import java.util.List;

public interface UserDao {

    //CRUD OPS
    User getUserById(Long id);
    List<User> getAllUsers();
    Long createUser(User user);
    boolean updateUser(Long id, User user);
    boolean deleteUser(Long id);

    //BEYOND CRUD METHODS
    List<User> findUsersBySkill(String skillName);
    List<User> getConnectionsForUser(Long userId);
    List<User> getRecommendedConnectionsForUser(Long userId);

}
