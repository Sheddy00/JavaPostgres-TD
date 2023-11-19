CREATE TABLE IF NOT EXISTS author(
    id SERIAL PRIMARY KEY,
    authorName VARCHAR(200) NOT NULL,
    sex CHAR(1) NOT NULL
);

ALTER SEQUENCE author_id_seq RESTART WITH 1;
ALTER TABLE author ALTER COLUMN id SET DEFAULT nextval(author_id_seq);

CREATE TYPE topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

INSERT INTO author (authorName, sex) VALUES
    (1, 'Shovlar Kevan', 'M');
INSERT INTO author (authorName, sex) VALUES
    (2, 'Lilburn Gamy', 'F');
INSERT INTO author (authorName, sex) VALUES
    (3, 'Suttling Jad', 'M');
