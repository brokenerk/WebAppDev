---------------------------------------------------------
--Create database shopping-cart:
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

alter table access add constraint FKaccess801659 foreign key (id_access) references users;
alter table users add constraint FKusers311802 foreign key (id_user) references person;
alter table order_detail add constraint FKorder_detail999795 foreign key (id_product) references product;
alter table order_detail add constraint FKorder_detail713322 foreign key (id_order) references order_c;
alter table order_c add constraint FKorder_c249289 foreign key (id_user) references users;

-- Inserts ----------------------------------------------------------------------------------------------------
-- Personas
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values ('Enrique', 'Ramos', 'Diaz', 'Toluca 31 Lomas de San Andres', 'Tlalnepantla de Baz', 'EDOMEX', '54040', '55-55-55-55-55');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values ('Victor', 'Morales', 'Flores', 'Coral 999', 'Azcapotzalco', 'CDMX', '54041', '55-55-55-55-56');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values ('Roberto', 'Tecla', 'Parra', 'El Solecito 49', 'Benito Juarez', 'CDMX', '54042', '55-55-55-55-57');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values ('Juanito', 'Banana', 'Suarez', 'Jardines de Atizapan 11 Arboledas', 'Atizapan de Zaragoza', 'EDOMEX', '54043', '55-55-55-55-58');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values ('Teo', 'Gonzalez', 'Gonzalez', 'Bomboro 502 Torres Satelite', 'Naucalpan de Juarez', 'EDOMEX', '54044', '55-55-55-55-59');

-- Usuarios
insert into users(id_user, tx_login, tx_password) values (1, 'enriquebroly@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (2, 'vicleo@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (3, 'teclapa@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (4, 'banana@gmail.com', 'prueba123');
insert into users(id_user, tx_login, tx_password) values (5, 'teoglz@gmail.com', 'prueba123');

-- Acceso
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (1, 0, null, null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (2, 0, null, null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (3, 0, null, null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (4, 0, null, null);
insert into access(id_access, nu_attempt, fh_failed, fh_lock) values (5, 0, null, null);

-- Productos
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('PlayStation 4 Slim', 'Incluye una consola PlayStation 4 Slim de 1 TB, un control inalámbrico DUALSHOCK 4, discos de Blu-ray de God of War, Horizon Zero Dawn Complete Edition, Shadow of the Colossus, y un cupón para PS Plus (suscripción de 3 meses).', 6699.00, 200, 0);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Xbox One S', 'El paquete incluye: Consola Xbox One, descarga completa del juego Battlefield V Deluxe Edition, 1 mes de prueba de Xbox Game Pass con acceso a más de 100 juegos, y 14 días de prueba de Xbox Live Gold', 5999.00, 250, 0);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Eco Dot Bocina con Alexa', 'Echo Dot es una bocina inteligente que se controla con la voz. Se conecta a través de Wi-Fi a Alexa, un servicio de voz basado en la nube. Alexa puede reproducir música, responder a preguntas, narrar las noticias, consultar el pronóstico del clima, configurar alarmas, controlar dispositivos de Casa Inteligente compatibles y mucho más.', 699.00, 80, 30.2);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('HP Laptop 15-DA0001LA', 'Intel Celeron N4000, Ram 4 GB, Disco Duro 500GB, Windows 10 Home, 15.6", Sin Unidad Óptica. Garantía de 1 año.', 5478.99, 500, 0);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Huawei Mate 20 Lite', '64GB Libre de Fabrica 4G LTE SNE-LX3. SNE-LX3 Libre de Fabrica, Android 8.1 Oreo + EMUI 8.', 5128.00, 800, 26.3);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Kingston Digital 32GB 100 G3 USB 3.0', 'DataTraveler (DT100G3/32GB). En acuerdo con las especificaciones de USB 3.0 Compatiblidad dual Conectividad USB 3.0 Retro compatibilidad con USB 2.0 Diseño elegante de negro sobre negro y tapa deslizable Dispositivo inicial de almacenaje USB 3.0.', 119.95, 10, 20.31);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Nikon D7200 DX-format DSLR Body', 'La primera DSLR de Nikon con funciones integradas de Wi-Fi y Comunicación de Campo Cercano (NFC). Colof negro.', 17118.98, 500, 50.0);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Kingston Digital 240GB Solid State Drive', 'SSDNow UV400 SATA 3 2.5" SUV400S37/240G. Storage Capacity: 240GB SSD. Form Factor: 2.5-inch. Interface: SATA Rev. 3.0 (6Gb/S), with backwards compatibility to SATA Rev. 2.0 (3Gb/S).', 1814.27, 130, 33.33);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Appetite for Destruction (2LP)', 'Primer álbum Remaster de cintas analógicas originales Álbum original ampliado a 2 LP para reproducción de audio Corte de vinilo de 192 kHz 24 bits Remastered Audio de alta resolución Edición limitada Foil Art Slipcase Side 4 Bono extra: Holograma Hologroove de GNR Descargar etiqueta engomada de la tarjeta Álbum digital de 44 bits de 44.1kHz', 631.01, 900, 40.2);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Marvel Guante Electrónico Avengers Infinity War', 'El Guante electrónico de Thanos, ¡que incluye luces y sonidos! ¡Presiona el botón central en el puño para iluminar la piedra central y activar el poderoso sonido! Este Guante del Infinito está inspirado en la película Avengers: Infinity War y está diseñado para adaptarse a la mayoría de los tamaños de mano.', 226.82, 900, 50.3);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Wicked Audio Endo Supraaural Audífonos', 'Los auriculares inalámbricos Bluetooth de Wicked Audio Endo están diseñados para ofrecer música rock para alimentar tu adrenalina y mantenerte en movimiento.', 1682.28 , 100, 10.3);
insert into product(tx_name, tx_description, ft_price, nu_stock, ft_discount) values ('Funko, Figura Coleccionable Thanos', 'Funko Pop Vinyl Thanos. 5 pulgadas de alto. Figura coleccionable cabeza de Globo. Avengers Infinity War, Multicolor.', 249 , 100, 0.0);
update product set nu_stock = 5;

-- Pedido - Carrito
insert into order_c(fh_date, st_purchased, ft_total, id_user) values (to_date('01/01/2001','dd/MM/yyyy'), true, 6811.73, 1);
insert into order_c(fh_date, st_purchased, ft_total, id_user) values (to_date('01/01/2001','dd/MM/yyyy'), true, 6811.73, 2);
insert into order_c(fh_date, st_purchased, ft_total, id_user) values (to_date('01/01/2001','dd/MM/yyyy'), true, 6811.73, 3);

-- Detalle Pedido
insert into order_detail(id_product, id_order, nu_amount) values (1, 1, 1);
insert into order_detail(id_product, id_order, nu_amount) values (10, 1, 1);