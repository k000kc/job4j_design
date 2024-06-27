--1. Создать таблицы и заполнить их начальными данными
create table departments(
    id serial primary key,
    name varchar(255));

create table  employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id));

insert into departments(name) values 
	('department 1'),
	('department 2'),
	('department 3'),
	('department 4'),
	('department 5');

insert into employees(name, department_id) values 
	('employee 1', 1),
	('employee 2', 1),
	('employee 3', 3),
	('employee 4', 4),
	('employee 5', 5);

--2. Выполнить запросы с left, right, full, cross соединениями
select d.name, e.name from departments d
left join employees e on d.id = e.department_id;

select d.name, e.name from departments d
right join employees e on d.id = e.department_id;

select d.name, e.name from departments d
full join employees e on d.id = e.department_id;

select d.name, e.name from departments d
cross join employees e;

--3. Используя left join найти департаменты, у которых нет работников
select d.name, e.name from departments d
left join employees e on d.id = e.department_id
where e.id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный). 

select d.name, e.name from departments d
left join employees e on d.id = e.department_id;

select d.name, e.name from employees e
right join departments d on d.id = e.department_id;


--5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары. Исключите дублирование пар вида Вася-Маша и Маша-Вася.

create table teens(
	id serial primary key,
	name varchar(255),
	gender char 
);

insert into teens(name, gender) values
	('Маша', 'Ж'),
	('Миша', 'М'),
	('Таня', 'Ж'),
	('Катя', 'Ж'),
	('Толя', 'М');

select t1.name, t2.name from teens t1
	cross join teens t2 
	where t1.gender != t2.gender;