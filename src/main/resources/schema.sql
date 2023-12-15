DROP TABLE IF EXISTS student;
DROP SEQUENCE IF EXISTS SEQUENCE_GENERATOR ;
CREATE SEQUENCE SEQUENCE_GENERATOR START WITH 6 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS person (
                                    id INT PRIMARY KEY ,
                                    name VARCHAR(100),
    age SMALLINT
    );