create table products
(
	id serial primary key,
    	name varchar(50),
    	producer varchar(50),
    	count integer default 0,
    	price integer
);

/*
Триггер должен срабатывать после вставки данных, 
для любого товара и просто насчитывать налог на товар 
(нужно прибавить налог к цене товара). Действовать он 
должен не на каждый ряд, а на запрос (statement уровень)
*/

create or replace function tax_after()
returns trigger as $$
BEGIN
	update products
	set price = price + price * 0.13
	where id = (select id from inserted);
	return new;
END;
$$
LANGUAGE 'plpgsql';


create trigger trigger_after
after insert on products
referencing new table as inserted
for each statement
execute function tax_after();

/*
Триггер должен срабатывать до вставки данных и насчитывать 
налог на товар (нужно прибавить налог к цене товара). 
Здесь используем row уровень.
*/

create or replace function tax_before()
returns trigger as $$
BEGIN
	new.price := new.price + new.price * 0.13;
	RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

create or replace trigger tax_trigger_before
before insert on products
for each row
execute function tax_before(); 

/*
Нужно написать триггер на row уровне, который сразу после вставки продукта в таблицу products, 
будет заносить имя, цену и текущую дату в таблицу history_of_price
*/

create table history_of_price
(
	id serial primary key,
    	name varchar(50),
    	price integer,
    	date timestamp
);

create or replace function write_history()
returns trigger as $$
BEGIN
	insert into history_of_price(name, price, date)
	values(new.name, new.price, current_timestamp);
	return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger insert_trigger_after
after insert on products
for each row
execute function write_history();
