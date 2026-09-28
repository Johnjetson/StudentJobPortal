<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jobportal.model.Student" %>

<%
    Student student =
            (Student) session.getAttribute("student");

    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="portal-container">

        <!-- Navigation -->

        <nav class="portal-navbar">

            <div class="logo">
                Student<span>Job</span>
            </div>

            <div class="portal-nav-links">

                <a href="dashboard.jsp">
                    Dashboard
                </a>

                <a href="JobServlet">
                    Jobs
                </a>

                <a href="MyApplicationsServlet">
                    My Applications
                </a>

                <a href="LogoutServlet">
                    Logout
                </a>

            </div>

        </nav>


        <!-- Dashboard Header -->

        <section class="dashboard-header">

            <div>

                <p class="dashboard-label">
                    STUDENT DASHBOARD
                </p>

                <h1>
                    Welcome, <%= student.getName() %>!
                </h1>

                <p>
                    Find opportunities and manage
                    your job applications.
                </p>

            </div>

        </section>


        <!-- Profile -->

        <section class="profile-card">

            <div class="profile-icon">
                👤
            </div>

            <div class="profile-info">

                <h2>
                    Your Profile
                </h2>

                <p>
                    <strong>Email:</strong>
                    <%= student.getEmail() %>
                </p>

                <p>
                    <strong>Department:</strong>
                    <%= student.getDepartment() %>
                </p>

                <p>
                    <strong>Graduation Year:</strong>
                    <%= student.getGraduationYear() %>
                </p>

            </div>

        </section>


        <!-- Dashboard Actions -->

        <section class="dashboard-actions">

            <a href="JobServlet"
               class="dashboard-action-card">

                <div class="action-icon">
                    🔍
                </div>

                <h3>
                    Find Jobs
                </h3>

                <p>
                    Browse available job
                    opportunities.
                </p>

            </a>


            <a href="MyApplicationsServlet"
               class="dashboard-action-card">

                <div class="action-icon">
                    📋
                </div>

                <h3>
                    My Applications
                </h3>

                <p>
                    View the jobs you have
                    applied for.
                </p>

            </a>


            <a href="LogoutServlet"
               class="dashboard-action-card logout-card">

                <div class="action-icon">
                    🚪
                </div>

                <h3>
                    Logout
                </h3>

                <p>
                    Sign out of your account.
                </p>

            </a>

        </section>

    </div>

</body>

</html>