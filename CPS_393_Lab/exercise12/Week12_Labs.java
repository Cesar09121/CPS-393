package CPS_393_Lab.exercise12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

public class Week12_Labs {

    public static void main(String[] args) {

        String user = args[0];
        String password = args[1];
        String database = args[2];

        String url = "jdbc:mariadb://localhost:3300/" + database;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");

            String salesPersonEarning = "select s.name,s.city,s.commission,sum(o.purchase_amt) as TotalEarning from salesman s join orders o on s.salesman_id=o.salesman_id group by s.name,s.city,s.commission;";
            PreparedStatement st = con.prepareStatement(salesPersonEarning);
            ResultSet rs = st.executeQuery();

            ArrayList<SalesPerson> salesPersonList = new ArrayList<>();

            Function<ResultSet, SalesPerson> rsToSalesPerson = resultSet -> {
                try {
                    return new SalesPerson(
                            resultSet.getString("name"),
                            resultSet.getString("city"),
                            resultSet.getDouble("commission"),
                            resultSet.getDouble("TotalEarning"));

                } catch (SQLException e) {
                    throw new RuntimeException("Error mapping ResultSet to SalesPerson", e);
                }

            };
            while (rs.next()) {
                salesPersonList.add(rsToSalesPerson.apply(rs));
            }

            System.out.println("\n***** Total Earnings ******");
            System.out.println("___________________________________");
            System.out.printf("%-20s %-15s%n", "Name", "Total Earning");
            System.out.println("***************************");
            salesPersonList.stream().forEach(s -> System.out.printf("%-20s %-15.2f%n", s.name, s.totalSales));

            System.out.println();
            System.out.println();

            System.out.println("\n***** Total Commissions *****");
            System.out.println("___________________________________");
            System.out.printf("%-20s %-15s%n", "Name", "Total Commission");
            System.out.println("*****************************");
            salesPersonList.stream()
                    .forEach(s -> System.out.printf("%-20s %-15.2f%n", s.name, s.totalSales * s.commission));

        } catch (SQLException e) {
            System.err.println("Database connection failed");
            e.printStackTrace();
        }

    }

}
