package CPS_393_Lab.exercise13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lab13 {

    public static void main(String[] args) {

        String user = args[0];
        String password = args[1];
        String database = args[2];

        String url = "jdbc:mariadb://localhost:3300/" + database;

        // 1.

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");
            String employeeQuery = "select id,name,salary from employees group by id,name,salary";

            PreparedStatement st = con.prepareStatement(employeeQuery);
            ResultSet rs = st.executeQuery();

            List<Employee> employeesList = new ArrayList<Employee>();
            Function<ResultSet, Employee> rsToEmployee = resultSet -> {
                try {
                    return new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("salary"));

                } catch (SQLException e) {
                    throw new RuntimeException("Error mapping ResultSet to Employee", e);
                }
            };
            while (rs.next()) {
                employeesList.add(rsToEmployee.apply(rs));
            }

            // 2.Print a list of all Employees

            System.out.println("Employee List");
            System.out.println();
            employeesList.forEach(System.out::println);
            System.out.println();
            System.out.println();

            // 3. Define a Predicate to filter employees with salary > $50000. Apply this
            // Predicate to filter the List of
            // Employees to get highEarners<Employee> who earn more than $50000.

            Predicate<Employee> greaterThan50000 = n -> n.getSalary() > 50000;
            List<Employee> highEarners = employeesList.stream().filter(greaterThan50000).collect(Collectors.toList());

            // 4. Print a list of highEarners
            System.out.println("High Earners");
            System.out.println();
            highEarners.forEach(System.out::println);
            System.out.println();

            // 5. Write a Function<Employee, Employee> named applyTax to apply a 15% tax
            // reduction to
            // highEarners. The Function should take an Employee and return an Employee with
            // adjusted salary

            Function<Employee, Employee> applyTax = n -> new Employee(n.getId(), n.getName(), n.getSalary() * 0.85);
            System.out.println();

            // 6. Create a Function<Employee, String> named formatSalary to format the
            // salary to 2 decimal places,
            // swith $ attached in the front, for example: $52000.30

            // Function<Employee, String> formatSalary = n -> String.format("$%.2f",
            // n.getSalary());
            Function<Employee, String> formatSalary = n -> n.getName() + ": " + String.format("$%.2f", n.getSalary());
            System.out.println();

            // 7. Now using a stream on the employeeList, filter, apply tax, format and
            // create a list of the type
            // List<Employee> of highEarners with the new salaries

            List<Employee> adjustedHighEarners = employeesList.stream().filter(greaterThan50000).map(applyTax)
                    .collect(Collectors.toList());
            adjustedHighEarners.forEach(s -> System.out.println(formatSalary.apply(s)));
            System.out.println();

            /*
             * 8. Extra: Can you think of a single sequence of stream functions to take the
             * list of employees, apply a
             * 10% tax to those earning less than or equal to $50,000, 15% to those earning
             * above $50000, and neatly
             * format the Employee string to show their names and salaries ?
             * ( Explore partitionBy or groupBy Collectors)
             */

            employeesList.stream().map(e -> e.getSalary() > 50000
                    ? new Employee(e.getId(), e.getName(), e.getSalary() * 0.85)
                    : new Employee(e.getId(), e.getName(), e.getSalary() * 0.90))
                    .map(applyTax)
                    .forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }

    }

}
