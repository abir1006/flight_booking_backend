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
('Incheon International Airport', 'Seoul', 'South Korea', 'ICN');

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


-- Insert FlightSchedules
INSERT INTO flight_schedule (departure_date, arrival_date, departure_time, arrival_time) VALUES
 ('2024-08-10', '2024-08-10', '08:00:00', '12:00:00'),
 ('2024-08-11', '2024-08-11', '09:00:00', '13:00:00'),
 ('2024-08-12', '2024-08-12', '10:00:00', '14:00:00'),
 ('2024-08-13', '2024-08-13', '11:00:00', '15:00:00'),
 ('2024-08-14', '2024-08-14', '12:00:00', '16:00:00');

-- Insert Flights
INSERT INTO flight (flight_number, departure_airport_id, arrival_airport_id, flight_schedule_id, available_seats, flight_logo, ticket_price) VALUES
('AA101', 1, 2, 1, 100, 'logo1.png', 500.00),
('AA102', 2, 3, 2, 150, 'logo2.png', 450.00),
('AA103', 3, 4, 3, 200, 'logo3.png', 400.00),
('AA104', 4, 5, 4, 180, 'logo4.png', 600.00),
('AA105', 5, 1, 5, 120, 'logo5.png', 550.00);

-- Insert Bookings
INSERT INTO booking (booking_date, status, trip_type, total_price, flight_id) VALUES
('2024-08-01', 'booked without payment', 'round-trip', 1000.00, 1),
('2024-08-02', 'booked with payment', 'one-way', 450.00, 2),
('2024-08-03', 'e ticket generated', 'round-trip', 1200.00, 3);

-- Insert Passengers
INSERT INTO passenger (first_name, last_name, email, phone, address, booking_id) VALUES
('John', 'Doe', 'john.doe@example.com', '1234567890', '123 Elm Street', 1),
('Jane', 'Doe', 'jane.doe@example.com', '1234567891', '456 Oak Street', 1),
('Michael', 'Smith', 'michael.smith@example.com', '1234567892', '789 Pine Street', 2),
('Emily', 'Davis', 'emily.davis@example.com', '1234567893', '101 Maple Street', 2),
('David', 'Wilson', 'david.wilson@example.com', '1234567894', '102 Cedar Street', 2),
('Sarah', 'Johnson', 'sarah.johnson@example.com', '1234567895', '103 Birch Street', 3),
('Chris', 'Lee', 'chris.lee@example.com', '1234567896', '104 Walnut Street', 3),
('Jessica', 'Taylor', 'jessica.taylor@example.com', '1234567897', '105 Chestnut Street', 3);
