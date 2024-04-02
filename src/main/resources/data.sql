INSERT INTO CLIENT (id, name) VALUES(1, 'test1');
INSERT INTO CLIENT (id, name) VALUES(2, 'test2');
INSERT INTO CLIENT (id, name) VALUES(3, 'test3');

INSERT INTO CONTACT (id, type, value_text, client_id) VALUES(1, 'EMAIL', 'test1@mail.ru', 1);
INSERT INTO CONTACT (id, type, value_text, client_id) VALUES(2, 'EMAIL', 'test2@mail.ru', 2);
INSERT INTO CONTACT (id, type, value_text, client_id) VALUES(3, 'EMAIL', 'test3@mail.ru', 3);

INSERT INTO CONTACT (id, type, value_text, client_id) VALUES(4, 'PHONE', '555-555', 1);