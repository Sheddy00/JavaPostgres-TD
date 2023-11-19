CREATE TABLE IF NOT EXISTS subscriber(
    id SERIAL PRIMARY KEY,
    userName VARCHAR(250) NOT NULL,
    password VARCHAR(10) NOT NULL,
    sex CHAR(1) NOT NULL,
    reference VARCHAR(50) NOT NULL
);

ALTER SEQUENCE subscriber_id_seq RESTART WITH 1;

INSERT INTO subscriber (userName, password, sex, reference) VALUES
    ('Chelly', 'mU8(=.WdLP', 'F', '253');
INSERT INTO subscriber (userName, password, sex, reference) VALUES
    ('Descartes', 'cM5/4x+4/', 'M', '459');
INSERT INTO subscriber (userName, password, sex, reference) VALUES
    ('Pythagore', 'qK0F7lE', 'M', '187');