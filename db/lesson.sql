CREATE TABLE customers
(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers (first_name, last_name, age, country) values 
('A', 'A', 30, 'Russia'),
('B', 'B', 25, 'USA'),
('C', 'C', 35, 'China');

select first_name, last_name, age 
from customers	where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders (amount, customer_id) 
values (5, 2), (3, 3);

select first_name, last_name from customers
where customers.id not in (select customer_id from orders);