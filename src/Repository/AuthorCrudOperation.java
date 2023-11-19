package Repository;

import Model.Author;

import java.sql.Connection;
import java.util.List;

public class AuthorCrudOperation implements CrudOperations<Author>{
    private Connection connection;
    public AuthorCrudOperation (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        return null;
    }

    @Override
    public Author save(Author toSave) {
        return null;
    }

    @Override
    public Author delete(Author toDelete) {
        return null;
    }
}
