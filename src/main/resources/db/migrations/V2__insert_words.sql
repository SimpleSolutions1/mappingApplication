create table IF NOT EXISTS word (
    id int NOT NULL auto_increment primary key,
    number int not null,
    word varchar(255) not null,
    category_id int not null
);
alter table if exists public.word add constraint FKcg72hfjghnayce52leswlnxjc foreign key (category_id) references public.category;
INSERT INTO word (number,word,category_id) values(1,'Mouse',1);
INSERT INTO word (number,word,category_id) values(2,'Cat',1);
INSERT INTO word (number,word,category_id) values(3,'Dog',1);
INSERT INTO word (number,word,category_id) values(4,'Elephant',1);
INSERT INTO word (number,word,category_id) values(1,'Chair',2);
INSERT INTO word (number,word,category_id) values(2,'Table',2);
INSERT INTO word (number,word,category_id) values(3,'Cabinet',2);
INSERT INTO word (number,word,category_id) values(4,'Bed',2);