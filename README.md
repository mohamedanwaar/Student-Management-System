# Student-Management-System
# Student Management System

A web-based student management system built with **Java Servlets**, **JSP**, and **MySQL**. The application allows users to perform **CRUD operations** (Create, Read, Update, Delete) on student records.

## Features

- View a list of all students.
- Add new students with validation.
- Update existing student information.
- Delete student records.
- Form validation (client-side and server-side).
- Real-time error messaging.

## Technologies Used

- **Backend**: Java EE (Servlets, JSP)
- **Database**: MySQL
- **Database Connectivity**: JDBC
- **Frontend**: HTML, CSS
- **Build Tool**: Maven

## Project Structure

```
student-management-system/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/studentsystem/
│       │       ├── Student.java
│       │       ├── StudentControllerServlet.java
│       │       └── StudentDbUtil.java
│       └── webapp/
│           ├── AddStudentForm.jsp
│           ├── update-student-form.jsp
│           ├── studentsView.jsp
│           └── style.css
├── pom.xml
```

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mohamedanwaar/Student-Management-System.git
   cd student-management-system
   ```

2. **Configure the MySQL database**:
   - Create a new database.
   - Use the following schema:
     ```sql
     CREATE TABLE student (
         id INT PRIMARY KEY AUTO_INCREMENT,
         first_name VARCHAR(50),
         last_name VARCHAR(50),
         email VARCHAR(100),
         Gpa FLOAT
     );
     ```
   - Update the database connection details in your application server's configuration.

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Deploy the WAR file** to your application server (e.g., Apache Tomcat).

5. **Access the application**:  
   Open your browser and navigate to `http://localhost:8080/student-management-system`.

## 🚀 Usage Guide

### ➕ Add a Student
- Navigate to the Add Student page.
- Fill in the student’s:
  - First Name
  - Last Name
  - Email
  - GPA
- Click **Submit**

### ✏️ Update a Student
- Click the **Edit** button next to a student’s record.
- Modify the fields as needed.
- Click **Save**

### ❌ Delete a Student
- Click the **Delete** button next to a student.
- Confirm the deletion.

### 📋 View Students
- The homepage (`studentsView.jsp`) displays a list of all students stored in the databas

## Validation Details

- **First Name and Last Name**: Only letters and spaces are allowed.
- **Email**: Must follow a valid email format.
- **GPA**: Must be a number between 0 and 4.#   S t u d e n t - M a n a g e m e n t - S y s t e m 
 
 
