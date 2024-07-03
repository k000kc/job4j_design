create table consumers(
	id serial primary key,
	name varchar(255)
);

create table appliances(
	id serial primary key,
	name varchar(255),
	price int
);

create table orders(
	id serial primary key,
	consumer_id int references consumers(id)
);

create table order_detail(
	id serial primary key,
	order_id int references orders(id),
	appliance_id int references appliances(id)
);

insert into consumers(name) values
('Tolya'),
('Tanya'),
('Egor');

insert into appliances(name, price) values
('Refrigerator', 100000),
('Washing Machine', 50000),
('Microwave', 20000),
('Dishwasher', 40000);

insert into orders(consumer_id) values
(1),
(2),
(3),
(1);

insert into order_detail (order_id, appliance_id) values
(1, 1),
(1, 3),
(2, 2),
(3, 1),
(3, 4);

create view show_consumer_name_with_order_amount_more_100000
as
select c.name as consumer_name, sum(a.price) as total_spent
from consumers c
join orders o on c.id = o.consumer_id
join order_detail od on o.id = od.order_id
join appliances a on od.appliance_id = a.id
group by c.name
having sum(a.price) > 100000;

select * from show_consumer_name_with_order_amount_more_100000;