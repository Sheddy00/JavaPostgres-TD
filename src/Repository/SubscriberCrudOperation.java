package Repository;

import Model.Subscriber;

import java.sql.Connection;
import java.util.List;

public class SubscriberCrudOperation implements CrudOperations<Subscriber>{
    private Connection connection;
    public SubscriberCrudOperation (Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Subscriber> findAll() {
        return null;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        return null;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        return null;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        return null;
    }
}
