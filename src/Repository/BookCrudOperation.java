package Repository;

import Model.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookCrudOperation implements CrudOperations<Books> {
    private Connection connection;
    public BookCrudOperation (Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Books> findAll() throws SQLException {
        List<Books> books = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String bookName = resultSet.getString("bookName");
                int pageNumber = resultSet.getInt("pageNumber");
                String topic = resultSet.getString("topic");
                Date releaseDate = resultSet.getDate("releaseDate");
                String author = resultSet.getString("author");
                Books books1 = new Books(id, bookName, pageNumber, topic, releaseDate, author);
                books.add(books1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Books> saveAll(List<Books> toSave) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO books (bookName, pageNumber, topic, releaseDate, author) VALUES (?,?,?,?,?);";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (Books books : toSave) {
                    statement.setString(1, books.getBookName());
                    statement.setInt(2, books.getPageNumber());
                    statement.setString(3, books.getTopic());
                    statement.setDate(4, books.getRealeseDate());
                    statement.setString(5, books.getAuthor());

                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Books save(Books toSave) {
        String sql = "INSERT INTO books (bookName, pageNumber, topic, releaseDate, author) VALUES (?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, toSave.getBookName());
            statement.setInt(2, toSave.getPageNumber());
            statement.setString(3, toSave.getTopic());
            statement.setDate(4, toSave.getRealeseDate());
            statement.setString(5, toSave.getAuthor());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Books delete(Books toDelete) {
        try {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, toDelete.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                return toDelete;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
