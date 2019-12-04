/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

/**
 *
 * @author eulinle_sd2082
 */
public class DeletewithConnection {

    public static void main(String[] args) {
        LocalTime time1 = java.time.LocalTime.now();
        System.out.println("Time Started:" + time1);

        for (int i = 0; i < 200; i++) {
            try {
                int id = 1;
                Statement stmt = null;
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eulin", "root", "");
                stmt = (Statement) con.createStatement();
                String sql = "DELETE FROM `sqltest` WHERE id='" + id + "'";
                stmt.executeUpdate(sql);
                id++;

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error!");

            }
        }
        LocalTime time2 = java.time.LocalTime.now();
        System.out.println("Time Finished:" + time2);

        System.out.println("The time duration difference is:" + " " + (time2.getSecond() - time1.getSecond()));
    }
}
