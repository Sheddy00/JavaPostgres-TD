import Model.Books;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                System.out.println("Connection Successfully !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    private static <BooksCrudOperations> void testBooksOperations(BooksCrudOperations booksCrudOperations) {
        // Créez des objets Books pour les tests
        List<Books> booksToSave = new ArrayList<>();
        booksToSave.add(new Books("Book1", 200, "COMEDY", "2023-01-01", "Author1"));
        booksToSave.add(new Books("Book2", 150, "ROMANCE", "2023-02-01", "Author2"));

        // Testez l'opération saveAll
        List<Books> savedBooks = booksCrudOperations.saveAll(booksToSave);
        System.out.println("Saved Books: " + savedBooks);

        // Testez l'opération findAll
        List<Books> allBooks = booksCrudOperations.findAll();
        System.out.println("All Books: " + allBooks);
    }
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        getConnection();
    }
}