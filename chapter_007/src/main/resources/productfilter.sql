create database `productdb` ;

use `productdb` ;

create table product (
id serial primary key,
name varchar(40),
type_name varchar(40) references type(name),
expired_date timestamp,
price int
);

create table type  (
id serial primary key,
name varchar(40)
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');

insert into product (name, type_name, expired_date, price) values ('твердый', 'СЫР', '2019-10-01 21:45:00', 900);
insert into product (name, type_name, expired_date, price) values ('мягкий', 'СЫР', '2019-09-13 21:45:00', 600);
insert into product (name, type_name, expired_date, price) values ('полутвердый', 'СЫР', '2019-10-01 21:45:00', 750);

insert into product (name, type_name, expired_date, price) values ('творог', 'МОЛОКО', '2019-10-01 21:45:00', 50);
insert into product (name, type_name, expired_date, price) values ('йогурт', 'МОЛОКО', '2019-09-13 21:45:00', 40);
insert into product (name, type_name, expired_date, price) values ('сметана', 'МОЛОКО', '2019-10-01 21:45:00', 60);
insert into product (name, type_name, expired_date, price) values ('мороженое', 'МОЛОКО', '2019-09-13 21:45:00', 30);

select * from product where type_name = 'СЫР';

select * from product where name LIKE '%мороженое%';

select * from product where current_date + '1 month' < expired_date;

select * from product where price in(select max(price) from product);

select count(type_name) from product where type_name = 'СЫР';
select count(type_name) from product where type_name = 'МОЛОКО';

select * from product where type_name = 'СЫР' or type_name = 'МОЛОКО';

select count(*), t.name from product as p 
inner join type as t on t.name = p.type_name 
 group by t.name having count(type_name) < 10;

select p.name, t.name from product as p 
inner join type as t on t.name = p.type_name;