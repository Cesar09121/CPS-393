package CPS_393_Lab.exercise9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DBConnection {

    public static void main(String[] args) {

        // Checks the command line arguments
        if (args.length < 3) {
            System.out.println("username, password, database");
            return;
        }

        String user = args[0];
        String password = args[1];
        String database = args[2];

        String url = "jdbc:mariadb://localhost:3300/" + database;

        // Query to join all 3 tables and get order details
        String query = "select o.order_no, c.customer_name, c.city, " +
                "s.name as salesman_name, o.purchase_amt, s.commission " +
                "from orders o " +
                "join customer c on o.customer_id = c.customer_id " +
                "join salesman s on o.salesman_id = s.salesman_id";

        // ArrayList to store Sales objects
        ArrayList<Sales> salesList = new ArrayList<>();

        try {
            // Connects to database
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Loops through results and create Sales objects
            while (rs.next()) {
                int orderNumber = rs.getInt("order_no");
                String customerName = rs.getString("customer_name");
                String customerCity = rs.getString("city");
                String salesmanName = rs.getString("salesman_name");
                double amount = rs.getDouble("purchase_amt");
                double commission = rs.getDouble("commission");

                // Creates Sales object and add to list
                Sales sale = new Sales(orderNumber, customerName, customerCity, salesmanName, amount,
                        amount * commission);
                salesList.add(sale);
            }

            // Prints all Sales objects
            System.out.println("\n--- Sales Records ---");
            System.out.printf("%-12s %-20s %-15s %-15s %-12s %-15s%n", "Order No", "Customer", "City", "Salesman",
                    "Amount", "Commission Amt");
            System.out.println(
                    "__________________________________________________________________________________________________________");

            for (Sales s : salesList) {
                System.out.printf("%-12d %-20s %-15s %-15s %-12.2f %-15.2f%n",
                        s.orderNumber, s.customerName, s.customerCity,
                        s.salesmanName, s.amount, s.commissionAmount);
            }

            con.close();

        } catch (SQLException e) {
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
    }
}