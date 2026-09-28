package com.jobportal.controller;

import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

@WebServlet("/AddJobServlet")
public class AddJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);

    	if (session == null ||
    	    session.getAttribute("admin") == null) {

    	    response.sendRedirect("adminLogin.jsp");
    	    return;
    	}

        String companyName =
                request.getParameter("companyName");

        String jobTitle =
                request.getParameter("jobTitle");

        String description =
                request.getParameter("description");

        String location =
                request.getParameter("location");

        String salary =
                request.getParameter("salary");

        String skillsRequired =
                request.getParameter("skillsRequired");

        Date deadline =
                Date.valueOf(
                        request.getParameter("deadline")
                );

        // Create Job object
        Job job = new Job();

        job.setCompanyName(companyName);
        job.setJobTitle(jobTitle);
        job.setDescription(description);
        job.setLocation(location);
        job.setSalary(salary);
        job.setSkillsRequired(skillsRequired);
        job.setDeadline(deadline);

        // Send job to DAO
        JobDAO jobDAO = new JobDAO();

        boolean result = jobDAO.addJob(job);

        // Send response
        response.setContentType("text/html");

        if (result) {

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Job Added</title>" +
                "<link rel='stylesheet' href='style.css'>" +
                "</head>" +

                "<body>" +

                "<div class='auth-container'>" +

                "<div class='auth-box'>" +

                "<h1>Job Added Successfully!</h1>" +

                "<p class='auth-subtitle'>" +
                "The new job opportunity has been added successfully." +
                "</p>" +

                "<div class='page-links'>" +

                "<a href='adminDashboard.jsp'>" +
                "Back to Admin Dashboard" +
                "</a>" +

                "<br><br>" +

                "<a href='JobServlet'>" +
                "View Jobs" +
                "</a>" +

                "</div>" +

                "</div>" +

                "</div>" +

                "</body>" +

                "</html>"
            );

        } else {

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Job Failed</title>" +
                "<link rel='stylesheet' href='style.css'>" +
                "</head>" +

                "<body>" +

                "<div class='auth-container'>" +

                "<div class='auth-box'>" +

                "<h1>Failed to Add Job</h1>" +

                "<p class='auth-subtitle'>" +
                "Something went wrong while adding the job." +
                "</p>" +

                "<div class='page-links'>" +

                "<a href='addJob.jsp'>" +
                "Try Again" +
                "</a>" +

                "<br><br>" +

                "<a href='adminDashboard.jsp'>" +
                "Back to Admin Dashboard" +
                "</a>" +

                "</div>" +

                "</div>" +

                "</div>" +

                "</body>" +

                "</html>"
            );
        }
    }
}