package Repository;

import Model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorCrudOperation implements CrudOperations<Author>{
    private Connection connection;
    public AuthorCrudOperation (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM author";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String authorName = resultSet.getString("authorName");
                String sex = resultSet.getString("sex");
                Author author = new Author(id, authorName, sex);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO author (id, authorName, sex) VALUES (?,?,?);";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (Author authors : toSave) {
                    statement.setInt(1, authors.getId());
                    statement.setString(2, authors.getAuthorName());
                    statement.setString(3, authors.getSex());

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
    public Author save(Author toSave) {
        String sql = "INSERT INTO author (id, authorName, sex) VALUES (?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toSave.getId());
            statement.setString(2, toSave.getAuthorName());
            statement.setString(3, toSave.getSex());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        try {
            String sql = "DELETE FROM author WHERE id = ?";
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
