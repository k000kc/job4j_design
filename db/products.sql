create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date timestamp,
	price float
)

insert into type(name) values
	('МОЛОКО'),
	('СЫР'),
	('МЯСО'),
	('ФРУКТЫ'),
	('ОВОЩИ'),
	('ВЫПЕЧКА');

insert into product(name, type_id, expired_date, price) values
	('индейка', 3, '2024-06-29', 600),
	('сыр плавленый', 2, '2024-07-27', 300),
	('сгущенное молоко', 1, '2024-12-31', 250),
	('баранина', 3, '2024-06-20', 600),
	('молоко', 1, '2024-06-28', 180),
	('сыр с плесенью', 2, '2024-09-20', 400),
	('яблоки', 4, '2024-07-10', 90),
	('огурцы', 5, '2024-07-8', 80),
	('пирожок', 6, '2024-06-23', 30)
	('мороженное пломбир', 1, '2024-06-27', 100);

select p.* from product p 
join type t on p.type_id = t.id
where t.name = 'СЫР';

select * from product where name like '%мороженное%';

select * from product where expired_date < current_date;

select * from product
where price = (select max(price) from product);

select t.name, count(p.id)
from type t
join product p
on t.id = p.type_id
group by t.name;

select p.* from product p
join type t on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name, count(p.id)
from type t
join product p
on t.id = p.type_id
group by t.name
having count(p.id) < 10;

select p.name, t.name from product p
join type t on p.type_id = t.id;