import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database Credentials
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_booking_system";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Private Constructor
    private DBConnection() {
    }

    // Method to Get Database Connection
    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {

            System.out.println("\n========================================");
            System.out.println(" Database Connection Failed!");
            System.out.println("========================================");
            System.out.println("Reason : " + e.getMessage());

            return null;
        }
    }
}