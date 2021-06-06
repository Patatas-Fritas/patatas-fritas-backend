USE patatasFritas;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
    Name VARCHAR(100) PRIMARY KEY,
    Password VARCHAR(100),
    Email VARCHAR(100),
    Roles VARCHAR(100)
);

INSERT INTO Users(`Name`, `Password`, `Email`, `Roles`) VALUES('Géza', 'pass', 'géza@etwas.de', 'ROLE_ADMIN');
INSERT INTO Users(`Name`, `Password`, `Email`, `Roles`) VALUES('Lili', 'pass', 'lili@etwas.de', 'ROLE_USER');