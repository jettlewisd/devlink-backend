package com.devlink.devlink.dao;
import com.devlink.devlink.model.Connection;

import java.util.List;

public interface ConnectionDao {

    // CRUD OPS
    Connection getConnection(Long userId, Long connectedUserId);
    List<Connection> getAllConnections();
    boolean createConnection(Connection connection);
    boolean removeConnection(Long userId, Long connectedUserId);

    // Beyond CRUD Methods
    List<Connection> getConnectionsByUserId(Long userId); // Retrieve all connections for a user
}

