DROP database if exists testdb;

CREATE database testdb;

USE testdb;

CREATE TABLE purchase (
id int AUTO_INCREMENT,
item varchar(50) DEFAULT NULL,
value long DEFAULT NULL,
PRIMARY KEY (id)
);
