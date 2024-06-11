create table books(
    id serial primary key,
    title varchar(255),
	publication_year int,
    author_id int references authors(id)
);

create table categories(
	id serial primary key,
	category_name varchar(255) 
);

create table books_categories(
	id serial primary key,
	book_id int references books(id),
	category_id int references categories(id)
);