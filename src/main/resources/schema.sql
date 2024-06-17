-- DROP TABLE grades;
-- DROP TABLE users;

TRUNCATE TABLE grades;
TRUNCATE TABLE users;

CREATE TABLE IF NOT EXISTS users (
    username character varying(50)  NOT NULL,
    realname character varying(300) NOT NULL,
    password character varying(300) NOT NULL,
    email character varying(200) NOT NULL,
    enabled character varying(1) NOT NULL DEFAULT 1,
    CONSTRAINT users PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS grades (
    id INT NOT NULL,
    classId VARCHAR(10),
    category VARCHAR(50),
    studentId VARCHAR(10),
    grade INT,
    PRIMARY KEY (id)
);