DROP DATABASE afautos;
CREATE DATABASE IF NOT EXISTS afautos;

USE afautos;

/* User Rol */	
CREATE TABLE IF NOT EXISTS roles (
    rol_id TINYINT AUTO_INCREMENT,
    rol_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (rol_id)
);

CREATE TABLE IF NOT EXISTS `permissions` (  
    permission_id TINYINT AUTO_INCREMENT,
    permission_name VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (permission_id)
);

CREATE TABLE IF NOT EXISTS document_type (
    doc_type_id TINYINT AUTO_INCREMENT,
    doc_type_name VARCHAR(30) NOT NULL UNIQUE,
    
    PRIMARY KEY(doc_type_id)
);

/*     Users    */
CREATE TABLE IF NOT EXISTS users (
    user_id VARCHAR(15),
    username VARCHAR(30) UNIQUE NOT NULL,
    `password` VARCHAR(128) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(10) UNIQUE NOT NULL,
    `names` VARCHAR(30) NOT NULL,
    user_status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    doc_type TINYINT,
    birthday DATE NOT NULL,
    is_enable BOOLEAN,
    account_no_expired BOOLEAN,
    account_no_locked BOOLEAN,
    credential_no_expired BOOLEAN,

    PRIMARY KEY(user_id),
    CONSTRAINT fk_doc_type_users FOREIGN KEY(doc_type) REFERENCES document_type(doc_type_id)
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id VARCHAR(15),
    rol_id TINYINT,
    CONSTRAINT FK_users_roles FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_roles_users FOREIGN KEY (rol_id) REFERENCES roles(rol_id),
    PRIMARY KEY (user_id, rol_id) 
);

CREATE TABLE IF NOT EXISTS roles_permissions (
    rol_id TINYINT,
    permission_id TINYINT,
    CONSTRAINT FK_roles_permissions FOREIGN KEY (rol_id) REFERENCES roles(rol_id),
    CONSTRAINT FK_permissions_roles FOREIGN KEY (permission_id) REFERENCES `permissions`(permission_id),
    PRIMARY KEY (rol_id, permission_id) 
);

/*  Address */
CREATE TABLE IF NOT EXISTS departments (
depart_id TINYINT AUTO_INCREMENT,		
depart_name VARCHAR(60) NOT NULL,

PRIMARY KEY(depart_id)
);

CREATE TABLE IF NOT EXISTS cities (
city_id SMALLINT AUTO_INCREMENT,
city_name VARCHAR(60) NOT NULL,
depart TINYINT,

PRIMARY KEY(city_id),
CONSTRAINT fk_depart_city FOREIGN KEY(depart) REFERENCES departments(depart_id)
);

CREATE TABLE IF NOT EXISTS neighborhoods(
	neighborhood_id INTEGER AUTO_INCREMENT,
    neighborhood_name VARCHAR(60) NOT NULL,
    city SMALLINT,

    PRIMARY KEY(neighborhood_id),
    CONSTRAINT fk_city_neighborhood FOREIGN KEY(city) REFERENCES cities(city_id)
);

CREATE TABLE IF NOT EXISTS address (
    addr_id INTEGER AUTO_INCREMENT,
    ref VARCHAR(100) NOT NULL UNIQUE,
    neighborhood INTEGER,
    user VARCHAR(15),

    PRIMARY KEY(addr_id),
    CONSTRAINT fk_address_neighborhood FOREIGN KEY(neighborhood) REFERENCES neighborhoods(neighborhood_id),
    CONSTRAINT fk_address_user FOREIGN KEY(user) REFERENCES users(user_id)
);

/*  Store Process  */
CREATE TABLE IF NOT EXISTS sales (
    sale_id BIGINT AUTO_INCREMENT,
    sale_date DATETIME NOT NULL,
    pay_method VARCHAR(20) NOT NULL,
    total_price DECIMAL(10,2),
    customer VARCHAR(15),
    address VARCHAR(100),
    
    PRIMARY KEY(sale_id),
    CONSTRAINT fk_user_sales FOREIGN KEY(customer) REFERENCES users(user_id)
);

CREATE TABLE IF NOT EXISTS orders (
    order_id BIGINT AUTO_INCREMENT,
    order_date DATETIME NOT NULL,
    order_state VARCHAR(15) NOT NULL,
    observations VARCHAR(200),
    sale BIGINT,
    employee VARCHAR(15),
    PRIMARY KEY(order_id),
    CONSTRAINT fk_sales_orders FOREIGN KEY(sale) REFERENCES sales(sale_id),
    CONSTRAINT fk_user_orders FOREIGN KEY(employee) REFERENCES users(user_id)
);

/*  Products   */
CREATE TABLE IF NOT EXISTS categories (
    cat_id TINYINT AUTO_INCREMENT,
    cat_name VARCHAR(30) UNIQUE NOT NULL,
    `description` VARCHAR(120) NOT NULL,
    PRIMARY KEY(cat_id)
);

CREATE TABLE IF NOT EXISTS brands (
    brand_id SMALLINT AUTO_INCREMENT,
    brand_name VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY(brand_id)
);

CREATE TABLE IF NOT EXISTS products (
    prod_id BIGINT AUTO_INCREMENT,
    prod_name VARCHAR(30) NOT NULL UNIQUE,
    `description` VARCHAR(255),
    quantity SMALLINT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    image_url VARCHAR(255),
    cat TINYINT,
    brand SMALLINT,
    is_delete BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(prod_id),
    CONSTRAINT fk_categories_prod FOREIGN KEY(cat) REFERENCES categories(cat_id),
    CONSTRAINT fk_brand_prod FOREIGN KEY(brand) REFERENCES brands(brand_id)
);

/* Orders and sales details*/
CREATE TABLE IF NOT EXISTS sale_details (
    sale_detail_id BIGINT AUTO_INCREMENT,
    product BIGINT,
    sale BIGINT,
    quantity SMALLINT NOT NULL,
    price_unit DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,


    PRIMARY KEY(sale_detail_id),
    CONSTRAINT fk_products FOREIGN KEY(product) REFERENCES products(prod_id),
    CONSTRAINT fk_sales FOREIGN KEY(sale) REFERENCES sales(sale_id)
);

CREATE TABLE IF NOT EXISTS order_details (
    order_detail_id BIGINT AUTO_INCREMENT,
    order_id BIGINT,
    product BIGINT,
    quantity SMALLINT NOT NULL,

    PRIMARY KEY(order_detail_id),
    CONSTRAINT fk_orders_products FOREIGN KEY(order_id) REFERENCES orders(order_id),
    CONSTRAINT fk_products_orders FOREIGN KEY(product) REFERENCES products(prod_id)


);