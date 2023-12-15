DROP TABLE IF EXISTS student;
DROP SEQUENCE IF EXISTS SEQUENCE_GENERATOR ;
CREATE SEQUENCE SEQUENCE_GENERATOR START WITH 2 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS person (
                                      id INT PRIMARY KEY ,
                                      name VARCHAR(100),
    age SMALLINT
    );

DELETE FROM person;
INSERT INTO person (id,name, age) VALUES (1, 'Joe', 6);
