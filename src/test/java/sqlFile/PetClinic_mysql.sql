create database Pet_Clinic;

use Pet_Clinic;

drop database Pet_Clinic;

create table `Role`(
	role_id int primary key not null auto_increment,
	role_name varchar(50) not null
);

create table `User`(
	`user_id` int primary key not null auto_increment,
	role_id int not null, 
    foreign key(role_id) references `Role`(role_id),
	username varchar(50) not null,
	`password` varchar(10) not null,
	full_name varchar(50) not null,
	gender smallint,
	dob date,
	email varchar(50) not null,
	`address` varchar(250) not null,
	phone_number varchar(11) not null
);

create table DoctorLevel(
	doctor_level_id int primary key not null auto_increment,
	`user_id` int not null, 
    foreign key(`user_id`) references `User`(`user_id`),
	title varchar(50) not null,
	degree varchar(50) not null,
	update_date date
);

create table DoctorSchedual(
	doctor_schedual_id int primary key not null auto_increment,
	`user_id` int  not null, 
    foreign key(`user_id`) references `User`(`user_id`),
	doctor_schedual_date date,
	doctor_schedual_time varchar(50)
);

create table Pet(
	pet_id int primary key auto_increment not null,
	`user_id` int not null, 
    foreign key(`user_id`) references `User`(`user_id`),
	pet_name varchar(50),
	pet_type varchar(50) not null,
	pet_gender smallint,
	pet_weight float,
	pet_age smallint
);

create table `Service`(
	service_id int primary key auto_increment not null,
	`service_name` varchar(50) not null,
	service_price decimal(10, 2),
	service_type varchar(50) not null
);

create table Booking(
	booking_id int primary key auto_increment not null,
	service_id int  not null, 
    foreign key(service_id) references `Service`(service_id),
	pet_id int  not null, 
    foreign key(pet_id) references Pet(pet_id),
	booking_date date not null,
	booking_time varchar(10) not null,
	price decimal(10, 2),
	update_date date
);

alter table Booking
add column (user_id);

alter table Booking
add foreign key(user_id) references User`(user_id`);

create table Prescription(
	prescription_id int primary key auto_increment not null,
	prescription_date date
);

create table Bill(
	bill_id int primary key auto_increment not null,
	booking_id int  not null, 
    foreign key(booking_id) references Booking(booking_id),
	`user_id` int  not null, 
    foreign key(`user_id`) references `User`(`user_id`),
	prescription_id int, 
    foreign key(prescription_id) references Prescription(prescription_id),
	bill_date date,
	total decimal(10, 2),
	title_bill varchar(50)
);

create table Medication(
	medication_id int primary key auto_increment not null,
	medication_name varchar(50) not null,
	`description` varchar(50),
	price decimal(10, 2)
);

create table PrescriptionDetail(
	medication_manage_id int primary key auto_increment not null,
	prescription_id int,
    foreign key(prescription_id) references Prescription(prescription_id),
	medication_id int, 
    foreign key(medication_id) references Medication(medication_id)
);
