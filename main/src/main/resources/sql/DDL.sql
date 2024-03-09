DROP DATABASE afautos;
CREATE DATABASE IF NOT EXISTS afautos;

USE afautos;

/* User Rol */
CREATE TABLE IF NOT EXISTS rol (
	id_rol TINYINT,
    name_rol VARCHAR(20),
    PRIMARY KEY(id_rol)
);

/*     Users    */
CREATE TABLE IF NOT EXISTS users (
    ced_user VARCHAR(15),
    pass VARCHAR(128) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(10) UNIQUE NOT NULL,
    names VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    doc_type VARCHAR(15) NOT NULL,
    birthday DATE NOT NULL,
    
    PRIMARY KEY(ced_user)
);

CREATE TABLE IF NOT EXISTS rol_users (
	id_rol TINYINT,
    id_user VARCHAR(15),
    state VARCHAR(15) NOT NULL,
    date_activated DATE NOT NULL,
    
    CONSTRAINT fk_rol_user FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    CONSTRAINT fk_user_rol FOREIGN KEY (id_user) REFERENCES users(ced_user)
);

/*  Address */
CREATE TABLE IF NOT EXISTS departaments (
id_depart TINYINT AUTO_INCREMENT,		
name_depart VARCHAR(60) NOT NULL,

PRIMARY KEY(id_depart)
);

CREATE TABLE IF NOT EXISTS cities (
id_city SMALLINT AUTO_INCREMENT,
name_city VARCHAR(60),
depart TINYINT,

PRIMARY KEY(id_city),
CONSTRAINT fk_depart_city FOREIGN KEY(depart) REFERENCES departaments(id_depart)
);

CREATE TABLE IF NOT EXISTS neighborhoods(
	id_neighborhood INTEGER AUTO_INCREMENT,
    name_neighborhood VARCHAR(60),
    city SMALLINT,
    
    PRIMARY KEY(id_neighborhood),
    CONSTRAINT fk_city_neigborhood FOREIGN KEY(city) REFERENCES cities(id_city)
);

CREATE TABLE IF NOT EXISTS address (
    id_addr INTEGER AUTO_INCREMENT,
    ref VARCHAR(100),
    neighborhood INTEGER,
    ced_user VARCHAR(15),
    
    PRIMARY KEY(id_addr),
    CONSTRAINT fk_address_neighborhood FOREIGN KEY(neighborhood) REFERENCES neighborhoods(id_neighborhood),
    CONSTRAINT fk_address_user FOREIGN KEY(ced_user) REFERENCES users(ced_user)
);

/*  Store Process  */
CREATE TABLE IF NOT EXISTS sales (
    id_sale INTEGER AUTO_INCREMENT,
    date_order DATETIME NOT NULL,
    pay_method VARCHAR(20) NOT NULL,
    ced_user VARCHAR(15),
    address VARCHAR(100),
    
    PRIMARY KEY(id_sale),
    CONSTRAINT fk_user_sales FOREIGN KEY(ced_user) REFERENCES users(ced_user)
);

CREATE TABLE IF NOT EXISTS orders (
    id_order INTEGER AUTO_INCREMENT,
    `date` DATETIME NOT NULL,
    `state` VARCHAR(15) NOT NULL,
    id_sale INTEGER,
    ced_user VARCHAR(15),
    PRIMARY KEY(id_order),
    CONSTRAINT fk_sales_orders FOREIGN KEY(id_sale) REFERENCES sales(id_sale),
    CONSTRAINT fk_user_orders FOREIGN KEY(ced_user) REFERENCES users(ced_user)
);

/*  Products   */
CREATE TABLE IF NOT EXISTS categories (
    id_cat TINYINT AUTO_INCREMENT,
    name_cat VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY(id_cat)
);

CREATE TABLE IF NOT EXISTS brands (
    id_brand SMALLINT AUTO_INCREMENT,
    name_brand VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY(id_brand)
);

CREATE TABLE IF NOT EXISTS products (
    id_prod VARCHAR(30),
    name_prod VARCHAR(30),
    `description` VARCHAR(100),
    quantity SMALLINT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    id_cat TINYINT,
    id_brand SMALLINT,
    PRIMARY KEY(id_prod),
    CONSTRAINT fk_categories_prod FOREIGN KEY(id_cat) REFERENCES categories(id_cat),
    CONSTRAINT fk_brand_prod FOREIGN KEY(id_brand) REFERENCES brands(id_brand)
);

CREATE TABLE IF NOT EXISTS products_sales (
    id_prod VARCHAR(30),
    id_sale INTEGER,
    quantity TINYINT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_products FOREIGN KEY(id_prod) REFERENCES products(id_prod),
    CONSTRAINT fk_sales FOREIGN KEY(id_sale) REFERENCES sales(id_sale),
    PRIMARY KEY(id_prod, id_sale)
);

CREATE TABLE IF NOT EXISTS products_entry (
    id_entry INTEGER AUTO_INCREMENT,
    `date` DATETIME NOT NULL,
    ced_user VARCHAR(15),
    PRIMARY KEY(id_entry),
    CONSTRAINT fk_users_entry FOREIGN KEY(ced_user) REFERENCES users(ced_user)
);

CREATE TABLE IF NOT EXISTS products_entry_detail (
    id_entry INTEGER,
    id_prod VARCHAR(30),
    quantity SMALLINT NOT NULL,
    CONSTRAINT fk_entry_detail FOREIGN KEY(id_entry) REFERENCES products_entry(id_entry),
    CONSTRAINT fk_products_detail FOREIGN KEY(id_prod) REFERENCES products(id_prod),
    PRIMARY KEY(id_entry, id_prod)
);