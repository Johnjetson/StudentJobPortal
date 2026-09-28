package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jobportal.dao.ApplicationDAO;
import com.jobportal.model.Application;
import com.jobportal.model.Student;

@WebServlet("/MyApplicationsServlet")
public class MyApplicationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Student student =
                (Student) session.getAttribute("student");

        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        ApplicationDAO applicationDAO =
                new ApplicationDAO();

        List<Application> applications =
                applicationDAO.getApplicationsByStudent(
                        student.getStudentId()
                );

        request.setAttribute("applications", applications);

        request.getRequestDispatcher("myApplications.jsp")
               .forward(request, response);
    }
}