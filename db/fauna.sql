create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values
('Кенгуру', 5500, '1770-08-22'),
('Слон', 20000, '1827-01-01'),
('Панда', 9000, '1869-03-11'),
('Лиса', 3700, '1758-01-01'),
(deep-sea fish', 1000, '700-01-04');

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';