package com.jobportal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.jobportal.dao.StudentDAO;
import com.jobportal.model.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();

        Student student = studentDAO.loginStudent(email, password);

        if (student != null) {

            HttpSession session = request.getSession();

            session.setAttribute("student", student);

            response.sendRedirect("dashboard.jsp");

        } else {

            response.setContentType("text/html");

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Login Failed</title>" +
                "<link rel='stylesheet' href='style.css'>" +
                "</head>" +

                "<body>" +

                "<div class='auth-container'>" +

                "<div class='auth-box'>" +

                "<h1>Login Failed</h1>" +

                "<p class='auth-subtitle'>" +
                "Invalid email or password. Please try again." +
                "</p>" +

                "<div class='page-links'>" +

                "<a href='login.jsp'>" +
                "Try Again" +
                "</a>" +

                "<br><br>" +

                "<a href='index.html'>" +
                "← Back to Home" +
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