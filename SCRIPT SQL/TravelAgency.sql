/*Realiza la CREACIÓN de la base de datos antes de ejecutar la app*/

CREATE SCHEMA IF NOT EXISTS `travelagency`;
USE `travelagency`;


/*Realiza los INSERT luego de ejecutada la app y creadas automáticamente las tablas*/

INSERT INTO `company` (`name`, `page`, `banner`) VALUES
	('Flybondi', 'flybondi.com', 'Logo Flybondi'),
    ('JetSMART', 'jetsmart.com', 'Logo JetSMART'),
    ('Aerolineas Argentinas', 'aerolineasargentinas.com.ar', 'Logo Aerolineas Argentinas');
    
INSERT INTO `flight` (`origin`, `destiny`, `departure_time`, `arriving_time`, `price`, `frequency`, `company_id`) VALUES
	('AEP', 'COR', 'Dom 18 Ago 20:54', 'Dom 18 Ago 22:21', '33114', 'Diary', '2'),
    ('AEP', 'COR', 'Dom 18 Ago 05:50', 'Dom 18 Ago 07:20', '40289', 'Diary', '3'),
    ('EZE', 'BRC', 'Dom 18 Ago 20:18', 'Dom 18 Ago 22:35', '63792', 'Diary', '1'),
    ('EZE', 'BRC', 'Dom 18 Ago 05:25', 'Dom 18 Ago 07:50', '109965', 'Diary', '3');
    
    