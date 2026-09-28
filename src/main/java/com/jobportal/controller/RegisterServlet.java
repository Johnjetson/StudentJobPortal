package com.jobportal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jobportal.dao.StudentDAO;
import com.jobportal.model.Student;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword =
                request.getParameter("confirmPassword");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        int graduationYear =
                Integer.parseInt(request.getParameter("graduationYear"));
        
        if (!password.equals(confirmPassword)) {

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Passwords do not match!</h2>"
            );

            response.getWriter().println(
                "<a href='register.jsp'>Try Again</a>"
            );

            return;
        }

        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        student.setPhone(phone);
        student.setDepartment(department);
        student.setGraduationYear(graduationYear);

        StudentDAO studentDAO = new StudentDAO();

        boolean result = studentDAO.registerStudent(student);

        if (result) {

            response.sendRedirect("login.jsp");

        } else {

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Registration Failed!</h2>"
            );

            response.getWriter().println(
                "<a href='register.jsp'>Try Again</a>"
            );
        }
    }
}