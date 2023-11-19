package Repository;

import Model.Books;

import java.awt.print.Book;
import java.sql.Connection;
import java.util.List;

public class BookCrudOperation implements CrudOperations<Books> {
    private Connection connection;
    public BookCrudOperation (Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Books> findAll() {
        return null;
    }

    @Override
    public List<Books> saveAll(List<Books> toSave) {
        return null;
    }

    @Override
    public Books save(Books toSave) {
        return null;
    }

    @Override
    public Books delete(Books toDelete) {
        return null;
    }

}
