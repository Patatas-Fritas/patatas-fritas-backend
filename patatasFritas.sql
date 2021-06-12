USE patatasFritas;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS words;
DROP TABLE IF EXISTS word;
SET foreign_key_checks = 1;

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


DROP TABLE IF EXISTS play_buddy;
DROP TABLE IF EXISTS scores;
SET foreign_key_checks = 1;

create TABLE scores
(
    id BIGINT AUTO_INCREMENT,
    sum INTEGER,
    last_used TIMESTAMP,
    PRIMARY KEY (id)
);

insert into scores (`id`, `sum`, `last_used`) values('1', '15','2020-10-20 10:12:48');
insert into scores (`id`, `sum`, `last_used`) values('2', '10', '2020-10-20 10:12:48');

create TABLE play_buddy
(
    id BIGINT AUTO_INCREMENT,
    score_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (score_id) REFERENCES scores (id)
);

insert into play_buddy(`id`,`score_id`) value ('1', '1');
insert into play_buddy(`id`,`score_id`) value ('2', '2');

create TABLE users
(
    username VARCHAR(100),
    first_Name VARCHAR(100),
    last_Name VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    roles VARCHAR(100),
    score_id BIGINT,
    PRIMARY KEY (username),
    FOREIGN KEY (score_id) REFERENCES scores (id)
);

insert into users  (`username`, `first_Name` , `last_Name`, `password`, `email`, `roles`,`score_id`) values('Géza', 'Géza', 'Amigos', 'pass', 'géza@etwas.de', 'ROLE_ADMIN','1');
insert into users  (`username`, `first_Name` , `last_Name`, `password`, `email`, `roles`,`score_id`) values('Lili', 'Lili', 'Kid', 'pass', 'lili@etwas.de', 'ROLE_USER','2');
