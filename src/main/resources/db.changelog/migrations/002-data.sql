--liquibase formatted sql

--changeset pavel:insert-persons
INSERT INTO persons VALUES
    ('Ivan', 'Ivanov', 30, '+79991234567', 'MOSCOW'),
    ('Petr', 'Petrov', 25, '+79997654321', 'PERM'),
    ('Anna', 'Sidorova', 28, NULL, 'MOSCOW');

--rollback delete from persons;