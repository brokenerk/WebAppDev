create table users (id_user int4 not null, tx_login varchar(30) not null unique, tx_password varchar(100) not null, primary key (id_user));
create table role (id_role serial not null, tx_name varchar(50) not null unique, tx_description varchar(250) not null, st_active bool not null, primary key (id_role));
create table account (id_account serial not null, id_role int4 not null, id_user int4 not null, fh_begin date not null, fh_end date, primary key (id_account));
create table person (id_person serial not null, tx_first_name varchar(30) not null, tx_last_name_a varchar(30) not null, tx_last_name_b varchar(30) not null, tx_curp varchar(18) not null unique, fh_birth date not null, primary key (id_person));
create table access (id_access int4 not null, nu_attempt int4 not null, fh_failed timestamp(0), fh_lock timestamp(0), primary key (id_access));
create table type_contact (id_type serial not null, tx_name varchar(50) not null unique, tx_description varchar(200) not null, st_active bool not null, primary key (id_type));
create table person_contact (id_person_contact serial not null, id_person int4 not null, id_type int4 not null, tx_contact varchar(50), primary key (id_person_contact));
create table contact (id_person int4 not null, id_contact int4 not null, primary key (id_person, id_contact));
create table address (id_person int4 not null, tx_street varchar(100) not null, tx_city varchar(100) not null, tx_zipcode varchar(10) not null, primary key (id_person));
alter table account add constraint FKaccount713322 foreign key (id_role) references role;
alter table account add constraint FKaccount999795 foreign key (id_user) references users;
alter table access add constraint FKaccess801659 foreign key (id_access) references users;
alter table person_contact add constraint FKperson_con52636 foreign key (id_person) references person;
alter table person_contact add constraint FKperson_con162639 foreign key (id_type) references type_contact;
alter table users add constraint FKusers311802 foreign key (id_user) references person;
alter table contact add constraint FKcontact249289 foreign key (id_person) references person;
alter table contact add constraint FKcontact337911 foreign key (id_contact) references person;
alter table address add constraint FKaddress501726 foreign key (id_person) references person;

--Inserts
-- Roles
insert into role(tx_name, tx_description, st_active) values ('Técnico','Director técnico de futbol',true);
insert into role(tx_name, tx_description, st_active) values ('Jugador','Jugador profesional de futbol',true);

-- Personas
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Ricardo', 'Ferreti', 'Oliveria', 'MOCH870812HGRX00', to_date('01/01/1950','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Rafael', 'Márquez', 'Álvarez', 'MOCH870812HGRX01', to_date('01/01/1960','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Javier', 'Hernández', 'Balcázar', 'MOCH870812HGRX02', to_date('01/01/1970','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('José Andrés', 'Guardado', 'Hernández', 'MOCH870812HGRX03', to_date('01/01/1980','dd/MM/yyyy'));
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_curp, fh_birth) values ('Cristiano Ronaldo', 'Dos Santos', 'Aveiro', 'MOCH870812HGRX04', to_date('01/01/1990','dd/MM/yyyy'));

-- Usuarios
insert into users(id_user, tx_login, tx_password) values (1,'tuca_ferreti@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (2,'rafael_marquez@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (3,'chicharito_hernandez@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (4,'andres_guardado@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (5,'cristiano_ronaldo@gmail.com', 'prueba123');

-- Cuentas
insert into account(id_role, id_user, fh_begin, fh_end) values (1, 1, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/1950','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 2, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 3, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 4, to_date('01/01/2018','dd/MM/yyyy'), to_date('31/12/2018','dd/MM/yyyy'));
insert into account(id_role, id_user, fh_begin, fh_end) values (2, 5, to_date('01/01/2018','dd/MM/yyyy'), null);

-- Acceso
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (1,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (2,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (3,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (4,0,null,null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (5,0,null,null);

-- Tipo contacto
insert into type_contact(tx_name, tx_description, st_active) values ('Telephone','Telephone',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Email','Email',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Mobile phone','Mobile phone',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Facebook','Facebook',true);
insert into type_contact(tx_name, tx_description, st_active) values ('Twitter','Twitter',true);


delete from type_contact;
delete from access;
delete from account;
delete from users;
delete from person;
TRUNCATE TABLE person RESTART IDENTITY cascade;