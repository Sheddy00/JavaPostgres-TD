import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = System.getenv("DB_URL");
                String userName = System.getenv("DB_USERNAME");
                String password = System.getenv("DB_PASSWORD");
                if (url == null || userName == null || password == null) {
                    throw new IllegalStateException("Please define the url, username and password in the environment variable");
                }
                connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection réussi !!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        getConnection();
    }
}