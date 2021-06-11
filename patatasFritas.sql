USE patatasFritas;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS words;
DROP TABLE IF EXISTS word;
SET foreign_key_checks = 1;

create TABLE users(
    Username VARCHAR(100) PRIMARY KEY,
    First_Name VARCHAR(100),
    Last_Name VARCHAR(100),
    Password VARCHAR(100),
    Email VARCHAR(100),
    Roles VARCHAR(100)
);

insert into users(`Username`, `First_Name` , `Last_Name`, `Password`, `Email`, `Roles`) values('Géza', 'Géza', 'Amigos', 'pass', 'géza@etwas.de', 'ROLE_ADMIN');
insert into users(`Username`, `First_Name` , `Last_Name`, `Password`, `Email`, `Roles`) values('Lili', 'Lili', 'Kid', 'pass', 'lili@etwas.de', 'ROLE_USER');

create TABLE words(
    id BIGINT AUTO_INCREMENT,
    PRIMARY KEY (id)
);

create TABLE word(
    id BIGINT AUTO_INCREMENT,
    text VARCHAR(100),
    words_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (words_id) REFERENCES words (id)
);



