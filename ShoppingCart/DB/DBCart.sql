---------------------------------------------------------
--Create database homework-6:
--$ su - postgres
--$ createdb shopping-cart
--$ psql shopping-cart

---------------------------------------------------------
--Tables:

create table users (
	id_user int4 not null, 
	tx_login varchar(30) not null unique, 
	tx_password varchar(10) not null, 
	primary key (id_user));

create table person (
	id_person serial not null, 
	tx_first_name varchar(30) not null, 
	tx_last_name_a varchar(30) not null, 
	tx_last_name_b varchar(30) not null, 
	tx_street varchar(100) not null, 
	tx_city varchar(100) not null, 
	tx_state varchar(100) not null,
	tx_zipcode varchar(5) not null,
	tx_telephone varchar(14) not null, 
	primary key (id_person));

create table access (
	id_access int4 not null, 
	nu_attempt int4 not null, 
	fh_failed timestamp(0), 
	fh_lock timestamp(0), 
	primary key (id_access));

create table product (
	id_product serial not null, 
	tx_name varchar(50) not null, 
	tx_description varchar(500) not null, 
	ft_price float not null,
	nu_stock int4 not null,
	ft_discount float,
	primary key (id_product));

create table order_detail (
	id_product int4 not null, 
	id_order int4 not null,
	nu_amount int4 not null, 
	primary key (id_product, id_order));

create table order_c (
	id_order serial not null,
	fh_date timestamp(0) not null,
	st_purchased bool not null,
	ft_total float not null,
	id_user int4 not null,
	primary key (id_order));

create table card_users (
	id_user int4 not null,
	id_credit_card int4 not null,
	primary key (id_user, id_credit_card));

create table credit_card (
	id_credit_card serial not null,
	tx_number varchar(16) not null,
	tx_owner varchar(60) not null,
	fh_expiration timestamp(0) not null,
	tx_street varchar(100) not null, 
	tx_city varchar(100) not null, 
	tx_state varchar(100) not null,
	tx_zipcode varchar(10) not null, 
	primary key (id_credit_card));

alter table access add constraint FKaccess801659 foreign key (id_access) references users;
alter table users add constraint FKusers311802 foreign key (id_user) references person;
alter table order_detail add constraint FKorder_detail999795 foreign key (id_product) references product;
alter table order_detail add constraint FKorder_detail713322 foreign key (id_order) references order_c;
alter table order_c add constraint FKorder_c249289 foreign key (id_user) references users;
alter table card_users add constraint FKcard_users337911 foreign key (id_user) references users;
alter table card_users add constraint FKcard_users162639 foreign key (id_credit_card) references credit_card;

drop table users cascade;
drop table access cascade;
drop table address cascade;
drop table person cascade;
drop table product cascade;
drop table order_detail cascade;
drop table order_c cascade;
drop table credit_card cascade;
drop table card_users cascade;