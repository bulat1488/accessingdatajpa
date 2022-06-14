create schema accessingdatajpa;

create table accessingdatajpa.customer
(
--    id   INTEGER primary key,
    id   bigserial
        constraint user_pk
            primary key,
    firstName varchar,
    lastName varchar);

create unique index customer_id_uindex
    on accessingdatajpa.customer (id);

