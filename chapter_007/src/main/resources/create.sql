create database `trainingdb` ;

use `trainingdb` ;

create table user (
   id serial primary key,
   name varchar(40),
   role_id int references role(id)
);

create table role (
   id serial primary key,
   name varchar(40)
);

create table rules (
   id serial primary key,
   name varchar(1000)
);

create table role_rules (
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id) 
);

create table item (
   id serial primary key,
   name varchar(40),
   user_id int references user(id),
   category_id int references category(id),
   state_id int references state(id)
);

create table category (
  id serial primary key,
  name  varchar(40)
);

create table state (
  id serial primary key,
  name  varchar(40)
);

create table attach (
  id serial primary key,
  name  varchar(40),
  item_id integer references item(id)
);

create table comment(
  id serial primary key,
  name varchar(40),
  item_id int references item(id)
);

insert into category(name) values('big');
insert into category(name) values('small');

insert into role(name) values('director');
insert into role(name) values('not director');

insert into rules (name) values ('you can touch');
insert into rules (name) values ('you cant touch');

insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (2, 2);

insert into state(name) values('new');
insert into state(name) values('old');

insert into user(name, role_id) values('Vladimir', 2);
insert into user(name, role_id) values('Alex', 1);

insert into item(name, user_id, category_id, state_id) values('Apple', 1, 1, 1);
insert into item(name, user_id, category_id, state_id) values('Banana', 2, 2, 2);

insert into comment(name,  item_id) values('good', 1);
insert into comment(name,  item_id) values('bad', 2);