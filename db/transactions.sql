create table items(
	id serial primary key,
	name text,
	count int
);

insert into items(name, count) values
('item 1', 1),
('item 2', 2),
('item 3', 3);