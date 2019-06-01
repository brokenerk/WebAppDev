--Inserts
-- Personas
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b) values ('Enrique', 'Ramos', 'Diaz');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b) values ('Victor', 'Morales', 'Flores');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b) values ('Roberto', 'Tecla', 'Parra');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b) values ('Juanito', 'Banana', 'Suarez');
insert into person(tx_first_name, tx_last_name_a, tx_last_name_b) values ('Teo', 'Gonzalez', 'Gonzalez');

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

-- Direcciones
insert into address(id_person, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values (1, 'Toluca 31 Lomas de San Andres', 'Tlalnepantla de Baz', 'EDOMEX', '54040', '55-55-55-55-55');
insert into address(id_person, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values (2, 'Coral 999', 'Azcapotzalco', 'CDMX', '54041', '55-55-55-55-56');
insert into address(id_person, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values (3, 'El Solecito 49', 'Benito Juarez', 'CDMX', '54042', '55-55-55-55-57');
insert into address(id_person, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values (4, 'Jardines de Atizapan 11 Arboledas', 'Atizapan de Zaragoza', 'EDOMEX', '54043', '55-55-55-55-58');
insert into address(id_person, tx_street, tx_city, tx_state, tx_zipcode, tx_telephone) values (5, 'Bomboro 502 Torres Satelite', 'Naucalpan de Juarez', 'EDOMEX', '54044', '55-55-55-55-59');

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

-- Pedido - Carrito
insert into order_c(fh_date, st_purchased, ft_total, id_user) values (to_date('01/01/2001','dd/MM/yyyy'), true, 1000.00, 1);
insert into order_c(fh_date, st_purchased, ft_total, id_user) values (to_date('02/02/2002','dd/MM/yyyy'), false, 200.00, 1);

-- Detalle Pedido
insert into order_detail(id_product, id_order, nu_amount) values (1, 1, 10);
insert into order_detail(id_product, id_order, nu_amount) values (2, 1, 1);
insert into order_detail(id_product, id_order, nu_amount) values (9, 1, 2);
insert into order_detail(id_product, id_order, nu_amount) values (10, 1, 3);
insert into order_detail(id_product, id_order, nu_amount) values (1, 2, 10);
insert into order_detail(id_product, id_order, nu_amount) values (5, 2, 1);
insert into order_detail(id_product, id_order, nu_amount) values (7, 2, 2);
insert into order_detail(id_product, id_order, nu_amount) values (8, 2, 3);

-- Tarjeta credito 
insert into credit_card(tx_number, tx_owner, fh_expiration, tx_street, tx_city, tx_state, tx_zipcode) values ('8544731223541592', 'Lourdes Diaz Hernandez', to_date('01/10/2020','dd/MM/yyyy'), 'Toluca 31', 'Tlalnepantla', 'EDOMEX', '54040');
insert into credit_card(tx_number, tx_owner, fh_expiration, tx_street, tx_city, tx_state, tx_zipcode) values ('9544731223541593', 'Vicente Matias Vuoso', to_date('01/08/2021','dd/MM/yyyy'), 'Ballena 600', 'Atizapan', 'EDOMEX', '54041');
insert into credit_card(tx_number, tx_owner, fh_expiration, tx_street, tx_city, tx_state, tx_zipcode) values ('3544731223541594', 'Michael Jackson', to_date('01/05/2022','dd/MM/yyyy'), 'Halconazo 66', 'Cuauhtemoc', 'CDMX', '54042');

-- Tarjeta - Usuario
insert into card_users(id_user, id_credit_card) values (1, 1);
insert into card_users(id_user, id_credit_card) values (1, 2);
insert into card_users(id_user, id_credit_card) values (2, 3);

-- Para reiniciar bd en caso de errores xd
delete from access cascade;
delete from address cascade;
delete from users cascade;
delete from person cascade;
delete from product cascade;
delete from order_detail cascade;
delete from order_c cascade;
delete from credit_card cascade;
delete from card_users cascade;
TRUNCATE TABLE credit_card RESTART IDENTITY cascade;
TRUNCATE TABLE person RESTART IDENTITY cascade;
TRUNCATE TABLE product RESTART IDENTITY cascade;
TRUNCATE TABLE order_c RESTART IDENTITY cascade;