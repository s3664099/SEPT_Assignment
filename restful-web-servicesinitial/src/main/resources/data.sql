DROP TABLE todo;

CREATE TABLE todo (
	id				INT	UNSIGNED	NOT NULL,
	username 	VARCHAR(30),
	description	VARCHAR(1000),
	target_date	TIMESTAMP,
	is_done		BOOLEAN,
	PRIMARY KEY (id)
);

INSERT INTO todo(id, username, description, target_date, is_done)
VALUES(10001, 'sept', 'Learn JPA', sysdate(), false);
INSERT INTO todo(id, username, description, target_date, is_done)
VALUES(10002, 'sept', 'Learn Data JPA', sysdate(), false);
INSERT INTO todo(id, username, description, target_date, is_done)
VALUES(10003, 'sept', 'Learn Microservices', sysdate(), FALSE);
