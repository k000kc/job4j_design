create table devices(
id serial primary key,
name varchar(255),
price float);

create table people(
id serial primary key,
name varchar(255));

create table devices_people(
id serial primary key,
device_id int references devices (id),
people_id int references people (id));

insert into devices(name, price)
values ('laptop', 65000), ('smartphone', 30000), 
	('headphones', 4500), ('mouse', 500), ('keyboard', 600);

insert into people(name)
values ('Аня'), ('Ваня'), ('Боря');

insert into devices_people(device_id, people_id)
values (1, 1), (3, 1), (2, 2), (4, 3), (5, 3);

select avg(price) from devices;

select p.name, avg(d.price) 
from people p 
	join devices_people dp on dp.people_id = p.id
	join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) 
from people p 
	join devices_people dp on dp.people_id = p.id
	join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;