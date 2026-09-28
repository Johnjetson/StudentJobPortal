<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Application" %>

<%
    List<Application> applications =
            (List<Application>) request.getAttribute("applications");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>My Applications</title>
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


        <!-- Page Header -->

        <section class="dashboard-header">

            <p class="dashboard-label">
                APPLICATIONS
            </p>

            <h1>
                My Applications
            </h1>

            <p>
                Track the jobs you have applied for.
            </p>

        </section>


        <!-- Applications -->

        <%
            if (applications != null && !applications.isEmpty()) {

                for (Application app : applications) {
        %>

            <div class="application-card">

                <h2>
                    <%= app.getJobTitle() %>
                </h2>

                <p>
                    <strong>Company:</strong>
                    <%= app.getCompanyName() %>
                </p>

                <p>
                    <strong>Location:</strong>
                    <%= app.getLocation() %>
                </p>

                <p>
                    <strong>Application ID:</strong>
                    <%= app.getApplicationId() %>
                </p>

                <p>
                    <strong>Application Date:</strong>
                    <%= app.getApplicationDate() %>
                </p>

                <p>
                    <strong>Status:</strong>

                    <span class="status">
                        <%= app.getStatus() %>
                    </span>

                </p>

            </div>

        <%
                }

            } else {
        %>

            <div class="application-card">

                <h2>
                    No Applications Yet
                </h2>

                <p>
                    You have not applied for any jobs yet.
                </p>

                <br>

                <a href="JobServlet">
                    Browse Available Jobs
                </a>

            </div>

        <%
            }
        %>

    </div>

</body>

</html>