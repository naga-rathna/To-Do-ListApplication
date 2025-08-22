
#  To-Do List Application (Spring Boot)

This is a **To-Do List Application** built using **Spring Boot** that helps users manage their daily tasks efficiently.  
It follows a **layered architecture** with Entity, Repository, Service, and Controller layers, ensuring clean separation of concerns.  
The application provides **REST APIs** for performing CRUD operations on both **users** and **tasks**, with database integration via Spring Data JPA.

# Key Features
- **Task Management** – Add, update, view, and delete tasks easily.  
- **User Management** – Manage users with full CRUD operations.  
- **RESTful APIs** – Well-structured endpoints for interacting with tasks and users.  
- **Layered Architecture** – Clean separation of concerns using Entity, Repository, Service, and Controller layers.  
- **Database Integration** – Uses Spring Data JPA and Postgresql databases.  
- **Scalable & Extensible** – Can be extended with authentication, frontend integration, or additional features.  
- **Maven Build Tool** – Easy project setup and dependency management.  

# Tech Stack
- Java 17+  
- Spring Boot  
- Spring Data JPA  
- Postgresql Database  
- Maven  

# Project Structure

com.example
 ├── ToDoListApplication.java
 ├── controller
 │    ├── TaskController.java
 │    └── UserController.java
 ├── entity
 │    ├── Task.java
 │    └── User.java
 ├── repository
 │    ├── TaskRepository.java
 │    └── UserRepository.java
 └── service
      ├── TaskServiceInterface.java
      ├── TaskServiceImpl.java
      ├── UserServiceInterface.java
      └── UserServiceImpl.java

# How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/todo-list.git

2. Navigate into the project folder:
   ```bash
   cd To-Do-List

3. Run the project:
   ```bash
   mvn spring-boot:run
   

# API Endpoints

# Task APIs
- `POST /tasks/add` → Add new task  
- `GET /tasks/all` → Get all tasks  
- `PUT /tasks/update/{id}` → Update task by ID  
- `DELETE /tasks/delete/{id}` → Delete task by ID  

# User APIs
- `POST /users/add` → Add new user  
- `GET /users/all` → Get all users  
- `PUT /users/update/{id}` → Update user by ID  
- `DELETE /users/delete/{id}` → Delete user by ID  

---

# Purpose
The purpose of this project is to help learners understand and practice **Spring Boot REST API development** with proper architecture.  
