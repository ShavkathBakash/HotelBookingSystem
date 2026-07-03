-- ==========================================
-- HOTEL BOOKING SYSTEM DATABASE
-- ==========================================

CREATE DATABASE IF NOT EXISTS hotel_booking_system;

USE hotel_booking_system;

-- ==========================================
-- HOTEL TABLE
-- ==========================================

CREATE TABLE hotel (

    hotel_id INT PRIMARY KEY AUTO_INCREMENT,

    hotel_name VARCHAR(100),

    location VARCHAR(100),

    price_per_night DOUBLE

);

-- ==========================================
-- BOOKING TABLE
-- ==========================================

CREATE TABLE booking (

    booking_id INT PRIMARY KEY AUTO_INCREMENT,

    customer_name VARCHAR(100),

    hotel_id INT,

    nights INT,

    FOREIGN KEY (hotel_id)
        REFERENCES hotel(hotel_id)
        ON DELETE CASCADE

);

-- ==========================================
-- SAMPLE HOTEL DATA
-- ==========================================

INSERT INTO hotel(hotel_name, location, price_per_night)
VALUES
('Taj Hotel','Mumbai',5000),
('ITC Grand','Hyderabad',4200),
('Novotel','Bangalore',3500),
('Radisson Blu','Chennai',4600);

-- ==========================================
-- SAMPLE BOOKINGS
-- ==========================================

INSERT INTO booking(customer_name,hotel_id,nights)
VALUES
('Rahul',1,2),
('Shaariq',2,3),
('Ayesha',3,1);