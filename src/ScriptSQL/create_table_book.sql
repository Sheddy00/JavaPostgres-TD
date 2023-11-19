/* Before creating table book, you should create the table "author" and the type topic */

CREATE TABLE IF NOT EXISTS book(
    id SERIAL PRIMARY KEY,
    bookName VARCHAR(255) NOT NULL,
    pageNumber INT NOT NULL,
    releaseDate DATE NOT NULL,
    topic topic NOT NULL,
    id_author INT REFERENCES author(id)
);

ALTER SEQUENCE book_id_seq RESTART WITH 1;
ALTER TABLE book ALTER COLUMN id SET DEFAULT nextval(book_id_seq);

INSERT INTO book (bookName, pageNumber, releaseDate, topic, id_author) VALUES
    ('Kertzmann, Kohler and Dickens', 22, '10/1/2023', 'COMEDY', 1);
INSERT INTO book (bookName, pageNumber, releaseDate, topic, id_author) VALUES
    ('Little-Parker', 7, '5/14/2023', 'OTHER', 2);
INSERT INTO book (bookName, pageNumber, releaseDate, topic, id_author) VALUES
    ('Boyer Group', 82, '5/5/2023', 'ROMANCE', 3);

