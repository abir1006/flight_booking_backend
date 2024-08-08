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
       (2, 'AA1002', '2024-09-04', '10:00:00', 150, '2024-09-04', '06:00:00', 500.00, 1, 1, 2),

-- Flights from LAX (3) to DXB (4)
       (3, 'DL2001', '2024-09-02', '17:00:00', 150, '2024-09-02', '13:00:00', 750.00, 2, 4, 3),
       (4, 'DL2002', '2024-09-05', '17:00:00', 150, '2024-09-05', '13:00:00', 750.00, 2, 3, 4),

-- Flights from HND (5) to LHR (6)
       (5, 'UA3001', '2024-09-03', '00:00:00', 150, '2024-09-03', '20:00:00', 1000.00, 3, 6, 5),
       (6, 'AA3002', '2024-09-04', '20:00:00', 150, '2024-09-04', '16:00:00', 900.00, 1, 5, 6),

-- Flights from CDG (7) to AMS (8)
       (7, 'AA4002', '2024-09-04', '06:00:00', 150, '2024-09-04', '02:00:00', 400.00, 1, 7, 8),
       (8, 'UA4002', '2024-09-06', '10:00:00', 150, '2024-09-06', '06:00:00', 500.00, 3, 8, 7),

-- Flights from SIN (9) to ICN (10)
       (9, 'AA5001', '2024-09-01', '14:00:00', 150, '2024-09-01', '10:00:00', 650.00, 1, 10, 9),
       (10, 'UA5002', '2024-09-06', '18:00:00', 150, '2024-09-06', '14:00:00', 750.00, 3, 9, 10),

-- Flights from HKG (11) to PVG (12)
       (11, 'DL6001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 600.00, 2, 12, 11),
       (12, 'UA6002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 650.00, 3, 11, 12),

-- Flights from DFW (13) to JFK (14)
       (13, 'UA7001', '2024-09-03', '19:00:00', 150, '2024-09-03', '15:00:00', 550.00, 3, 14, 13),
       (14, 'AA7002', '2024-09-04', '15:00:00', 150, '2024-09-04', '11:00:00', 450.00, 1, 13, 14),

-- Flights from DEN (15) to SYD (16)
       (15, 'AA8001', '2024-09-01', '20:00:00', 150, '2024-09-01', '16:00:00', 1000.00, 1, 16, 15),
       (16, 'DL8002', '2024-09-05', '22:00:00', 150, '2024-09-05', '18:00:00', 1050.00, 2, 15, 16),

-- Flights from YYZ (17) to MUC (18)
       (17, 'DL9001', '2024-09-02', '12:00:00', 150, '2024-09-02', '08:00:00', 900.00, 2, 18, 17),
       (18, 'DL9002', '2024-09-05', '12:00:00', 150, '2024-09-05', '08:00:00', 900.00, 2, 17, 18),

-- Flights from ZRH (19) to BKK (20)
       (19, 'DL10004', '2024-09-05', '17:00:00', 150, '2024-09-05', '13:00:00', 850.00, 2, 19, 20),
       (20, 'UA10004', '2024-09-06', '19:00:00', 150, '2024-09-06', '15:00:00', 900.00, 3, 19, 20),

-- Flights from IST (21) to KUL (22)
       (21, 'UA11001', '2024-09-03', '00:00:00', 150, '2024-09-03', '20:00:00', 850.00, 3, 22, 21),
       (22, 'UA11002', '2024-09-06', '00:00:00', 150, '2024-09-06', '20:00:00', 850.00, 3, 21, 22),

-- Flights from SFO (23) to GMP (24)
       (23, 'UA12001', '2024-09-03', '10:00:00', 150, '2024-09-03', '06:00:00', 1300.00, 3, 24, 23),
       (24, 'DL12002', '2024-09-05', '08:00:00', 150, '2024-09-05', '04:00:00', 1250.00, 2, 23, 24),

-- Flights from DEL (25) to YVR (26)
       (25, 'DL13001', '2024-09-02', '16:00:00', 150, '2024-09-02', '12:00:00', 1150.00, 2, 26, 25),
       (26, 'DL13002', '2024-09-05', '16:00:00', 150, '2024-09-05', '12:00:00', 1150.00, 2, 25, 26),

-- Flights from SVO (27) to ATL (1)
       (27, 'AA14001', '2024-09-01', '10:00:00', 150, '2024-09-01', '06:00:00', 650.00, 1, 1, 27),
       (28, 'UA14002', '2024-09-06', '14:00:00', 150, '2024-09-06', '10:00:00', 750.00, 3, 27, 1);

-- Insert sample booking data
-- INSERT INTO booking (booking_date, status, trip_type, total_price, flight_id, return_flight_id, return_date)
-- VALUES
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 1, NULL, NULL),
--     ('2024-08-02', 'PENDING', 'ROUND_TRIP', 450.00, 2, 1, '2024-09-02');
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 2, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 1, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 2, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 1, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 2, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 1, NULL, NULL),
--     ('2024-08-01', 'PENDING', 'ONE_WAY', 200.00, 2, NULL, NULL);
--
--
--
-- -- Insert sample passenger data
-- INSERT INTO passenger (first_name, last_name, email, phone, address, booking_id)
-- VALUES
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Jane', 'Doe', 'jane.doe@example.com', '0987654321', '456 Oak Avenue', 1),
--     ('John', 'Smith', 'john.smith@example.com', '5551234567', '789 Pine Road', 2);
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 1),
--     ('Umar', 'Bunyaminu', 'umarbunyaminu@gmail.com', '1234567890', '123 Elm Street', 2);
--     ('Jane', 'Doe', 'jane.doe@example.com', '0987654321', '456 Oak Avenue', 2),
--     ('John', 'Smith', 'john.smith@example.com', '5551234567', '789 Pine Road', 2),
--     ('Alice', 'Johnson', 'alice.johnson@example.com', '5559876543', '101 Maple Street', 2),
--     ('Bob', 'Brown', 'bob.brown@example.com', '5555555555', '202 Cedar Lane', 2),
--     ('Charlie', 'Davis', 'charlie.davis@example.com', '5554444444', '303 Birch Boulevard', 2),
--     ('Diana', 'Evans', 'diana.evans@example.com', '5553333333', '404 Pine Avenue', 1),
--     ('Edward', 'Green', 'edward.green@example.com', '5552222222', '505 Spruce Street', 3),
--     ('Fiona', 'Hill', 'fiona.hill@example.com', '5551111111', '606 Willow Road', 4),
--     ('George', 'Ingram', 'george.ingram@example.com', '5550000000', '707 Fir Place', 5);
--
--











