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
cd task_tracker_CLI
```
