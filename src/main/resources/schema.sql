DROP TABLE IF EXISTS Members;

CREATE TABLE Members
(
    id          IDENTITY        PRIMARY KEY,
    member_id   VARCHAR(20)     NOT NULL,
    member_pw   VARCHAR(20)     NOT NULL,
    member_name VARCHAR(20)     NOT NULL
);