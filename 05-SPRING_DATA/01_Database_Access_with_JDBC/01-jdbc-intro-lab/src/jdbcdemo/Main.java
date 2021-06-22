package jdbcdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/soft_uni";
    public static String SQL_QUERY = "SELECT employee_id, `CONCAT`(first_name, ' ',  last_name) AS full_name, salary FROM employees WHERE salary > ?";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read params
        System.out.println("Enter user or press <Enter> for 'root': ");
        String user = reader.readLine().trim();
        user = user.length() > 0? user : "root";

        System.out.println("Enter your MyQSL password: ");
        String password = reader.readLine().trim();

        System.out.println("Enter salary over 50000: ");
        String salary = reader.readLine().trim();

        // 2. Load DB driver jdbc
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.printf("Database Driver '%s%n' not found", DB_DRIVER);
            System.exit(0);
        }
        System.out.println("DB Driver loaded successfully");

        // 3. Connect to DB using The try-with-resources Statement /java.lang.AutoCloseable/
        Properties props = new Properties(); // Key-Value Set
        props.setProperty("user", user);
        props.setProperty("password", password);

        try(Connection connection = DriverManager.getConnection(DB_URL, props)) {
            System.out.printf("DB connection created successfully: %s%n", DB_URL);

        // 4. Create prepared statement
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);

        // 5. Execute prepared statement with set parameter
            ps.setDouble(1, Double.parseDouble(salary));
            ResultSet rs = ps.executeQuery();

        // 6. Print results
            while (rs.next()){
                System.out.printf("| %5d | %-15.15s | %10.2f |%n",
                        rs.getLong("employee_id"),
                        rs.getString("full_name"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException throwables) {
            System.err.printf("Can not connect to DB: %s", DB_URL);
            System.exit(0);
        }
    }
}

// The try-with-resources statement is
// a try statement that declares one or more resources.
// A resource is an object that must be closed after the program is finished with it. (ex. Connection, Statement, BufferedReader)
// The try-with-resources statement ensures that each resource is closed at the end of the statement.
// Any object that implements java.lang.AutoCloseable,
// which includes all objects which implement java.io.Closeable,
// can be used as a resource.
