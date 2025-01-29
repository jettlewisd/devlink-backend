package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ConnectionDao;
import com.devlink.devlink.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@CrossOrigin
public class ConnectionController {

    private final ConnectionDao connectionDao;

    @Autowired
    public ConnectionController(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }


    @GetMapping
    public List<Connection> getAllConnections() {
        return connectionDao.getAllConnections();
    }

    @GetMapping("/{user_id}/{connected_user_id}")
    public Connection getConnection(@PathVariable Long user_id, @PathVariable Long connected_user_id){
        return connectionDao.getConnection(user_id, connected_user_id);
    }

    @PostMapping
    public boolean createConnection(@RequestBody Connection connection) {
        return connectionDao.createConnection(connection);
    }

    @DeleteMapping("/{user_id}/{connected_user_id}")
    public boolean removeConnection(@PathVariable Long user_id, @PathVariable Long connected_user_id) {
        return connectionDao.removeConnection(user_id, connected_user_id);
    }

    @GetMapping("/user/{user_id}")
    public List<Connection> getConnectionsByUserId(@PathVariable Long user_id){
        return connectionDao.getConnectionsByUserId(user_id);
    }
}
