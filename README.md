Student Job Portal
A Java web application using JSP, Servlets, JDBC, MySQL, HTML, and CSS. Students can register, browse and apply for jobs, and track applications. Admins can log in and add jobs.
Features
Student
Register, log in, and log out
View and apply for jobs
Prevent duplicate applications
Track submitted applications
Session-based authentication
Admin
Log in and log out
View and add jobs
Protected admin access
Technologies
Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, Apache Tomcat, and Eclipse.
Architecture
HTML/JSP → Servlets → DAO → JDBC → MySQL

JSP handles the interface, Servlets manage requests, DAOs handle database operations, and MySQL stores application data.
Database
Database: student_job_portal
Tables:
students: Student details
jobs: Job opportunities
applications: Student applications
admin: Admin credentials
Applications link students and jobs through student_id and job_id. Duplicate applications are prevented by checking this combination.
Application Flow
Student
Registration → Login → Dashboard → Jobs → Apply → My Applications

Admin
Login → Dashboard → Add Job → Job Available to Students

Session Management
Logged-in student and admin information is stored in HTTP sessions. Protected pages redirect unauthenticated users to the appropriate login page.
Project Structure
StudentJobPortal
├── src/main/java/com.jobportal
│   ├── controller
│   ├── dao
│   ├── model
│   └── util
└── src/main/webapp
    ├── JSP pages
    ├── index.html
    └── style.css

Requirements
Java JDK
Eclipse IDE for Enterprise Java
Apache Tomcat 11
MySQL Server
MySQL Connector/J
Database Setup
CREATE DATABASE student_job_portal;
USE student_job_portal;

Create the required tables and an admin account:
INSERT INTO admin (username, password)
VALUES ('admin', 'admin123');

Update MySQL credentials in DBConnection.java:
private static final String URL =
        "jdbc:mysql://localhost:3306/student_job_portal";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";

How to Run
Open the project in Eclipse.
Configure and add it to Tomcat.
Start MySQL and Tomcat.
Open:
http://localhost:8082/StudentJobPortal/

The port may vary.
Future Improvements
Job search and filtering
Resume uploads
Application status updates
Email notifications
Password hashing
Responsive design
Pagination
Learning Outcomes
This project provided experience with Java web development, JSP, Servlets, JDBC, MySQL, CRUD operations, sessions, MVC organization, HTML, CSS, Tomcat, and GitHub.
Author
Student Job Portal — CSE Academic Project
A practical Java and MySQL application demonstrating full-stack development.
