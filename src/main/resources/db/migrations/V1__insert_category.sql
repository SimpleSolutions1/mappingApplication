create table IF NOT EXISTS category (
                     id int NOT NULL auto_increment primary key,
                     name varchar(255) not null
);
INSERT INTO category (name) values('Animals');
INSERT INTO category (name) values('Furniture');