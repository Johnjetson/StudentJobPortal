package com.jobportal.controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jobportal.dao.ApplicationDAO;
import com.jobportal.model.Application;
import com.jobportal.model.Student;

@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html");

        // Get job ID from jobs.jsp
        int jobId = Integer.parseInt(
                request.getParameter("jobId")
        );

        // Get logged-in student
        HttpSession session = request.getSession();

        Student student =
                (Student) session.getAttribute("student");
        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        // Create application object
        Application application = new Application();

        application.setStudentId(student.getStudentId());
        application.setJobId(jobId);
        application.setApplicationDate(
                new Date(System.currentTimeMillis())
        );
        application.setStatus("Applied");

        // Save application
        ApplicationDAO applicationDAO =
                new ApplicationDAO();

        boolean result =
                applicationDAO.applyForJob(application);

        if (result) {

        	response.getWriter().println(
        	        "<!DOCTYPE html>" +
        	        "<html>" +
        	        "<head>" +
        	        "<meta charset='UTF-8'>" +
        	        "<title>Application Submitted</title>" +
        	        "<link rel='stylesheet' href='style.css'>" +
        	        "</head>" +
        	        "<body>" +

        	        "<div class='auth-container'>" +

        	        "<div class='auth-box'>" +

        	        "<h1>Application Submitted!</h1>" +

        	        "<p class='auth-subtitle'>" +
        	        "Your application has been successfully submitted." +
        	        "</p>" +

        	        "<div class='page-links'>" +

        	        "<a href='MyApplicationsServlet'>" +
        	        "View My Applications" +
        	        "</a>" +

        	        "<br><br>" +

        	        "<a href='JobServlet'>" +
        	        "Back to Available Jobs" +
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
        	        "<title>Already Applied</title>" +
        	        "<link rel='stylesheet' href='style.css'>" +
        	        "</head>" +
        	        "<body>" +

        	        "<div class='auth-container'>" +

        	        "<div class='auth-box'>" +

        	        "<h1>Already Applied</h1>" +

        	        "<p class='auth-subtitle'>" +
        	        "You have already applied for this job." +
        	        "</p>" +

        	        "<div class='page-links'>" +

        	        "<a href='MyApplicationsServlet'>" +
        	        "View My Applications" +
        	        "</a>" +

        	        "<br><br>" +

        	        "<a href='JobServlet'>" +
        	        "Back to Available Jobs" +
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
