package Repository;

import Model.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperation implements CrudOperations<Subscriber>{
    private Connection connection;
    public SubscriberCrudOperation (Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        String sql = "SELECT * FROM subscriber";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String sex = resultSet.getString("sex");
                String reference = resultSet.getString("reference");
                Subscriber subscriber = new Subscriber(id, userName, password, sex, reference);
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO subscriber (id, userName, password, sex, reference) VALUES (?,?,?,?,?);";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (Subscriber subscriber : toSave) {
                    statement.setInt(1, subscriber.getId());
                    statement.setString(2, subscriber.getUserName());
                    statement.setString(3, subscriber.getPassword());
                    statement.setString(3, subscriber.getSex());
                    statement.setString(5, subscriber.getReference());

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
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO subscriber (id, userName, password, sex, reference) VALUES (?,?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, toSave.getId());
            statement.setString(2, toSave.getUserName());
            statement.setString(3, toSave.getPassword());
            statement.setString(4, toSave.getSex());
            statement.setString(5, toSave.getReference());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        try {
            String sql = "DELETE FROM subscriber WHERE id = ?";
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
