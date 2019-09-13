create database `productdb` ;

use `productdb` ;

create table product (
id serial primary key,
name varchar(40),
type_id int references type(id),
expired_date timestamp,
price int
);

create table type  (
id serial primary key,
name varchar(40)
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');

insert into product (name, type_id, expired_date, price) values ('твердый', 1, '2019-10-01 21:45:00', 900);
insert into product (name, type_id, expired_date, price) values ('мягкий', 1, '2019-09-13 21:45:00', 600);
insert into product (name, type_id, expired_date, price) values ('полутвердый', 1, '2019-10-01 21:45:00', 750);

insert into product (name, type_id, expired_date, price) values ('творог', 2, '2019-10-01 21:45:00', 50);
insert into product (name, type_id, expired_date, price) values ('йогурт', 2, '2019-09-13 21:45:00', 40);
insert into product (name, type_id, expired_date, price) values ('сметана', 2, '2019-10-01 21:45:00', 60);
insert into product (name, type_id, expired_date, price) values ('мороженое', 2, '2019-09-13 21:45:00', 30);

select * from product where type_id = 1;

select * from product where name LIKE '%мороженое%';

select * from product where expired_date between '2019-10-01 21:45:00' and '2019-10-31 21:45:00';	

select * from product where price in(select max(price) from product);

select count(type_id) from product where type_id = 1;
select count(type_id) from product where type_id = 2;

select * from product where type_id = 1 or type_id = 2;

select count(*), t.name from product as p 
inner join type as t on t.id = p.type_id 
 group by t.name having count(type_id) < 10;

select p.name, t.name from product as p 
inner join type as t on t.id = p.type_id;