create table if not exists items (
   id serial primary key,
   name varchar(40),
   descr varchar(300),
   time long
);