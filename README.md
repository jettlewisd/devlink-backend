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

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/devlink/
│   │   ├── controller/        # REST controllers
│   │   ├── dao/               # DAO interfaces and JDBC implementations
│   │   ├── model/             # Entity classes
│   │   ├── service/           # Business logic
│   │   ├── exception/         # Custom exceptions and global handler
│   │   └── DevLinkApplication.java
│   └── resources/
│       ├── application.properties
│       └── schema.sql         # (optional) DB schema if used for init
└── test/
```

---

## 🧪 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/devlink-backend.git
cd devlink-backend
```

### 2. Set up the database

Make sure PostgreSQL is running and create a database named `devlink`.

```sql
CREATE DATABASE devlink;
```

### 3. Configure application properties

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/devlink
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=none
server.port=8080
```

### 4. Run the application

Using IntelliJ IDEA or:

```bash
./mvnw spring-boot:run
```

App runs at: `http://localhost:8080`

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
