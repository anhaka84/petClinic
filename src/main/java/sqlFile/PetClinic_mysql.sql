CREATE DATABASE `PetClinic`;

USE `PetClinic`;

-- DROP DATABASE `Pet_Clinic`;

-- SELECT u.*, dl.*, ds.* 
-- FROM pet_clinic.User AS u 
-- INNER JOIN pet_clinic.DoctorLevel AS dl 
-- ON u.user_id = dl.user_id
-- INNER JOIN pet_clinic.doctorschedual AS ds
-- ON u.user_id = ds.user_id
-- WHERE u.user_id = 2;

CREATE TABLE `Role` (
    `roleId` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `roleName` VARCHAR(10) NOT NULL
);

CREATE TABLE `User` (
    `user_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `role_id` INT NOT NULL, 
    FOREIGN KEY (`role_id`) REFERENCES `Role`(`role_id`),
    `full_name` VARCHAR(50) NOT NULL,
    `gender` INT,
    `dob` DATE,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `address` VARCHAR(255) NOT NULL,
    `phone_number` CHAR(10) NOT NULL,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    `status` INT NOT NULL
);

CREATE TABLE `DoctorLevel` (
    `doctor_level_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `user_id` INT NOT NULL, 
    FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`),
    `title` VARCHAR(50) NOT NULL,
    `degree` VARCHAR(50) NOT NULL,
    `update_date` DATE
);

CREATE TABLE `DoctorSchedual` (
    `doctor_schedual_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `user_id` INT  NOT NULL, 
    FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`),
    `doctor_schedual_date` DATE,
    `doctor_schedual_time` VARCHAR(50)
);

CREATE TABLE `Pet` (
    `pet_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `user_id` INT NOT NULL, 
    FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`),
    `pet_type` VARCHAR(50) NOT NULL,
    `pet_name` VARCHAR(50),
    `pet_gender` INT,
    `pet_weight` FLOAT,
    `pet_age` INT
);

CREATE TABLE `Service` (
    `service_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `service_name` VARCHAR(50) NOT NULL,
    `service_type` VARCHAR(50) NOT NULL,
    `service_price` DECIMAL(10, 2)
);

CREATE TABLE `Booking` (
    `booking_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `service_id` INT  NOT NULL, 
    FOREIGN KEY(`service_id`) REFERENCES `Service`(`service_id`),
    `user_id` INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES `User`(`user_id`),
    `pet_id` INT  NOT NULL, 
    FOREIGN KEY(`pet_id`) REFERENCES `Pet`(`pet_id`),
    `booking_date` DATE NOT NULL,
    `booking_time` VARCHAR(10) NOT NULL,
    `update_date` DATE,
    `price` DECIMAL(10, 2)
);

CREATE TABLE `Prescription` (
    `prescription_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `prescription_date` DATE
);

CREATE TABLE `Bill` (
    `bill_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `booking_id` INT  NOT NULL, 
    FOREIGN KEY(`booking_id`) REFERENCES `Booking`(`booking_id`),
    `user_id` INT  NOT NULL, 
    FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`),
    `prescription_id` INT, 
    FOREIGN KEY(`prescription_id`) REFERENCES `Prescription`(`prescription_id`),
    `bill_date` DATE,
    `title_bill` VARCHAR(50),
    `total` DECIMAL(10, 2)
);

CREATE TABLE `Medication` (
    `medication_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `medication_name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(50),
    `price` DECIMAL(10, 2)
);

CREATE TABLE `PrescriptionDetail` (
    `medication_manage_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `prescription_id` INT,
    FOREIGN KEY(`prescription_id`) REFERENCES `Prescription`(`prescription_id`),
    `medication_id` INT,
    FOREIGN KEY(`medication_id`) REFERENCES `Medication`(`medication_id`)
);
