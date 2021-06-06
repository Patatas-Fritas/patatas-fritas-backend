USE patatasFritas;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
    Username VARCHAR(100) PRIMARY KEY,
    First_Name VARCHAR(100),
    Last_Name VARCHAR(100),
    Password VARCHAR(100),
    Email VARCHAR(100),
    Roles VARCHAR(100)
);

INSERT INTO Users(`Username`, `First_Name` , `Last_Name`, `Password`, `Email`, `Roles`) VALUES('Géza', 'Géza', 'Amigos', 'pass', 'géza@etwas.de', 'ROLE_ADMIN');
INSERT INTO Users(`Username`, `First_Name` , `Last_Name`, `Password`, `Email`, `Roles`) VALUES('Lili', 'Lili', 'Kid', 'pass', 'lili@etwas.de', 'ROLE_USER');