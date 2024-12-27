insert into USER_DETAILS (id, name, birth_date) values (10001, 'Carlos', current_date());
insert into USER_DETAILS (id, name, birth_date) values (10002, 'Pepe', current_date());
insert into USER_DETAILS (id, name, birth_date) values (10003, 'Juan', current_date());
insert into USER_DETAILS (id, name, birth_date) values (10004, 'Mario', current_date());

insert into POST (id, description, user_id) values (20001, 'Post 1', 10001);
insert into POST (id, description, user_id) values (20002, 'Post 2', 10001);
insert into POST (id, description, user_id) values (20003, 'Post 3', 10002);
insert into POST (id, description, user_id) values (20004, 'Post 4', 10003);
