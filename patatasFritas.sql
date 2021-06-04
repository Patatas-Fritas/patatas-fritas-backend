USE patatasFritas;

DROP TABLE IF EXISTS users;

CREATE TABLE users(Id BIGINT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(100), Password VARCHAR(100), Email VARCHAR(100), Role VARCHAR(100));

INSERT INTO Users(`Id`, `Name`, `Password`, `Email`, `Role`) VALUES('1', 'Géza', 'pass', 'géza@etwas.de', 'ADMIN');
INSERT INTO Users(`Id`, `Name`, `Password`, `Email`, `Role`) VALUES('2', 'Lili', 'pass', 'lili@etwas.de', 'USER');