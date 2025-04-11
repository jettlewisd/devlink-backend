-- DevLink Database Initialization Script
--rollback;
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all DB objects in proper order (respecting foreign key dependencies)
-- *************************************************************************************************
DROP TABLE IF EXISTS project_contributors;
DROP TABLE IF EXISTS connections;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

-- *************************************************************************************************
-- Create tables and constraints
-- *************************************************************************************************

-- USERS
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL
);

-- PROJECTS
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    start_date DATE NOT NULL,
    end_date DATE,
    created_by INTEGER NOT NULL,
    CONSTRAINT FK_projects_created_by FOREIGN KEY (created_by) REFERENCES users(id)
        ON DELETE CASCADE
);

-- SKILLS
CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    skill_name VARCHAR(100) NOT NULL,
    proficiency_level VARCHAR(50),
    CONSTRAINT FK_skills_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

-- POSTS
CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT FK_posts_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

-- CONNECTIONS
CREATE TABLE connections (
    user_id INTEGER NOT NULL,
    connected_user_id INTEGER NOT NULL,
    connection_date TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT FK_connections_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT FK_connections_connected_user FOREIGN KEY (connected_user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT PK_connections PRIMARY KEY (user_id, connected_user_id)
);

-- PROJECT CONTRIBUTORS
CREATE TABLE project_contributors (
    user_id INTEGER NOT NULL,
    project_id INTEGER NOT NULL,
    role VARCHAR(100),
    date_joined DATE NOT NULL,
    CONSTRAINT FK_pc_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT FK_pc_project FOREIGN KEY (project_id) REFERENCES projects(id)
        ON DELETE CASCADE,
    CONSTRAINT PK_project_contributors PRIMARY KEY (user_id, project_id)
);

-- *************************************************************************************************
-- Insert sample data
-- *************************************************************************************************

-- Users (passwords here are plaintext just for mock data purposes)
INSERT INTO users (first_name, last_name, email, password) VALUES
    ('Alice', 'Smith', 'alice@example.com', 'password123'),
    ('Bob', 'Johnson', 'bob@example.com', 'password123'),
    ('Charlie', 'Brown', 'charlie@example.com', 'password123');

-- Projects
INSERT INTO projects (name, description, start_date, end_date, created_by) VALUES
    ('Open Source Tracker', 'A platform to track open-source contributions', '2025-01-01', '2025-06-01', 1),
    ('DevCollab', 'A collaborative tool for developers', '2025-02-15', NULL, 2);

-- Skills
INSERT INTO skills (user_id, skill_name, proficiency_level) VALUES
    (1, 'Java', 'Advanced'),
    (1, 'Spring Boot', 'Intermediate'),
    (2, 'JavaScript', 'Advanced'),
    (3, 'Vue.js', 'Intermediate'),
    (3, 'PostgreSQL', 'Beginner');

-- Posts
INSERT INTO posts (user_id, content, created_at) VALUES
    (1, 'Excited to start contributing to DevCollab!', '2025-03-10 10:30:00'),
    (2, 'Working on the project setup today.', '2025-03-11 09:00:00'),
    (3, 'Looking for frontend collaborators!', '2025-03-12 14:45:00');

-- Connections
INSERT INTO connections (user_id, connected_user_id, connection_date) VALUES
    (1, 2, '2025-03-01 12:00:00'),
    (1, 3, '2025-03-02 15:20:00'),
    (2, 3, '2025-03-03 09:45:00');

-- Project Contributors
INSERT INTO project_contributors (user_id, project_id, role, date_joined) VALUES
    (1, 1, 'Lead Developer', '2025-01-01'),
    (2, 1, 'Contributor', '2025-01-15'),
    (2, 2, 'Project Manager', '2025-02-20'),
    (3, 2, 'Frontend Dev', '2025-02-25');

COMMIT TRANSACTION;
