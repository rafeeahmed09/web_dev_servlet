create database onile_admission_from;
use oilne_admission_from;
-- singup---
create table customers(
id int auto_increment primary key,
Fullname varchar(100) not null,
phone varchar(10) not null,
email varchar (100) unique not null,
password varchar (100) not null
);
-- Customers_logic --
select * from customers_logic;
create table customers_logic(
id int auto_increment primary key,
email varchar(100) not null,
password varchar (100) not null
);


