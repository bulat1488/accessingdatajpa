create schema accessingdatajpa;

create table accessingdatajpa.customer
(
--    id   INTEGER primary key,
    id   bigserial
        constraint user_pk
            primary key,
    firstName varchar,
    lastName varchar);

create table accessingdatajpa.clickorders
(
    --    id   INTEGER primary key,
    id   bigserial
             primary key,
    goods varchar,
    comment varchar);


create unique index customer_id_uindex
    on accessingdatajpa.customer (id);

