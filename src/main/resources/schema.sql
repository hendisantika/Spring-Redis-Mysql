-- Create database (if not automatically created)
CREATE DATABASE IF NOT EXISTS countries;
USE countries;

-- Create country table
CREATE TABLE IF NOT EXISTS country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(10) NOT NULL,
    capital VARCHAR(255) NOT NULL
);

-- Insert sample data
INSERT INTO country (name, code, capital) VALUES
('Indonesia', 'ID', 'Jakarta'),
('United States', 'US', 'Washington D.C.'),
('Japan', 'JP', 'Tokyo'),
('Singapore', 'SG', 'Singapore'),
('Malaysia', 'MY', 'Kuala Lumpur');
