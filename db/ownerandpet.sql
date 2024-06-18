create table owner(
	id serial primary key,
	name varchar(255)
);

create table pet(
	id serial primary key,
	type varchar(255),
	nick varchar(255),
	owner_id int references owner(id)
);

insert into owner(name) values('Andrey');
insert into owner(name) values('Egor');
insert into owner(name) values('Liza');
insert into owner(name) values('Tanya');

insert into pet(type, nick, owner_id) values('cat', 'Mrack', 1);
insert into pet(type, nick, owner_id) values('dog', 'Bobick', 2);
insert into pet(type, nick, owner_id) values('rabbit', 'Bolick', 3);
insert into pet(type, nick, owner_id) values('cat', 'Lelick', 3);
insert into pet(type, nick, owner_id) values('cat', 'Marusya', 4);

select o.name as Владелец, p.nick as Кличка, p.type as "Тип животного"
from owner o join pet p on p.owner_id = o.id;

select o.name, p.nick, p.type
from owner o join pet p on p.owner_id = o.id;

select o.name as Владелец, p.nick as Кличка, p.type as Питомец
from owner as o join pet as p on p.owner_id = o.id;