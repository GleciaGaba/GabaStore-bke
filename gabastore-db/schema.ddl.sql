/*
 * DDL = Data Definition Language
 * Command lines from 'gabastore-db' folder:
 * psql -h localhost -p 5432 -U postgres -d gabastore
 * \i schema.ddl.sql
 * \q
 */


DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;


CREATE TABLE roles(  
	id SERIAL PRIMARY KEY,  
	name varchar(100) UNIQUE);
	

CREATE TABLE users(  
	id SERIAL PRIMARY KEY,  
	username varchar(255) UNIQUE NOT NULL,  
	password varchar(60) NOT NULL,
	role_id INTEGER,
    CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id));
    

    
CREATE TABLE categories(
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) UNIQUE NOT NULL);   
   


CREATE TABLE products(
   id SERIAL PRIMARY KEY,
   name varchar(255) UNIQUE NOT NULL, 
   description text NOT NULL,
   price DECIMAL(13,2) NOT NULL,
   image_url VARCHAR(255) NOT NULL,
   category_id INTEGER,
   CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories(id)); 


    
   
