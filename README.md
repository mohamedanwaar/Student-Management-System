# 🎓 Student Management System

A simple web-based student management system built using **Java Servlets**, **JSP**, and **MySQL**. This application allows users to perform full **CRUD operations** (Create, Read, Update, Delete) on student records.

---

## ✨ Features

- View all students in a table
- Add new students with input validation
- Update existing student data
- Delete students from the database
- Client-side and server-side form validation
- Real-time error messaging

---

## 🛠️ Technologies Used

- **Backend**: Java EE (Servlets, JSP)
- **Database**: MySQL
- **Database Connectivity**: JDBC
- **Frontend**: HTML, CSS
- **Build Tool**: Maven
- **Server**: Apache Tomcat

---

## 📁 Project Structure
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

---

## ⚙️ Setup Instructions

### 1. Clone the Repository


```bash
git clone https://github.com/yourusername/student-management-system.git
cd student-management-system
```


### 2. Configure MySQL Database
Create a new database (e.g., student_db)
Use the following schema:
```MySQL
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    gpa FLOAT
);```
---

### 3. Update DB Config
Update the database connection details in your servlet or configuration file:
```java
String jdbcUrl = "jdbc:mysql://localhost:3306/student_db";
String user = "yourUsername";
String password = "yourPassword";
```
### 4. Build the Project

```bash
mvn clean install
```
### 4. Deploy the WAR File
Deploy the generated WAR file to your Apache Tomcat webapps directory.
Start Tomcat and visit:

```bash
http://localhost:8080/student-management-system

```
## 🚀 Usage / Examples

### ➕ Add a Student

1. Navigate to the **Add Student** page.
2. Fill in the student’s:
   - **First Name**
   - **Last Name**
   - **Email**
   - **GPA**
3. Click **Submit** to add the student.

---

### ✏️ Update a Student

1. Click the **Edit** button next to the student’s record.
2. Modify the necessary fields.
3. Click **Save** to update the information.

---

### ❌ Delete a Student

1. Click the **Delete** button next to the student’s record.
2. Confirm the deletion to remove the student.

---

### 📋 View Students

- The **homepage** (`studentsView.jsp`) displays a complete list of all students stored in the database.
