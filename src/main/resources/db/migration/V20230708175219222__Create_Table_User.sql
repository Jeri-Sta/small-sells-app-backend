create table users (
    id bigint PRIMARY KEY NOT NULL,
    email varchar(255) UNIQUE,
    password varchar(255),
    token varchar(255),
    role varchar(50) check (role in ('USER','ADMIN','LEADER'))
    );

create sequence users_seq start with 1 increment by 50;