# Task Management System

A RESTful Task Management API built using **Java**, **Spring Boot**, **Spring Data JPA**, and **H2 Database**. This application allows users to create, retrieve, update, delete, and mark tasks as completed. The API is secured using **Spring Security Basic Authentication**.

---

## Features

- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update an existing task
- Delete a task
- Mark a task as completed
- Basic input validation
- Global exception handling
- Basic Authentication using Spring Security
- Unit testing using JUnit and Mockito
- In-memory H2 database

---

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- Maven
- Lombok
- JUnit 5
- Mockito

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.taskmanagement
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── exception
│   │       ├── model
│   │       ├── repository
│   │       └── service
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── com.example.taskmanagement
```

---

## Task Model

| Field | Type |
|--------|------|
| id | Long |
| title | String |
| description | String |
| dueDate | LocalDate |
| status | Enum (PENDING, IN_PROGRESS, COMPLETED) |
| createdAt | LocalDateTime |
| updatedAt | LocalDateTime |

---

## API Endpoints

### Get All Tasks

```
GET /tasks/all
```

---

### Get Task By ID

```
GET /tasks/{id}
```

---

### Create Task

```
POST /tasks/save
```

Example Request

```json
{
    "title": "Learn Spring Boot",
    "description": "Complete CRUD project",
    "dueDate": "2026-07-20",
    "status": "PENDING"
}
```

---

### Update Task

```
PUT /tasks/{id}
```

---

### Mark Task as Completed

```
PATCH /tasks/{id}/status/complete
```

---

### Delete Task

```
DELETE /tasks/{id}
```

---

## Authentication

This project uses **HTTP Basic Authentication**.

### Username

```
user
```

### Password

```
password
```

Configured these credentials in the `SecurityConfig` class.

---

## Running the Application(## Testing the API Using Postman)

### Step 1: Clone Repository

```bash
git clone https://github.com/Aravind0A/task-management-system.git
```

### Navigate to Project

```bash
cd task-management-system/taskmanagement
```

### Run Application

Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

Windows

```bash
.\mvnw.cmd clean spring-boot:run
```

Or

```bash
mvn spring-boot:run
```

Application starts at

```
http://localhost:8080
```

---

### Step 2: Configure Authentication

Since the API is secured using **Spring Security Basic Authentication**, every request must include valid credentials.

In Postman:

1. Select the **Authorization** tab.
2. Choose **Basic Auth**.
3. Enter the following credentials:

| Username | Password |
|----------|----------|
| user | password |

---

### Step 3: Test the API Endpoints

#### Retrieve All Tasks

```
GET http://localhost:8080/tasks
```

---

#### Retrieve Task by ID

```
GET http://localhost:8080/tasks/1
```

---

#### Create a Task

```
POST http://localhost:8080/tasks
```

Headers

```
Content-Type: application/json
```

Request Body

```json
{
    "title": "Complete Spring Boot Case Study",
    "description": "Implement CRUD operations",
    "dueDate": "2026-07-20",
    "status": "PENDING"
}
```

Expected Response

```
201 Created
```

---

#### Update a Task

```
PUT http://localhost:8080/tasks/1
```

Request Body

```json
{
    "title": "Updated Task",
    "description": "Updated Description",
    "dueDate": "2026-07-25",
    "status": "IN_PROGRESS"
}
```

Expected Response

```
200 OK
```

---

#### Mark Task as Completed

```
PATCH http://localhost:8080/tasks/1/status/complete
```

Expected Response

```
200 OK
```

---

#### Delete Task

```
DELETE http://localhost:8080/tasks/1
```

Expected Response

```
204 No Content
```

---

## Running Tests

Run all unit tests

```bash
./mvnw test
```

Windows

```bash
.\mvnw.cmd clean test
```

---

## Validation

Basic validation has been implemented for:

- Title
- Description
- Due Date
- Status

Invalid requests return

```
400 Bad Request
```

---

## Exception Handling

Global exception handling is implemented using `@RestControllerAdvice`.

Handled exceptions include:

- Task not found
- Invalid request
- Unexpected server errors

---

## HTTP Status Codes

| Status | Description |
|---------|-------------|
| 200 OK | Successful GET, PUT, PATCH |
| 201 Created | Task created successfully |
| 204 No Content | Task deleted successfully |
| 400 Bad Request | Invalid input |
| 401 Unauthorized | Authentication required |
| 404 Not Found | Task not found |
| 500 Internal Server Error | Unexpected server error |

---

## Design Decisions

- Followed layered architecture (Controller → Service → Repository).
- Used DTOs to receive client requests.
- For patch request only "COMPLETED" status is hard-coded
- Implemented global exception handling for consistent error responses.
- Used Spring Security Basic Authentication to secure all endpoints.
- Used H2 in-memory database to keep the application lightweight and easy to run.
- Added unit tests for core service methods using JUnit and Mockito.

---

## Future Improvements

- Can use JWT Authentication instead of basic auth
- Role-Based Authorization
- Pagination and Sorting
- Search Tasks
- Swagger/OpenAPI Documentation
- MySQL/PostgreSQL integration
- Logging using SLF4J
- Can send different status for the tasks

---

GitHub:
https://github.com/Aravind0A
