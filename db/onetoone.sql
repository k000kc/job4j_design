create table users(
    id serial primary key,
    name varchar(255)
);

create table arms(
    id serial primary key,
    arm_name varchar(255),
	ip_address varchar(15),
    user_id int references users(id) unique
);