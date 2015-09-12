-- Users
insert into user (id,name, password) values(1, 'jesus', 'jesus');


-- Languages
insert into language(id, code, name) values (1, 'UK', 'English');
insert into language(id, code, name) values (2, 'ES', 'Spanish');

-- Types
insert into word_type(id, code, name) values (1, 'SM', 'Word');
insert into word_type(id, code, name) values (2, 'FW', 'Phrasal Verb');
insert into word_type(id, code, name) values (3, 'FE', 'Fixed Expression');
insert into word_type(id, code, name) values (4, 'OT', 'Other');