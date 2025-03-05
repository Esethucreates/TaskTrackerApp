# Task List Manager 📋

## Project Overview 🚀

A robust Task List Management application built using Spring Boot and PostgreSQL, demonstrating proficiency in creating RESTful web applications with modern Java technologies.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Database Configuration](#database-configuration)
- [Running the Application](#running-the-application)
- [Future Improvements](#future-improvements)

## Features ✨

- Create, Read, Update, and Delete (CRUD) operations for Tasks
- Create, Read, Update, and Delete (CRUD) operations for Task Lists
- Relationship management between Tasks and Task Lists
- RESTful API design
- Automatic database schema generation with Hibernate
- PostgreSQL database integration

## Tech Stack 🛠️

### Backend
- Java 11+
- Spring Boot 2.x
- Spring Data JPA
- Hibernate ORM

### Database
- PostgreSQL

### Build Tool
- Maven

### Additional Tools
- Spring Web
- Spring Validation
- Docker

## Prerequisites 📋

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven
- Docker desktop
- Git
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Installation 💻

### Cloning the Repository

```bash
# Clone the repository
git clone https://github.com/Esethucreates/TaskTrackerApp.git

# Navigate to the project directory
cd TaskTrackerApp
```

## API Endpoints 🌐

### Task Endpoints
- `GET /task-lists/{task_list_id}/tasks`: Retrieve all tasks
- `GET /task-lists/{task_list_id}/task/{id}`: Retrieve a specific task
- `POST /task-lists/{task_list_id}/task`: Create a new task
- `PUT /task-lists/{task_list_id}/task/{id}`: Update an existing task
- `DELETE /task-lists/{task_list_id}/task/{id}`: Delete a task

### Task List Endpoints
- `GET /task-lists`: Retrieve all task lists
- `GET /task-lists/{id}`: Retrieve a specific task list
- `POST /task-lists`: Create a new task list
- `PUT /task-lists/{id}`: Update an existing task list
- `DELETE /task-lists/{id}`: Delete a task list

## Database Configuration 🗃️

### PostgreSQL Configuration

Update `src/main/resources/application.properties`:

```properties
# Database Connection
spring.datasource.url=jdbc:postgresql://localhost:5432/tasklistdb
spring.datasource.username=your_username
spring.datasource.password=your_password

# Hibernate DDL Auto
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application 🏃

### Using Maven

```bash
# Clean and compile the project
mvn clean install

# Run the application
mvn spring-boot:run
```
## Future Improvements 🚧

- Add authentication and authorization
- Implement task prioritization
- Create user profiles
- Add more complex task relationships
- Develop frontend interface

## Learning Outcomes 🧠

Through this project, I gained experience in:
- Spring Boot application development
- RESTful API design
- JPA and Hibernate
- Database relationship management
- Implementing CRUD operations

## License 📜

This project is open-source and available under the MIT License.

---


## Contact 📧

Your Name - esethupzikhali7425@gmail.com
