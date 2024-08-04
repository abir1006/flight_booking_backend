-- Insert sample data into the airport table

INSERT INTO airports (name, city, country, code) VALUES
('Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States', 'ATL'),
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
INSERT INTO users ( firstname, lastname, email, password, phone, address, role) VALUES
('John', 'Doe', 'john.doe@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '1234567890', '123 Main St', 'USER'),
( 'Jane', 'Smith', 'jane.smith@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '0987654321', '456 Elm St', 'ADMIN'),
( 'Alice', 'Johnson', 'alice.johnson@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '1112223333', '789 Pine St', 'USER'),
( 'Bob', 'Williams', 'bob.williams@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '2223334444', '101 Maple St', 'USER'),
('Carol', 'Brown', 'carol.brown@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '3334445555', '202 Oak St', 'ADMIN'),
( 'David', 'Jones', 'david.jones@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '4445556666', '303 Cedar St', 'USER'),
( 'Eva', 'Garcia', 'eva.garcia@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '5556667777', '404 Birch St', 'USER'),
( 'Frank', 'Martinez', 'frank.martinez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '6667778888', '505 Walnut St', 'ADMIN'),
('Grace', 'Hernandez', 'grace.hernandez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '7778889999', '606 Cherry St', 'USER'),
('Henry', 'Lopez', 'henry.lopez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '8889990000', '707 Ash St', 'ADMIN');


-- Insert sample data into the flight table
INSERT INTO flight (flight_number, departure_airport_id, arrival_airport_id, departure_date, arrival_date, departure_time, arrival_time, available_seats, ticket_price, flight_logo)
VALUES
    ('AA101', 1, 2, '2024-08-18', '2024-08-18', '08:00:00', '12:00:00', 120, 299.99, 'https://www.aa.com/content/images/trademarks/trademark-AA.png'),
    ('BA202', 2, 3, '2024-08-18', '2024-08-18', '09:00:00', '13:00:00', 150, 399.99, 'https://www.britishairways.com/assets/images/trademark-BA.png'),
    ('DL303', 3, 4, '2024-08-18', '2024-08-18', '10:00:00', '14:00:00', 180, 499.99, 'https://www.delta.com/content/images/trademarks/trademark-DL.png'),
    ('UA404', 4, 5, '2024-08-18', '2024-08-18', '11:00:00', '15:00:00', 200, 599.99, 'https://www.united.com/assets/images/trademarks/trademark-UA.png'),
    ('AF505', 5, 6, '2024-08-18', '2024-08-18', '12:00:00', '16:00:00', 220, 699.99, 'https://www.airfrance.com/assets/images/trademark-AF.png'),
    ('EK606', 6, 7, '2024-08-18', '2024-08-18', '13:00:00', '17:00:00', 140, 319.99, 'https://www.emirates.com/assets/images/trademark-EK.png'),
    ('SQ707', 7, 8, '2024-08-18', '2024-08-18', '14:00:00', '18:00:00', 160, 419.99, 'https://www.singaporeair.com/assets/images/trademark-SQ.png'),
    ('CX808', 8, 9, '2024-08-18', '2024-08-18', '15:00:00', '19:00:00', 180, 519.99, 'https://www.cathaypacific.com/assets/images/trademark-CX.png'),
    ('LH909', 9, 10, '2024-08-18', '2024-08-18', '16:00:00', '20:00:00', 200, 619.99, 'https://www.lufthansa.com/assets/images/trademark-LH.png'),
    ('QR1010', 10, 11, '2024-08-18', '2024-08-18', '17:00:00', '21:00:00', 120, 279.99, 'https://www.qatarairways.com/assets/images/trademark-QR.png'),
    ('BA1111', 11, 12, '2024-08-19', '2024-08-19', '08:00:00', '12:00:00', 150, 379.99, 'https://www.britishairways.com/assets/images/trademark-BA.png'),
    ('AA1212', 12, 13, '2024-08-19', '2024-08-19', '09:00:00', '13:00:00', 170, 479.99, 'https://www.aa.com/content/images/trademarks/trademark-AA.png'),
    ('UA1313', 13, 14, '2024-08-19', '2024-08-19', '10:00:00', '14:00:00', 190, 579.99, 'https://www.united.com/assets/images/trademark-UA.png'),
    ('DL1414', 14, 15, '2024-08-19', '2024-08-19', '11:00:00', '15:00:00', 210, 679.99, 'https://www.delta.com/content/images/trademarks/trademark-DL.png'),
    ('EK1515', 15, 16, '2024-08-19', '2024-08-19', '12:00:00', '16:00:00', 230, 779.99, 'https://www.emirates.com/assets/images/trademark-EK.png'),
    ('SQ1616', 16, 17, '2024-08-19', '2024-08-19', '13:00:00', '17:00:00', 150, 329.99, 'https://www.singaporeair.com/assets/images/trademark-SQ.png'),
    ('AF1717', 17, 18, '2024-08-19', '2024-08-19', '14:00:00', '18:00:00', 170, 429.99, 'https://www.airfrance.com/assets/images/trademark-AF.png'),
    ('LH1818', 18, 19, '2024-08-19', '2024-08-19', '15:00:00', '19:00:00', 190, 529.99, 'https://www.lufthansa.com/assets/images/trademark-LH.png'),
    ('CX1919', 19, 20, '2024-08-19', '2024-08-19', '16:00:00', '20:00:00', 210, 629.99, 'https://www.cathaypacific.com/assets/images/trademark-CX.png'),
    ('QR2020', 20, 21, '2024-08-19', '2024-08-19', '17:00:00', '21:00:00', 130, 289.99, 'https://www.qatarairways.com/assets/images/trademark-QR.png'),
    ('BA2121', 21, 22, '2024-08-20', '2024-08-20', '08:00:00', '12:00:00', 160, 389.99, 'https://www.britishairways.com/assets/images/trademark-BA.png'),
    ('AA2222', 22, 23, '2024-08-20', '2024-08-20', '09:00:00', '13:00:00', 180, 489.99, 'https://www.aa.com/content/images/trademarks/trademark-AA.png'),
    ('UA2323', 23, 24, '2024-08-20', '2024-08-20', '10:00:00', '14:00:00', 200, 589.99, 'https://www.united.com/assets/images/trademark-UA.png'),
    ('DL2424', 24, 25, '2024-08-20', '2024-08-20', '11:00:00', '15:00:00', 220, 689.99, 'https://www.delta.com/content/images/trademarks/trademark-DL.png'),
    ('EK2525', 25, 26, '2024-08-20', '2024-08-20', '12:00:00', '16:00:00', 240, 789.99, 'https://www.emirates.com/assets/images/trademarks/EK.png'),
    ('SQ2626', 26, 27, '2024-08-20', '2024-08-20', '13:00:00', '17:00:00', 160, 339.99, 'https://www.singaporeair.com/assets/images/trademarks/SQ.png')











