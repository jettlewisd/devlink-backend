package com.devlink.devlink.controller;


import com.devlink.devlink.dao.UserDao;
import com.devlink.devlink.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @PostMapping
    public Long createUser(@RequestBody User user){
        return userDao.createUser(user);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable Long id, @RequestBody User user) {
        return userDao.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userDao.deleteUser(id);
    }

    @GetMapping("/skills/{skill_name}")
    public List<User> findUsersBySkill(@PathVariable String skill_name){
        return userDao.findUsersBySkill(skill_name);
    }

    @GetMapping("/{id}/connections")
    public List<User> getConnectionsForUser(@PathVariable Long id) {
        return userDao.getConnectionsForUser(id);
    }

    @GetMapping("/{id}/recommendations")
    public List<User> getRecommendedConnectionsForUser(@PathVariable Long id) {
        return userDao.getRecommendedConnectionsForUser(id);
    }
}
