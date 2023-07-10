CREATE DATABASE IF NOT EXISTS DB;
create table IF NOT EXISTS DB.make(
make_id int NOT NULL AUTO_INCREMENT primary key,
name varchar(128) NOT NULL,
slug varchar(128) NOT NUll);

CREATE TABLE IF NOT EXISTS DB.type(
    type_id int NOT NULL AUTO_INCREMENT primary key,
    name varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS DB.model(
    model_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    model_name varchar(64),
    model_slug  varchar(64),
    make_id int NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (make_id) REFERENCES make(make_id),
    FOREIGN KEY (type_id) REFERENCES type(type_id)
);
create table IF NOT EXISTS DB.vehicle(
vehicle_id int NOT NULL AUTO_INCREMENT primary key,
slug varchar(128) NOT NULL,
vehicle_name varchar(128) NOT NUll,
vehicle_year integer(4) NOT NULL,
vehicle_price integer NOT NULL,
vehicle_vin varchar(17) NOT NULL,
make_id integer NOT NULL,
model_id INT NOT NULL,
FOREIGN KEY (make_id) REFERENCES make(make_id),
FOREIGN KEY (model_id) REFERENCES model(model_id)
);
