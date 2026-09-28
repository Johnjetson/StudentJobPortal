<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jobportal.model.Admin" %>

<%
    Admin admin =
            (Admin) session.getAttribute("admin");

    if (admin == null) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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

                <a href="adminDashboard.jsp">
                    Dashboard
                </a>

                <a href="JobServlet">
                    Jobs
                </a>

                <a href="addJob.jsp">
                    Add Job
                </a>

                <a href="adminLogoutServlet">
                    Logout
                </a>

            </div>

        </nav>


        <!-- Dashboard Header -->

        <section class="dashboard-header">

            <p class="dashboard-label">
                ADMIN PANEL
            </p>

            <h1>
                Welcome, <%= admin.getUsername() %>!
            </h1>

            <p>
                Manage job opportunities and the student job portal.
            </p>

        </section>


        <!-- Admin Information -->

        <section class="profile-card">

            <div class="profile-icon">
                🛠️
            </div>

            <div class="profile-info">

                <h2>
                    Administrator
                </h2>

                <p>
                    <strong>Username:</strong>
                    <%= admin.getUsername() %>
                </p>

                <p>
                    <strong>Admin ID:</strong>
                    <%= admin.getAdminId() %>
                </p>

            </div>

        </section>


        <!-- Admin Actions -->

        <section class="dashboard-actions">

            <a href="JobServlet"
               class="dashboard-action-card">

                <div class="action-icon">
                    💼
                </div>

                <h3>
                    View Jobs
                </h3>

                <p>
                    View all available job opportunities.
                </p>

            </a>


            <a href="addJob.jsp"
               class="dashboard-action-card">

                <div class="action-icon">
                    ➕
                </div>

                <h3>
                    Add New Job
                </h3>

                <p>
                    Create and publish a new job opportunity.
                </p>

            </a>


            <a href="adminLogoutServlet"
               class="dashboard-action-card logout-card">

                <div class="action-icon">
                    🚪
                </div>

                <h3>
                    Logout
                </h3>

                <p>
                    Sign out of the administrator account.
                </p>

            </a>

        </section>

    </div>

</body>

</html>