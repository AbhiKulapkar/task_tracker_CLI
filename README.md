# Task Tracker API

A robust backend Task Management REST API built with Java and Spring Boot. This application allows users to securely create, view, update, and delete tasks while seamlessly tracking their lifecycle statuses (`todo`, `inprogress`, `done`). 

A core architectural feature of this project is its strict reliance on **Pure Java Logic**. Instead of abstracting operations behind built-in JPA/Hibernate query methods, the core business logic retrieves entire datasets and processes them using custom manual iteration loops. This guarantees strict data validation, handles space-formatting exceptions, and forces case-insensitive matching entirely at the logic layer.

## 🚀 Features
- **Create Tasks:** Add new tasks with detailed descriptions and initial statuses.
- **Pure Logic Updates:** Safely update task names, descriptions, and statuses using strict backend validation loops that ignore invisible spaces and capitalization mismatches without relying on database-level constraints.
- **Categorized Retrieval:** Fetch specific lists of tasks based on their exact status using custom manual filtering loops.
- **Timestamping:** Automatically stamps and persists `createdAt` and `updatedAt` times for every transaction.
- **Exception Handling:** Built-in safeguards to prevent empty DTO fields, malformed JSON inputs, and Enum mismatch errors.

## 🛠️ Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven
- **Testing:** Postman

## 🗄️ Database Schema
The application automatically generates a `task_tracker` table in MySQL with the following standard SQL structure:
- `taskId` (Primary Key, Auto-increment)
- `task_name` (String)
- `task_description` (String)
- `task_status` (Enum: `todo`, `inprogress`, `done`)
- `created_at` (Timestamp)
- `updated_at` (Timestamp)

---

## ⚙️ How to Run the Project Locally

To run this application on your local machine, follow these steps:

### Prerequisites
1. **Java Development Kit (JDK):** Ensure you have Java 17 or higher installed.
2. **MySQL:** Install MySQL Server and have it running locally.
3. **Maven:** Install Maven (or use the provided `mvnw` wrapper).

### Step 1: Clone the Repository
Open your terminal and clone this project:
```bash
git clone [https://github.com/AbhiKulapkar/task_tracker_CLI.git](https://github.com/AbhiKulapkar/task_tracker_CLI.git)
```
then move your terminal inside the project folder
```
cd task_tracker_CLI
```
### Step 2: Clone the Repository
1. Open your MySQL client (like MySQL Workbench) and create a new database:

```
CREATE DATABASE tasktracker;
```

2. Open the project files and navigate to src/main/resources/application.properties.

3. Update the configuration file with your MySQL credentials:

```
spring.datasource.url=jdbc:mysql://localhost:3306/tasktracker
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```
### Step 3: Run the Application

  You can start the server directly from the terminal using the Maven wrapper:

on Windows:
  ```
  mvnw spring-boot:run

  ```
on Mac/Linux:
  ```
  ./mvnw spring-boot:run
  ```
  Alternatively, you can open the project folder in an IDE like Eclipse or IntelliJ and click "Run" on the main application class.
  
### Step 4: Test the Endpoints

Once the application is running on port 8080, open Postman to test the API. Ensure your request body is set to raw -> JSON.

Available Endpoints:
- POST: ``` http://localhost:8080/TaskTracker/AddTask ```
- PUT: ``` http://localhost:8080/TaskTracker/UpdateTask/{taskName} ```
- DELETE: ``` http://localhost:8080/TaskTracker/DeleteTask/{taskName} ```
- GET: ``` http://localhost:8080/TaskTracker/Tasks/Todo ```
- GET: ``` http://localhost:8080/TaskTracker/Tasks/InProgress ```
- GET: ``` http://localhost:8080/TaskTracker/Tasks/Done ```

  
