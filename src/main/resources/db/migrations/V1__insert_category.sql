create table IF NOT EXISTS category (
                     id int NOT NULL auto_increment primary key,
                     name varchar(255) not null
);
INSERT INTO category (id,name) values(1,'Animals');
INSERT INTO category (id,name) values(2,'Furniture');