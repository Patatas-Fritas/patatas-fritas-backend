USE patatasFritas;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS words;
DROP TABLE IF EXISTS word;
DROP TABLE IF EXISTS buddy;
DROP TABLE IF EXISTS play_buddy;
DROP TABLE IF EXISTS scores;
DROP TABLE IF EXISTS game_type;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS hotspots;
DROP TABLE IF EXISTS rectangles;
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

create TABLE rectangles
(
    id BIGINT AUTO_INCREMENT,
    x INTEGER,
    y INTEGER,
    width INTEGER,
    height INTEGER,
    PRIMARY KEY (id)
);

create TABLE hotspots
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    image VARCHAR (100),
    rectangles_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (rectangles_id) REFERENCES rectangles (id)
);

create TABLE buddy
(
    id BIGINT AUTO_INCREMENT,
    type varchar(20),
    PRIMARY KEY (id)
);

insert into buddy (`id`, `type`) values
('1', 'dino'),
('2', 'cat'),
('3', 'dog'),
('4', 'fox'),
('5', 'mink');

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
    id BIGINT AUTO_INCREMENT NOT NULL,
    last_feeding TIMESTAMP,
    name varchar(50),
    buddy_id BIGINT,
    score_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (buddy_id) REFERENCES buddy (id),
    FOREIGN KEY (score_id) REFERENCES scores (id)
);

insert into play_buddy(`id`,`last_feeding`, `name`,`buddy_id`, `score_id`)
values
('1', '2021-06-20 10:12:48', 'Gazsika', '2', '1'),
('2', '2021-06-20 10:12:48', 'Bazsika', '3', '2');

create TABLE users
(
    username VARCHAR(100),
    first_Name VARCHAR(100),
    last_Name VARCHAR(100),
    password VARCHAR(100),
    email VARCHAR(100),
    roles VARCHAR(100),
    play_buddy_id BIGINT,
    score_id BIGINT,
    PRIMARY KEY (username),
    FOREIGN KEY (play_buddy_id) REFERENCES play_buddy (id),
    FOREIGN KEY (score_id) REFERENCES scores (id)
);

insert into users  (`username`, `first_Name` , `last_Name`, `password`, `email`, `roles`, `play_buddy_id`, `score_id`)
values
('Géza', 'Géza', 'Amigos', 'pass', 'géza@etwas.de', 'ROLE_ADMIN', '1', '1'),
('Lili', 'Lili', 'Kid', 'pass', 'lili@etwas.de', 'ROLE_USER', '2', '2');

create table game_type
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    type VARCHAR (100),
    description VARCHAR (100),
    PRIMARY KEY (id)
);

insert into game_type (`id`, `type`, `description`)
values
('1','Hangman', 'Hangman description'),
('2','Hotspot', 'Hotspot description');

create table games
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    title VARCHAR (100),
    game_type_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (game_type_id) REFERENCES game_type (id)
);
