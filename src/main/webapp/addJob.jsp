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
    <title>Add New Job</title>
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


        <!-- Page Header -->

        <section class="dashboard-header">

            <p class="dashboard-label">
                ADMIN PANEL
            </p>

            <h1>
                Add New Job
            </h1>

            <p>
                Create a new job opportunity for students.
            </p>

        </section>


        <!-- Add Job Form -->

        <form action="AddJobServlet" method="post">

            <label>
                Company Name
            </label>

            <input type="text"
                   name="companyName"
                   placeholder="Enter company name"
                   required>


            <label>
                Job Title
            </label>

            <input type="text"
                   name="jobTitle"
                   placeholder="Example: Java Developer"
                   required>


            <label>
                Description
            </label>

            <textarea name="description"
                      placeholder="Enter job description"
                      required></textarea>


            <label>
                Location
            </label>

            <input type="text"
                   name="location"
                   placeholder="Example: Chennai"
                   required>


            <label>
                Salary
            </label>

            <input type="text"
                   name="salary"
                   placeholder="Example: 4-6 LPA"
                   required>


            <label>
                Skills Required
            </label>

            <input type="text"
                   name="skillsRequired"
                   placeholder="Example: Java, SQL, HTML, CSS"
                   required>


            <label>
                Application Deadline
            </label>

            <input type="date"
       				name="deadline"
       				id="deadline"
       				required>


            <button type="submit">
                Add Job
            </button>

        </form>


        <div class="page-links">

            <a href="adminDashboard.jsp">
                ← Back to Admin Dashboard
            </a>

        </div>

    </div>
    <script>

    const today = new Date().toISOString().split("T")[0];

    document.getElementById("deadline").setAttribute(
        "min",
        today
    );

</script>

</body>

</html>