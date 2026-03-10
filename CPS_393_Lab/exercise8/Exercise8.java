package CPS_393_Lab.exercise8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Exercise8 {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3300/nation";
        String user = "root";
        String password = "cesarle20";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a language name: ");
        String language = sc.nextLine();

        // String query = "select c.name as Country, cl.official from countries c join
        // country_languages cl on c.country_id=cl.country_id join languages l on
        // cl.language_id = l.language_id where l.language =?";
        String query = "select c.name as Country, cl.official from countries c join country_languages cl on c.country_id=cl.country_id join languages l on cl.language_id = l.language_id where l.language =?";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query);
            // 1 is the position of ? in the query
            stmt.setString(1, language);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Connection to MariaDB established successfully!");
            System.out.println("Countries speak " + language);
            // System.out.println("Countries that use " + name);
            System.out.println("-----------------");
            // the SQL as a string
            // String query = "select e.name, e.salary,d.department_name from employees e
            // join departments d on e.department_id = d.id group by
            // e.name,e.salary,d.department_name;";
            // ResultSet rs = stmt.executeQuery(query);
            // while (rs.next()) {
            // System.out.print(rs.getString("name") + "-->" +
            // rs.getString("department_name") + "\n");
            // }
            // } catch (SQLException e) {
            // System.err.println("Database connection failed:");
            // e.printStackTrace();
            // }

            boolean found = false;
            while (rs.next()) {
                System.out.println(rs.getString("Country") + "--> " + rs.getInt("official"));
                found = true;

            }
            if (!found) {
                System.out.println("No countries use " + language);
            }

        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
