-- Insert sample data into the airport table

INSERT INTO airports (name, city, country, code)
VALUES ('Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States', 'ATL'),
       ('Beijing Capital International Airport', 'Beijing', 'China', 'PEK'),
       ('Los Angeles International Airport', 'Los Angeles', 'United States', 'LAX'),
       ('Dubai International Airport', 'Dubai', 'United Arab Emirates', 'DXB'),
       ('Tokyo Haneda Airport', 'Tokyo', 'Japan', 'HND'),
       ('London Heathrow Airport', 'London', 'United Kingdom', 'LHR'),
       ('Paris Charles de Gaulle Airport', 'Paris', 'France', 'CDG'),
       ('Amsterdam Schiphol Airport', 'Amsterdam', 'Netherlands', 'AMS'),
       ('Singapore Changi Airport', 'Singapore', 'Singapore', 'SIN'),
       ('Incheon International Airport', 'Seoul', 'South Korea', 'ICN'),
       ('Hong Kong International Airport', 'Hong Kong', 'China', 'HKG'),
       ('Shanghai Pudong International Airport', 'Shanghai', 'China', 'PVG'),
       ('Dallas/Fort Worth International Airport', 'Dallas', 'United States', 'DFW'),
       ('John F. Kennedy International Airport', 'New York', 'United States', 'JFK'),
       ('Denver International Airport', 'Denver', 'United States', 'DEN'),
       ('Sydney Kingsford Smith Airport', 'Sydney', 'Australia', 'SYD'),
       ('Toronto Pearson International Airport', 'Toronto', 'Canada', 'YYZ'),
       ('Munich Airport', 'Munich', 'Germany', 'MUC'),
       ('Zurich Airport', 'Zurich', 'Switzerland', 'ZRH'),
       ('Bangkok Suvarnabhumi Airport', 'Bangkok', 'Thailand', 'BKK'),
       ('Istanbul Airport', 'Istanbul', 'Turkey', 'IST'),
       ('Kuala Lumpur International Airport', 'Kuala Lumpur', 'Malaysia', 'KUL'),
       ('San Francisco International Airport', 'San Francisco', 'United States', 'SFO'),
       ('Seoul Gimpo International Airport', 'Seoul', 'South Korea', 'GMP'),
       ('Delhi Indira Gandhi International Airport', 'Delhi', 'India', 'DEL'),
       ('Vancouver International Airport', 'Vancouver', 'Canada', 'YVR'),
       ('Moscow Sheremetyevo International Airport', 'Moscow', 'Russia', 'SVO');



