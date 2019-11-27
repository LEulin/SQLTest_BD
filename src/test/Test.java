/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author eulinle_sd2082
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormatter time1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(time1.format(now1));

        for (int i = 0; i < 1001; i++) {
            try {
                Statement stmt = null;
                Class.forName("com.mysql.jdbc.Driver");
                try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eulin", "root", "")) {
                    stmt = (Statement) con.createStatement();
//                ResultSet rs = stmt.executeQuery(null);
                    String sql = "INSERT INTO `sqltest`(`id`, `col1`, `col2`, `col3`, `col4`, `col5`) VALUES (" + i + "," + (i) + "," + (i + 1) + "," + (i + 2) + "," + (i + 3) + "," + (i + 4) + ")";

                    stmt.executeUpdate(sql);
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error!");

            }
        }
        DateTimeFormatter time2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(time2.format(now2));

    }

}
