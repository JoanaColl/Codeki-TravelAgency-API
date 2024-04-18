/*Realiza la CREACIÓN de la base de datos antes de ejecutar la app*/

CREATE SCHEMA IF NOT EXISTS `travelagency`;
USE `travelagency`;


/*Realiza los INSERT luego de ejecutada la app y creadas automáticamente las tablas*/

INSERT INTO `company` (`name`, `page`, `banner`) VALUES
	('Flybondi', 'flybondi.com', 'Banner Flybondi'),
    ('JetSMART', 'jetsmart.com', 'Banner JetSMART'),
    ('Aerolineas Argentinas', 'aerolineasargentinas.com.ar', 'Banner Aerolineas Argentinas');
    
INSERT INTO `flight` (`origin`, `destiny`, `departure_time`, `arriving_time`, `price`, `frequency`, `company_id`) VALUES
	('AEP', 'COR', 'Sun 18 Ago 20:54', 'Sun 18 Ago 22:21', '3311', 'Diary', '2'),
    ('AEP', 'COR', 'Sun 18 Ago 05:50', 'Sun 18 Ago 07:20', '4028', 'Diary', '3'),
    ('EZE', 'BRC', 'Sun 18 Ago 20:18', 'Sun 18 Ago 22:35', '6379', 'Diary', '1'),
    ('EZE', 'BRC', 'Sun 18 Ago 05:25', 'Sun 18 Ago 07:50', '1099', 'Diary', '3');
    
    