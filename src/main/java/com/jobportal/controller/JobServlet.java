package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        JobDAO jobDAO = new JobDAO();

        List<Job> jobs = jobDAO.getAllJobs();

        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("jobs.jsp")
               .forward(request, response);
    }
}
