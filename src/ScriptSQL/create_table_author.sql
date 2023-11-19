CREATE TABLE IF NOT EXISTS author(
    id SERIAL PRIMARY KEY,
    authorName VARCHAR(200) NOT NULL,
    sex CHAR(5) NOT NULL
);

ALTER SEQUENCE author_id_seq RESTART WITH 1;

CREATE TYPE topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

INSERT INTO author (authorName, sex) VALUES
    ('Shovlar Kevan', 'M');
INSERT INTO author (authorName, sex) VALUES
    ('Lilburn Gamy', 'F');
INSERT INTO author (authorName, sex) VALUES
    ('Suttling Jad', 'M');
