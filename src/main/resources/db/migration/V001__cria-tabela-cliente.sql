create table client(
    id SERIAL,
    name VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone VARCHAR(20) NOT NULL,

    PRIMARY KEY(id)
);