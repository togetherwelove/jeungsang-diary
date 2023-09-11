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

// BOARDS 테이블 생성
CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE boards (
    unq_id NUMBER DEFAULT board_seq.NEXTVAL,
    user_id NUMBER,
    title VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    hit NUMBER DEFAULT 0,
    write_date DATE DEFAULT SYSDATE,

    PRIMARY KEY (unq_id),
    FOREIGN KEY (user_id) REFERENCES users(unq_id)
);

// COMMENTS 테이블 생성
CREATE TABLE comments (
    board_id NUMBER,
    user_id NUMBER,
    content CLOB,
    write_date DATE DEFAULT SYSDATE,

    FOREIGN KEY (board_id) REFERENCES boards(unq_id),
    FOREIGN KEY (user_id) REFERENCES users(unq_id)
);

// FILES 테이블 생성
CREATE TABLE files (
    board_id NUMBER,
    original_name VARCHAR2(255),
    stored_name VARCHAR2(255),
    file_size NUMBER,

    FOREIGN KEY (board_id) REFERENCES boards(unq_id)
);

// CELLS 테이블 생성
CREATE SEQUENCE cell_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE cells (
    unq_id NUMBER DEFAULT cell_seq.NEXTVAL,
    post_date DATE NOT NULL,
    content CLOB,
    write_date DATE DEFAULT SYSDATE,

    PRIMARY KEY (unq_id)
);

// CATEGORYS 테이블 생성
CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE categorys (
    unq_id NUMBER DEFAULT category_seq.NEXTVAL,
    name VARCHAR2(255),
    img_url VARCHAR2(255),

    PRIMARY KEY (unq_id)
);

// cell & category 교차 테이블 생성
CREATE TABLE category_cells (
    category_id NUMBER,
    cell_id NUMBER,

    PRIMARY KEY (category_id, cell_id),
    
    FOREIGN KEY (category_id) REFERENCES categorys(unq_id),
    FOREIGN KEY (cell_id) REFERENCES cells(unq_id)
);

---- 수정
-- comments 테이블 수정
-- 고유 번호 생성
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE comments 
ADD unq_id NUMBER DEFAULT comment_seq.NEXTVAL PRIMARY KEY;

-- users 테이블 수정
ALTER TABLE users MODIFY id VARCHAR2(255) UNIQUE;
ALTER TABLE users MODIFY email VARCHAR2(255) UNIQUE;

-- files 테이블에 upload_date 컬럼 추가
ALTER TABLE files 
ADD (upload_date DATE DEFAULT SYSDATE);