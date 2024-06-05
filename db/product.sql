create table product(
	id serial primary key,
	name varchar(255),
	price int,
	available bool
);
insert into product(name, price, available) values('телевизор', 30000, true);
update product set name = 'принтер';
delete from product;