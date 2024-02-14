CREATE SCHEMA users;

create table users.users
(
    id      varchar(255) not null primary key,
    name    varchar(255) not null,
    surname varchar(255) not null
);
