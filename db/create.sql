create table roles (
	id serial primary key,
	name text
);

create table categories (
	id serial primary key,
	name text
);

create table states (
	id serial primary key,
	name text
);

create table rules (
	id serial primary key,
	rights text
);

create table users (
	id serial primary key,
	name text,
	role_id int references roles(id)
);

create table roles_rules (
	id serial primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table items (
	id serial primary key,
	name text,
	user_id int references users(id),
	categories_id int references categories(id),
	states_id int references states(id) 
);

create table comments (
	id serial primary key,
	comment text,
	item_id int references items(id)
);

create table attachs (
	id serial primary key,
	file_name text,
	item_id int references items(id)
);