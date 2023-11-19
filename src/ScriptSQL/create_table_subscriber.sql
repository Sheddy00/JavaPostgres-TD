CREATE TABLE IF NOT EXISTS subscriber(
    id SERIAL PRIMARY KEY,
    userName VARCHAR(250) NOT NULL,
    password VARCHAR(10) NOT NULL,
    sex CHAR(1) NOT NULL,
    reference VARCHAR(50) NOT NULL
);

ALTER SEQUENCE subscriber_id_seq RESTART WITH 1;
ALTER TABLE subscriber ALTER COLUMN id SET DEFAULT nextval(subscriber_id_seq);

INSERT INTO subscriber (userName, password, sex, reference) VALUES
    (1, 'Chelly', 'mU8(=.WdLPUMN+g%', 'F', '253');
INSERT INTO subscriber (userName, password, sex, reference) VALUES
    (2, 'Descartes', 'cM5/4x+4/kM''hso', 'M', '459');
INSERT INTO subscriber (userName, password, sex, reference) VALUES
    (3, 'Pythagore', 'qK0F7lEi.@"=a', 'M', '187');