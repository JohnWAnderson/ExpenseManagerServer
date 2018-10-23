INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO dates(thedate) VALUES(null);

INSERT INTO recurring(recurring, recurringsize) VALUES(false, 'none');
INSERT INTO recurring(recurring, recurringsize) VALUES(true, 'daily');
INSERT INTO recurring(recurring, recurringsize) VALUES(true, 'weekly');
INSERT INTO recurring(recurring, recurringsize) VALUES(true, 'biweekly');
INSERT INTO recurring(recurring, recurringsize) VALUES(true, 'monthly');
