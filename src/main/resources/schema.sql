DROP TABLE IF EXISTS Members;
DROP TABLE IF EXISTS Board;

CREATE TABLE Members(
    id          bigint(20)    NOT NULL AUTO_INCREMENT        PRIMARY KEY,
    member_id   VARCHAR(20)     NOT NULL,
    member_pw   VARCHAR(20)     NOT NULL,
    member_name VARCHAR(20)     NOT NULL
);

CREATE TABLE Board (
    id      bigint(20)    NOT NULL AUTO_INCREMENT        PRIMARY KEY,
    title   varchar(100) not null,
    content  varchar(3000) not null,
    writer varchar(20) not null,
    view_cnt int(11) not null,
    created_at DATE DEFAULT (current_date)
);