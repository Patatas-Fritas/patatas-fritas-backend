USE patatasFritas;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
    Name VARCHAR(100) PRIMARY KEY,
    Password VARCHAR(100),
    Email VARCHAR(100),
    Role VARCHAR(100)
);

INSERT INTO Users(`Name`, `Password`, `Email`, `Role`) VALUES('Géza', 'pass', 'géza@etwas.de', 'ADMIN');
INSERT INTO Users(`Name`, `Password`, `Email`, `Role`) VALUES('Lili', 'pass', 'lili@etwas.de', 'USER');