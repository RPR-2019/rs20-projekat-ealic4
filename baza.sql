CREATE TABLE IF NOT EXISTS doctor(
    id int,
    name text,
    surname text,
    date_of_birth text,
    umbg text,
    address text,
    email text,
    phone_number text,
    salary real,
    username text,
    password text
);

CREATE TABLE IF NOT EXISTS patient(
    id int,
    name text,
    surname text,
    date_of_birth text,
    umbg text,
    address text,
    email text,
    phone_number text
);
CREATE TABLE IF NOT EXISTS medicalTechnician(
    id int,
    name text,
    surname text,
    date_of_birth text,
    umbg text,
    address text,
    email text,
    phone_number text,
    salary real,
    username text,
    password text
);

CREATE TABLE IF NOT EXISTS manager(
    id int,
    name text,
    surname text,
    date_of_birth text,
    umbg text,
    address text,
    email text,
    phone_number text,
    salary real,
    username text,
    password text
);

INSERT INTO doctor(id,name,surname,date_of_birth,umbg,address,email,phone_number,salary,username,password)
values(1,"Meho","Mehic","1960-06-12","1206960400153","Brazilska 1","mehomehic1@gmail.com","061-123-456",2000,"mehic","mehic");
INSERT INTO patient(id,name,surname,date_of_birth,umbg,address,email,phone_number)
values(1,"Jasmina","Alic","1973-05-21","2105973600153","Alici bb","jasminaalic21@gmail.com","062-456-789");
INSERT INTO medicalTechnician(id,name,surname,date_of_birth,umbg,address,email,phone_number,salary,username,password)
values(1,"Emina","Ivic","1985-07-23","2307985700569","Gromile I","eminaivic22@gmail.com","0644422449",1500,"emina","emina");
INSERT INTO manager(id,name,surname,date_of_birth,umbg,address,email,phone_number,salary,username,password)
values(1,"Aleksandra","Antic","1986-02-01","0102986769432","Bihacka 12","aleksandraantic@gmail.com","063-987-123",3000,"aleksandra","aleksandra");