-- Insert users
-- password for all user is "123"
INSERT INTO users (firstname, lastname, email, password, phone, address, role)
VALUES ('John', 'Doe', 'john.doe@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '1234567890', '123 Main St', 'USER'),
       ('Jane', 'Smith', 'jane.smith@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '0987654321', '456 Elm St', 'ADMIN'),
       ('Alice', 'Johnson', 'alice.johnson@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '1112223333', '789 Pine St', 'USER'),
       ('Bob', 'Williams', 'bob.williams@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '2223334444', '101 Maple St', 'USER'),
       ('Carol', 'Brown', 'carol.brown@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '3334445555', '202 Oak St', 'ADMIN'),
       ('David', 'Jones', 'david.jones@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '4445556666', '303 Cedar St', 'USER'),
       ('Eva', 'Garcia', 'eva.garcia@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '5556667777', '404 Birch St', 'USER'),
       ('Frank', 'Martinez', 'frank.martinez@example.com',
        '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '6667778888', '505 Walnut St', 'ADMIN'),
       ('Grace', 'Hernandez', 'grace.hernandez@example.com',
        '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '7778889999', '606 Cherry St', 'USER'),
       ('Henry', 'Lopez', 'henry.lopez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W',
        '8889990000', '707 Ash St', 'ADMIN');


INSERT INTO airline (id, airline_logo, airline_name, country)
VALUES (1,
        'https://download.logo.wine/logo/American_Airlines/American_Airlines-Logo.wine.png',
        'American Airlines', 'United States'),
       (2,
        'https://1000logos.net/wp-content/uploads/2017/09/Delta-Air-Lines-Logo-1966.png',
        'Delta Air Lines', 'United States'),
       (3,
        'https://static1.simpleflyingimages.com/wordpress/wp-content/uploads/2024/03/ua_logo_stack_rgb_r-ezgif-com-avif-to-jpg-converter.jpg',
        'United Airlines', 'United States'),
       (4,
        'https://1000logos.net/wp-content/uploads/2019/08/southwest-airlines-logo.png',
        'Southwest Airlines', 'United States'),
       (5,
        'https://airhex.com/images/airline-logos/alt/air-canada.png',
        'Air Canada', 'Canada'),
       (6,
        'https://www.logodesignlove.com/wp-content/uploads/2013/01/ba-logo-white-on-blue-01.jpg',
        'British Airways', 'United Kingdom'),
       (7,
        'https://i.pinimg.com/736x/a4/a3/5d/a4a35d12dfeb97caf85fb4a792ddac85.jpg',
        'Lufthansa', 'Germany'),
       (8,
        'https://i.pinimg.com/originals/b1/33/cc/b133cc823ff2958c6dba8ab247f1639e.png',
        'Air France', 'France'),
       (9, 'https://c8.alamy.com/comp/2M7GY3X/emirates-airline-logo-white-background-2M7GY3X.jpg',
        'Emirates', 'United Arab Emirates'),
       (10,
        'https://www.shutterstock.com/image-illustration/jakarta-june-142023-silhouette-airplane-260nw-2317269505.jpg',
        'Qatar Airways', 'Qatar'),
       (11,
        'https://1000logos.net/wp-content/uploads/2020/04/Singapore-Airlines-Logo.png',
        'Singapore Airlines', 'Singapore'),
       (12,
        'https://1000logos.net/wp-content/uploads/2020/04/Cathay-Pacific-Logo.jpg',
        'Cathay Pacific', 'Hong Kong'),
       (13,
        'https://1000logos.net/wp-content/uploads/2021/04/All-Nippon-Airways-logo.png',
        'ANA All Nippon Airways', 'Japan'),
       (14,
        'https://ih1.redbubble.net/image.1597679389.3515/st,small,507x507-pad,600x600,f8f8f8.jpg',
        'Japan Airlines', 'Japan'),
       (15, 'https://www.qantas.com/content/dam/qantas/centenary/tiles/100%20Capsule-Logo-2016%201518x1012.jpg/jcr:content/renditions/article.tablet.small.jpg',
        'Qantas', 'Australia'),
       (16,
        'https://1000logos.net/wp-content/uploads/2020/04/China-Southern-logo.jpg',
        'China Southern Airlines', 'China'),
       (17,
        'https://1000logos.net/wp-content/uploads/2021/04/China-Eastern-Airlines-logo.png',
        'China Eastern Airlines', 'China'),
       (18,
        'https://1000logos.net/wp-content/uploads/2020/04/Turkish_Airlines_logo.png',
        'Turkish Airlines', 'Turkey'),
       (19,
        'https://1000logos.net/wp-content/uploads/2021/03/KLM-logo.jpg',
        'KLM Royal Dutch Airlines', 'Netherlands'),
       (20,
        'https://1000logos.net/wp-content/uploads/2021/04/Swiss-International-Air-Lines-logo.png',
        'Swiss International Air Lines', 'Switzerland'),
       (21,
        'https://1000logos.net/wp-content/uploads/2020/04/Etihad-Airways-Logo-2003.jpg',
        'Etihad Airways', 'United Arab Emirates'),
       (22,
        'https://1000logos.net/wp-content/uploads/2020/03/Korean-Air-Logo.png',
        'Korean Air', 'South Korea'),
       (23,
        'https://cdn.worldvectorlogo.com/logos/asiana-airlines.svg',
        'Asiana Airlines', 'South Korea'),
       (24, 'https://1000logos.net/wp-content/uploads/2020/02/Aeroflot-Logo.png',
        'Aeroflot', 'Russia'),
       (25, 'https://1000logos.net/wp-content/uploads/2020/03/Alitalia-logo.jpg',
        'Alitalia', 'Italy'),
       (26, 'https://1000logos.net/wp-content/uploads/2021/04/Iberia-logo.png',
        'Iberia', 'Spain'),
       (27, 'https://i.pinimg.com/736x/7d/9d/bb/7d9dbb2a56c94d02bb2b6001714e3d5f.jpg',
        'Finnair', 'Finland'),
       (28, 'https://logowik.com/content/uploads/images/519_scandinavianairlines.jpg',
        'SAS Scandinavian Airlines', 'Sweden'),
       (29,
        'https://1000logos.net/wp-content/uploads/2020/04/Austrian-Airlines-logo.jpg',
        'Austrian Airlines', 'Austria'),
       (30,
        'https://1000logos.net/wp-content/uploads/2023/05/Aeromexico-Logo.jpg',
        'Aeromexico', 'Mexico');

-- Flights from ATL (1) to PEK (2)
INSERT INTO flight (id, flight_number, arrival_date, arrival_time, available_seats, departure_date, departure_time,
                    ticket_price, airline_id, arrival_airport_id, departure_airport_id)
VALUES (1, 'AA1001', '2024-09-01', '10:00:00', 150, '2024-09-01', '06:00:00', 500.00, 1, 2, 1),
       (2, 'DL1001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 550.00, 2, 2, 1),
       (3, 'UA1001', '2024-09-03', '14:00:00', 150, '2024-09-03', '10:00:00', 600.00, 3, 2, 1),
       (4, 'AA1002', '2024-09-04', '10:00:00', 150, '2024-09-04', '06:00:00', 500.00, 1, 1, 2),
       (5, 'DL1002', '2024-09-05', '12:00:00', 150, '2024-09-05', '08:00:00', 550.00, 2, 1, 2),
       (6, 'UA1002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 600.00, 3, 1, 2),

-- Flights from LAX (3) to DXB (4)
       (7, 'AA2001', '2024-09-01', '15:00:00', 150, '2024-09-01', '11:00:00', 700.00, 1, 4, 3),
       (8, 'DL2001', '2024-09-02', '17:00:00', 150, '2024-09-02', '13:00:00', 750.00, 2, 4, 3),
       (9, 'UA2001', '2024-09-03', '19:00:00', 150, '2024-09-03', '15:00:00', 800.00, 3, 4, 3),
       (10, 'AA2002', '2024-09-04', '15:00:00', 150, '2024-09-04', '11:00:00', 700.00, 1, 3, 4),
       (11, 'DL2002', '2024-09-05', '17:00:00', 150, '2024-09-05', '13:00:00', 750.00, 2, 3, 4),
       (12, 'UA2002', '2024-09-06', '19:00:00', 150, '2024-09-06', '15:00:00', 800.00, 3, 3, 4),

-- Flights from HND (5) to LHR (6)
       (13, 'AA3001', '2024-09-01', '20:00:00', 150, '2024-09-01', '16:00:00', 900.00, 1, 6, 5),
       (14, 'DL3001', '2024-09-02', '22:00:00', 150, '2024-09-02', '18:00:00', 950.00, 2, 6, 5),
       (15, 'UA3001', '2024-09-03', '00:00:00', 150, '2024-09-03', '20:00:00', 1000.00, 3, 6, 5),
       (16, 'AA3002', '2024-09-04', '20:00:00', 150, '2024-09-04', '16:00:00', 900.00, 1, 5, 6),
       (17, 'DL3002', '2024-09-05', '22:00:00', 150, '2024-09-05', '18:00:00', 950.00, 2, 5, 6),
       (18, 'UA3002', '2024-09-06', '00:00:00', 150, '2024-09-06', '20:00:00', 1000.00, 3, 5, 6),

-- Flights from CDG (7) to AMS (8)
       (19, 'AA4001', '2024-09-01', '06:00:00', 150, '2024-09-01', '02:00:00', 400.00, 1, 8, 7),
       (20, 'DL4001', '2024-09-02', '08:00:00', 150, '2024-09-02', '04:00:00', 450.00, 2, 8, 7),
       (21, 'UA4001', '2024-09-03', '10:00:00', 150, '2024-09-03', '06:00:00', 500.00, 3, 8, 7),
       (22, 'AA4002', '2024-09-04', '06:00:00', 150, '2024-09-04', '02:00:00', 400.00, 1, 7, 8),
       (23, 'DL4002', '2024-09-05', '08:00:00', 150, '2024-09-05', '04:00:00', 450.00, 2, 7, 8),
       (24, 'UA4002', '2024-09-06', '10:00:00', 150, '2024-09-06', '06:00:00', 500.00, 3, 7, 8),

-- Flights from SIN (9) to ICN (10)
       (25, 'AA5001', '2024-09-01', '14:00:00', 150, '2024-09-01', '10:00:00', 650.00, 1, 10, 9),
       (26, 'DL5001', '2024-09-02', '16:00:00', 150, '2024-09-02', '12:00:00', 700.00, 2, 10, 9),
       (27, 'UA5001', '2024-09-03', '18:00:00', 150, '2024-09-03', '14:00:00', 750.00, 3, 10, 9),
       (28, 'AA5002', '2024-09-04', '14:00:00', 150, '2024-09-04', '10:00:00', 650.00, 1, 9, 10),
       (29, 'DL5002', '2024-09-05', '16:00:00', 150, '2024-09-05', '12:00:00', 700.00, 2, 9, 10),
       (30, 'UA5002', '2024-09-06', '18:00:00', 150, '2024-09-06', '14:00:00', 750.00, 3, 9, 10),

-- Flights from HKG (11) to PVG (12)
       (31, 'AA6001', '2024-09-01', '10:00:00', 150, '2024-09-01', '06:00:00', 550.00, 1, 12, 11),
       (32, 'DL6001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 600.00, 2, 12, 11),
       (33, 'UA6001', '2024-09-03', '14:00:00', 150, '2024-09-03', '10:00:00', 650.00, 3, 12, 11),
       (34, 'AA6002', '2024-09-04', '10:00:00', 150, '2024-09-04', '06:00:00', 550.00, 1, 11, 12),
       (35, 'DL6002', '2024-09-05', '12:00:00', 150, '2024-09-05', '08:00:00', 600.00, 2, 11, 12),
       (36, 'UA6002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 650.00, 3, 11, 12),

-- Flights from DFW (13) to JFK (14)
       (37, 'AA7001', '2024-09-01', '15:00:00', 150, '2024-09-01', '11:00:00', 450.00, 1, 14, 13),
       (38, 'DL7001', '2024-09-02', '17:00:00', 150, '2024-09-02', '13:00:00', 500.00, 2, 14, 13),
       (39, 'UA7001', '2024-09-03', '19:00:00', 150, '2024-09-03', '15:00:00', 550.00, 3, 14, 13),
       (40, 'AA7002', '2024-09-04', '15:00:00', 150, '2024-09-04', '11:00:00', 450.00, 1, 13, 14),
       (41, 'DL7002', '2024-09-05', '17:00:00', 150, '2024-09-05', '13:00:00', 500.00, 2, 13, 14),
       (42, 'UA7002', '2024-09-06', '19:00:00', 150, '2024-09-06', '15:00:00', 550.00, 3, 13, 14),

-- Flights from DEN (15) to SYD (16)
       (43, 'AA8001', '2024-09-01', '20:00:00', 150, '2024-09-01', '16:00:00', 1000.00, 1, 16, 15),
       (44, 'DL8001', '2024-09-02', '22:00:00', 150, '2024-09-02', '18:00:00', 1050.00, 2, 16, 15),
       (45, 'UA8001', '2024-09-03', '00:00:00', 150, '2024-09-03', '20:00:00', 1100.00, 3, 16, 15),
       (46, 'AA8002', '2024-09-04', '20:00:00', 150, '2024-09-04', '16:00:00', 1000.00, 1, 15, 16),
       (47, 'DL8002', '2024-09-05', '22:00:00', 150, '2024-09-05', '18:00:00', 1050.00, 2, 15, 16),
       (48, 'UA8002', '2024-09-06', '00:00:00', 150, '2024-09-06', '20:00:00', 1100.00, 3, 15, 16),

-- Flights from YYZ (17) to MUC (18)
       (49, 'AA9001', '2024-09-01', '10:00:00', 150, '2024-09-01', '06:00:00', 850.00, 1, 18, 17),
       (50, 'DL9001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 900.00, 2, 18, 17),
       (51, 'UA9001', '2024-09-03', '14:00:00', 150, '2024-09-03', '10:00:00', 950.00, 3, 18, 17),
       (52, 'AA9002', '2024-09-04', '10:00:00', 150, '2024-09-04', '06:00:00', 850.00, 1, 17, 18),
       (53, 'DL9002', '2024-09-05', '12:00:00', 150, '2024-09-05', '08:00:00', 900.00, 2, 17, 18),
       (54, 'UA9002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 950.00, 3, 17, 18),

-- Flights from ZRH (19) to BKK (20)
       (55, 'AA10003', '2024-09-01', '15:00:00', 150, '2024-09-01', '11:00:00', 800.00, 1, 20, 19),
       (56, 'DL10003', '2024-09-02', '17:00:00', 150, '2024-09-02', '13:00:00', 850.00, 2, 20, 19),
       (57, 'UA10003', '2024-09-03', '19:00:00', 150, '2024-09-03', '15:00:00', 900.00, 3, 20, 19),
       (58, 'AA10004', '2024-09-04', '15:00:00', 150, '2024-09-04', '11:00:00', 800.00, 1, 19, 20),
       (59, 'DL10004', '2024-09-05', '17:00:00', 150, '2024-09-05', '13:00:00', 850.00, 2, 19, 20),
       (60, 'UA10004', '2024-09-06', '19:00:00', 150, '2024-09-06', '15:00:00', 900.00, 3, 19, 20),

-- Flights from IST (21) to KUL (22)
       (61, 'AA11001', '2024-09-01', '20:00:00', 150, '2024-09-01', '16:00:00', 750.00, 1, 22, 21),
       (62, 'DL11001', '2024-09-02', '22:00:00', 150, '2024-09-02', '18:00:00', 800.00, 2, 22, 21),
       (63, 'UA11001', '2024-09-03', '00:00:00', 150, '2024-09-03', '20:00:00', 850.00, 3, 22, 21),
       (64, 'AA11002', '2024-09-04', '20:00:00', 150, '2024-09-04', '16:00:00', 750.00, 1, 21, 22),
       (65, 'DL11002', '2024-09-05', '22:00:00', 150, '2024-09-05', '18:00:00', 800.00, 2, 21, 22),
       (66, 'UA11002', '2024-09-06', '00:00:00', 150, '2024-09-06', '20:00:00', 850.00, 3, 21, 22),

-- Flights from SFO (23) to GMP (24)
       (67, 'AA12001', '2024-09-01', '06:00:00', 150, '2024-09-01', '02:00:00', 1200.00, 1, 24, 23),
       (68, 'DL12001', '2024-09-02', '08:00:00', 150, '2024-09-02', '04:00:00', 1250.00, 2, 24, 23),
       (69, 'UA12001', '2024-09-03', '10:00:00', 150, '2024-09-03', '06:00:00', 1300.00, 3, 24, 23),
       (70, 'AA12002', '2024-09-04', '06:00:00', 150, '2024-09-04', '02:00:00', 1200.00, 1, 23, 24),
       (71, 'DL12002', '2024-09-05', '08:00:00', 150, '2024-09-05', '04:00:00', 1250.00, 2, 23, 24),
       (72, 'UA12002', '2024-09-06', '10:00:00', 150, '2024-09-06', '06:00:00', 1300.00, 3, 23, 24),

-- Flights from DEL (25) to YVR (26)
       (73, 'AA13001', '2024-09-01', '14:00:00', 150, '2024-09-01', '10:00:00', 1100.00, 1, 26, 25),
       (74, 'DL13001', '2024-09-02', '16:00:00', 150, '2024-09-02', '12:00:00', 1150.00, 2, 26, 25),
       (75, 'UA13001', '2024-09-03', '18:00:00', 150, '2024-09-03', '14:00:00', 1200.00, 3, 26, 25),
       (76, 'AA13002', '2024-09-04', '14:00:00', 150, '2024-09-04', '10:00:00', 1100.00, 1, 25, 26),
       (77, 'DL13002', '2024-09-05', '16:00:00', 150, '2024-09-05', '12:00:00', 1150.00, 2, 25, 26),
       (78, 'UA13002', '2024-09-06', '18:00:00', 150, '2024-09-06', '14:00:00', 1200.00, 3, 25, 26),

-- Flights from SVO (27) to ATL (1)
       (79, 'AA14001', '2024-09-01', '10:00:00', 150, '2024-09-01', '06:00:00', 650.00, 1, 1, 27),
       (80, 'DL14001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 700.00, 2, 1, 27),
       (81, 'UA14001', '2024-09-03', '14:00:00', 150, '2024-09-03', '10:00:00', 750.00, 3, 1, 27),
       (82, 'AA14002', '2024-09-04', '10:00:00', 150, '2024-09-04', '06:00:00', 650.00, 1, 27, 1),
       (83, 'DL14002', '2024-09-05', '12:00:00', 150, '2024-09-05', '08:00:00', 700.00, 2, 27, 1),
       (84, 'UA14002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 750.00, 3, 27, 1);














