// users 테이블 생성
CREATE TABLE users (
    unq_id NUMBER GENERATED ALWAYS AS IDENTITY,
    id VARCHAR2(55) NOT NULL,
    password VARCHAR2(75) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    PRIMARY KEY (unq_id)
);

// user_detail 테이블 생성
CREATE TABLE user_detail (
    user_id NUMBER,
    name VARCHAR2(20),
    gender VARCHAR2(1),
    tel VARCHAR2(30),
    birthdate DATE,
    married NUMBER CHECK (married IN (0, 1)),
    occupation VARCHAR2(30),
    nationality VARCHAR2(35),
    FOREIGN KEY (user_id) REFERENCES users(unq_id)
);

// user_residence 테이블 생성
CREATE TABLE user_residence (
    user_id NUMBER,
    postcode NUMBER,
    address VARCHAR2(50),
    detail_address VARCHAR2(75),
    extra_address VARCHAR2(75),
    FOREIGN KEY (user_id) REFERENCES users(unq_id)
);
