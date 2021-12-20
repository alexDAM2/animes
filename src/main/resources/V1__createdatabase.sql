CREATE TABLE animes(
animeid uuid,
name text,
description text,
type text,
yeaar int,
image text
);

CREATE TABLE users(
userid uuid,
username text,
userpassword text
);

CREATE TABLE favorite(
userid uuid REFERENCES users(userid) ON DELETE CASCADE,
movieid uuid REFERENCES animes(animeid) ON DELETE CASCADE,
PRIMARY KEY (userid, animeid)
);

INSERT INTO users values ('user', 'hola');
INSERT INTO animes values('Death note', 'SI', 'seinen', 2006, 'a');

INSERT INTO favorite values
    ((SELECT userid FROM users WHERE username = 'user'), (SELECT animeid FROM animes WHERE name = 'Death note'));