create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values
('Hatchback'),
('liftback'),
('sedan'),
('coupe');

insert into car_engines(name) values
('v6'),
('v8'),
('electric'),
('hybrid');

insert into car_transmissions(name) values
('manual'),
('automatic');

insert into cars(name, body_id, engine_id, transmission_id) values
('camry', 1, 1, 2),
('corolla', 3, 2, 2),
('rio', 3, 2, 2),
('trailer');


-- Вывести список всех машин и все привязанные к ним детали.
select c.name, cb.name, ce.name, ct.name 
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id;

-- Вывести кузова, которые не используются НИ в одной машине.
select cb.name 
from car_bodies cb
left join cars c on cb.id = c.body_id
where c.body_id is null;

-- Вывести двигатели, которые не используются НИ в одной машине.
select ce.name 
from car_engines ce
left join cars c on ce.id = c.engine_id
where c.engine_id is null;

-- Вывести коробки передач, которые не используются НИ в одной машине.
select ct.name 
from car_transmissions ct
left join cars c on ct.id = c.transmission_id
where c.transmission_id is null;