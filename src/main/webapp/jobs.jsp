<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Available Jobs</title>
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
                JOB OPPORTUNITIES
            </p>

            <h1>
                Available Jobs
            </h1>

            <p>
                Explore job opportunities and apply for the ones
                that match your skills.
            </p>

        </section>


        <!-- Jobs -->

        <%
            if (jobs != null && !jobs.isEmpty()) {

                for (Job job : jobs) {
        %>

            <div class="job-card">

                <h2>
                    <%= job.getJobTitle() %>
                </h2>

                <p>
                    <strong>Company:</strong>
                    <%= job.getCompanyName() %>
                </p>

                <p>
                    <strong>Location:</strong>
                    <%= job.getLocation() %>
                </p>

                <p>
                    <strong>Salary:</strong>
                    <%= job.getSalary() %>
                </p>

                <p>
                    <strong>Skills:</strong>
                    <%= job.getSkillsRequired() %>
                </p>

                <p>
                    <strong>Description:</strong>
                    <%= job.getDescription() %>
                </p>

                <p>
                    <strong>Application Deadline:</strong>
                    <%= job.getDeadline() %>
                </p>


                <form action="ApplyServlet" method="post">

                    <input type="hidden"
                           name="jobId"
                           value="<%= job.getJobId() %>">

                    <button type="submit">
                        Apply Now
                    </button>

                </form>

            </div>

        <%
                }

            } else {
        %>

            <div class="application-card">

                <h2>No Jobs Available</h2>

                <p>
                    There are currently no job opportunities available.
                </p>

            </div>

        <%
            }
        %>

    </div>

</body>

</html>