# DevLink - Backend

DevLink is a full-stack social collaboration platform for developers, designed to help users connect, showcase skills, collaborate on projects, and grow their network. This repository contains the backend API built with **Spring Boot (Java)**, using **JDBC templates** for data access and **PostgreSQL** as the database.

---

## 🚀 Features

- User registration and profile management
- Skill tracking with proficiency levels
- Project creation and contributor management
- Developer posts and activity sharing
- Connections between users
- Recommended connections based on skills

---

## 🛠️ Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **Data Access**: Spring JDBC with DAO pattern
- **Testing**: Postman
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA

---


## 🧪 How to Run

1. **Clone the repository**

```bash
git clone https://github.com/jettlewisd/devlink-backend.git
cd devlink-backend
```

2. **Set up PostgreSQL**

Make sure PostgreSQL is installed and running on your system.  
Then create a database for the project:

```sql
CREATE DATABASE devlink_db;
```

3. **Configure application properties**

Edit the `src/main/resources/application.properties` file to match your local PostgreSQL setup (use the values provided below):

```properties
spring.application.name=DevLink

# Database connection
spring.datasource.url=jdbc:postgresql://localhost:5432/devlink_db
spring.datasource.name=devlink_db
spring.datasource.username=postgres
spring.datasource.password=postgres1
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate configuration (optional)
spring.sql.init.mode=always
```

4. **Populate the database**

Use the provided SQL file (`schema.sql`, `data.sql`, or any included instructions) to create the tables and add sample data. If no file is included, you will need to add your own data manually. (Check the resources folder for SQL files).

5. **Run the application**

Using IntelliJ IDEA or from the terminal:

```bash
./mvnw spring-boot:run
```

The backend will start at: [http://localhost:8080](http://localhost:8080)



---

## 📬 Example API Endpoints

| Endpoint                                  | Method | Description                          |
|-------------------------------------------|--------|--------------------------------------|
| `/api/users`                              | GET    | Get all users                        |
| `/api/users/{id}`                         | GET    | Get user by ID                       |
| `/api/users`                              | POST   | Create a new user                    |
| `/api/users/{id}`                         | PUT    | Update a user                        |
| `/api/users/{id}`                         | DELETE | Delete a user                        |
| `/api/users/skill/{skillName}`            | GET    | Find users by skill name             |
| `/api/users/{id}/connections`             | GET    | Get user connections                 |
| `/api/users/{id}/recommendations`         | GET    | Get recommended connections          |
| `/api/skills`                             | GET    | Get all skills                       |
| `/api/projects`                           | POST   | Create a new project                 |
| `/api/projects/creator/{userId}`          | GET    | Get projects by creator              |
| `/api/project-contributors/project/{id}`  | GET    | Get contributors for a project       |
| `/api/posts/user/{userId}`                | GET    | Get posts by a specific user         |

---

## ✅ Status

🔧 In Development — Backend complete with all core features. Login features to come.  

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
