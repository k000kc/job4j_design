insert into roles(name) values('admin');
insert into users(name) values('Andrey');
insert into rules(rights) values('all');
insert into roles_rules(role_id, rule_id) values(1, 1);
insert into categories(name) values('urgent');
insert into states(name) values('in progress');
insert into items(name, user_id, categories_id, states_id) values ('items 1', 1, 1, 1);
insert into comments(comment, item_id) values('tra-la-la', 1);
insert into attachs(file_name, item_id) values('file', 1);