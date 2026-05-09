--liquibase formatted sql

--changeset pavel:create-persons
create table persons (
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    age INT NOT NULL,
    phone_number TEXT,
    city_of_living TEXT,
    PRIMARY KEY(name, surname, age)
);

--rollback drop table persons;
