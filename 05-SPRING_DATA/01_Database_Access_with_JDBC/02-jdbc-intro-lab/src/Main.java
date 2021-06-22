import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "diablo";
    public static final String SQL_QUERY =
            "SELECT u.user_name, u.first_name, u.last_name, COUNT(ug.game_id) AS games_count " +
            "FROM users AS u " +
            "JOIN users_games AS ug " +
            "ON u.id = ug.user_id " +
            "GROUP BY u.id";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. Read params
        System.out.println("Enter user or press <Enter> for 'root': ");
        String user = reader.readLine().trim();
        user = user.length() > 0? user : "root";

        System.out.println("Enter your MyQSL password: ");
        String password = reader.readLine().trim();

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

        try(Connection connection = DriverManager.getConnection(DB_URL + DB_NAME, props)) {
            System.out.printf("DB connection created successfully: %s%s%n", DB_URL, DB_NAME);

            // 4. Create prepared statement
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_QUERY);

            // 5. Print results
            while (rs.next()){
                System.out.printf("| %-20s | %-15s | %-15s | %5d |%n",
                        rs.getString("user_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("games_count")
                );
            }
        } catch (SQLException throwables) {
            System.err.printf("Can not connect to DB: %s", DB_URL + DB_NAME);
            System.exit(0);
        }
    }
}
