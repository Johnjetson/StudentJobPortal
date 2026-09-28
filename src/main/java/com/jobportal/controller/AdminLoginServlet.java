package com.jobportal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jobportal.dao.AdminDAO;
import com.jobportal.model.Admin;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        AdminDAO adminDAO = new AdminDAO();

        Admin admin =
                adminDAO.loginAdmin(username, password);

        if (admin != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute("admin", admin);

            response.sendRedirect("adminDashboard.jsp");

        } else {

            response.setContentType("text/html");

            response.getWriter().println(
                "<!DOCTYPE html>" +
                "<html>" +

                "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Admin Login Failed</title>" +
                "<link rel='stylesheet' href='style.css'>" +
                "</head>" +

                "<body>" +

                "<div class='auth-container'>" +

                "<div class='auth-box'>" +

                "<h1>Login Failed</h1>" +

                "<p class='auth-subtitle'>" +
                "Invalid admin username or password. Please try again." +
                "</p>" +

                "<div class='page-links'>" +

                "<a href='adminLogin.jsp'>" +
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