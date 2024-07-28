-- Insert sample data into the airport table
INSERT INTO airport (name, city, country, code) VALUES
('Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States', 'ATL'),
('Beijing Capital International Airport', 'Beijing', 'China', 'PEK'),
('Los Angeles International Airport', 'Los Angeles', 'United States', 'LAX'),
('Dubai International Airport', 'Dubai', 'United Arab Emirates', 'DXB'),
('Tokyo Haneda Airport', 'Tokyo', 'Japan', 'HND'),
('London Heathrow Airport', 'London', 'United Kingdom', 'LHR'),
('Paris Charles de Gaulle Airport', 'Paris', 'France', 'CDG'),
('Amsterdam Schiphol Airport', 'Amsterdam', 'Netherlands', 'AMS'),
('Singapore Changi Airport', 'Singapore', 'Singapore', 'SIN'),
('Incheon International Airport', 'Seoul', 'South Korea', 'ICN');

-- Insert users
-- password for all user is "123"
INSERT INTO _user (id, firstname, lastname, email, password, phone, address, role) VALUES
(1, 'John', 'Doe', 'john.doe@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '1234567890', '123 Main St', 'USER'),
(2, 'Jane', 'Smith', 'jane.smith@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '0987654321', '456 Elm St', 'ADMIN'),
(3, 'Alice', 'Johnson', 'alice.johnson@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '1112223333', '789 Pine St', 'USER'),
(4, 'Bob', 'Williams', 'bob.williams@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '2223334444', '101 Maple St', 'USER'),
(5, 'Carol', 'Brown', 'carol.brown@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '3334445555', '202 Oak St', 'ADMIN'),
(6, 'David', 'Jones', 'david.jones@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '4445556666', '303 Cedar St', 'USER'),
(7, 'Eva', 'Garcia', 'eva.garcia@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '5556667777', '404 Birch St', 'USER'),
(8, 'Frank', 'Martinez', 'frank.martinez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '6667778888', '505 Walnut St', 'ADMIN'),
(9, 'Grace', 'Hernandez', 'grace.hernandez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '7778889999', '606 Cherry St', 'USER'),
(10, 'Henry', 'Lopez', 'henry.lopez@example.com', '$2a$10$zn7lm9rpKFkRtS23ngkXLOrxQ7ORA5gFj8UIoVa3AjtkgpUvTE22W', '8889990000', '707 Ash St', 'ADMIN');

