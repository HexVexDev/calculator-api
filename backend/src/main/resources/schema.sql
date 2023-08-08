CREATE DATABASE IF NOT EXISTS DB;
USE DB;
create table IF NOT EXISTS make(
make_id int NOT NULL AUTO_INCREMENT primary key,
make_name varchar(128) NOT NULL,
make_slug varchar(128) NOT NUll);

CREATE TABLE IF NOT EXISTS type(
    type_id int NOT NULL AUTO_INCREMENT primary key,
    type_name varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS model(
    model_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model_name varchar(64),
    model_slug  varchar(64),
    make_id int NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (make_id) REFERENCES make(make_id) ,
    FOREIGN KEY (type_id) REFERENCES type(type_id)
);
CREATE TABLE IF NOT EXISTS vehicle(
vehicle_id int NOT NULL AUTO_INCREMENT primary key,
vehicle_slug varchar(128) NOT NULL,
vehicle_name varchar(128) NOT NUll,
vehicle_year integer(4) NOT NULL,
vehicle_price integer NOT NULL,
vehicle_vin varchar(17) NOT NULL,
make_id integer NOT NULL,
model_id INT NOT NULL,
FOREIGN KEY (make_id) REFERENCES make(make_id) ,
FOREIGN KEY (model_id) REFERENCES model(model_id)
);

CREATE TABLE IF NOT EXISTS users(
  username varchar(20) NOT NULL,
  password varchar(10) NOT NULL
)
