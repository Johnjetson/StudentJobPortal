package com.jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.model.Admin;
import com.jobportal.util.DBConnection;

public class AdminDAO {

    public Admin loginAdmin(String username, String password) {

        String sql =
                "SELECT * FROM admin WHERE username = ? AND password = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Admin admin = new Admin();

                admin.setAdminId(
                        rs.getInt("admin_id")
                );

                admin.setUsername(
                        rs.getString("username")
                );

                admin.setPassword(
                        rs.getString("password")
                );

                return admin;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
