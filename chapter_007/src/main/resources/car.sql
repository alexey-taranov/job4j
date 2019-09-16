create database `carbase` ;

use `carbase` ;

create table car (
id serial primary key,
name varchar(40),
bodywork_id int not null references bodywork(id) ,
transmission_id int not null references transmission(id),
engine_id int not null references engine(id)
);

create table bodywork (
id serial primary key,
name varchar(40)
);

create table transmission (
id serial primary key,
name varchar(40)
);

create table engine (
id serial primary key,
name varchar(40)
);

insert into bodywork (name) values ('купе');
insert into bodywork (name) values ('седан');
insert into bodywork (name) values ('внедорожник');

insert into transmission (name) values ('ручная');
insert into transmission (name) values ('автоматическая');

insert into engine (name) values ('газовый');
insert into engine (name) values ('дизельный');
insert into engine (name) values ('бензиновый');

insert into car (name, bodywork_id, transmission_id, engine_id) values ('Porshe', 1, 2, 3);
insert into car (name, bodywork_id, transmission_id, engine_id) values ('BMW', 2, 2, 3);
insert into car (name, bodywork_id, transmission_id, engine_id) values ('Toyota', 2, 2, 1);

/*1. Вывести список всех машин и все привязанные к ним детали.*/
select c.name, b.name, t.name, e.name from car as c
inner join bodywork as b on c.bodywork_id = b.id
inner join engine as e on c.engine_id = e.id
inner join transmission as t on c.transmission_id = t.id;

/*2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.*/
select b.name from car as c right outer join bodywork as b on c.bodywork_id = b.id where c.name is null;

select t.name from car as c right outer join transmission as t on c.transmission_id = t.id where c.name is null;

select e.name from engine as e left outer join car as c on c.engine_id = e.id where c.name is null;