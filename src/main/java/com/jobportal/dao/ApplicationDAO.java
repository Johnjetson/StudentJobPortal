package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.model.Application;
import com.jobportal.util.DBConnection;

public class ApplicationDAO {

	public boolean applyForJob(Application application) {

	    String checkSql =
	            "SELECT application_id FROM applications "
	          + "WHERE student_id = ? AND job_id = ?";

	    String insertSql =
	            "INSERT INTO applications "
	          + "(student_id, job_id, application_date, status) "
	          + "VALUES (?, ?, ?, ?)";

	    try {

	        Connection con = DBConnection.getConnection();

	        // Check whether student already applied
	        PreparedStatement checkPs =
	                con.prepareStatement(checkSql);

	        checkPs.setInt(1, application.getStudentId());
	        checkPs.setInt(2, application.getJobId());

	        ResultSet rs = checkPs.executeQuery();

	        if (rs.next()) {
	            System.out.println("Student already applied for this job.");
	            return false;
	        }

	        // Insert new application
	        PreparedStatement insertPs =
	                con.prepareStatement(insertSql);

	        insertPs.setInt(1, application.getStudentId());
	        insertPs.setInt(2, application.getJobId());
	        insertPs.setDate(3, application.getApplicationDate());
	        insertPs.setString(4, application.getStatus());

	        int rows = insertPs.executeUpdate();

	        if (rows > 0) {
	            return true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
    public List<Application> getApplicationsByStudent(int studentId) {

        List<Application> applications = new ArrayList<>();

        String sql = "SELECT a.*, j.company_name, j.job_title, j.location "
                + "FROM applications a "
                + "JOIN jobs j ON a.job_id = j.job_id "
                + "WHERE a.student_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Application application = new Application();

                application.setApplicationId(
                        rs.getInt("application_id")
                );

                application.setStudentId(
                        rs.getInt("student_id")
                );

                application.setJobId(
                        rs.getInt("job_id")
                );

                application.setApplicationDate(
                        rs.getDate("application_date")
                );

                application.setStatus(
                        rs.getString("status")
                );
                application.setCompanyName(
                        rs.getString("company_name")
                );

                application.setJobTitle(
                        rs.getString("job_title")
                );

                application.setLocation(
                        rs.getString("location")
                );

                applications.add(application);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applications;
    }
}
