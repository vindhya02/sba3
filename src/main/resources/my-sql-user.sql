
CREATE DATABASE invDb;

USE invDb;


CREATE TABLE users(
	userid int primary key,
	firstname varchar(30) not null,
    lastname varchar(30) not null,
	email varchar(30) not null,
    mobile varchar(20) not null
);

INSERT INTO users VALUES
(101,"Jenny", "Potter", "Jenny@gmail.com","9087654343"),
(102,"Penny", "Potter","penny@gmail.com","9087654343"),
(103,"Benny", "Potter","Benny@gmail.com","9087654343");

select * from users;