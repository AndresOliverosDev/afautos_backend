/* Users */
USE afautos;
INSERT roles(rol_name) VALUES ("ADMIN"),("LOGISTICA"),("VENTAS"),("CLIENTE");

INSERT `permissions`(permission_name) VALUES ("CREATE"),("READ"),("UPDATE"),("DELETE");

INSERT document_type(doc_type_name) VALUES ("CC"),("CE"),("NIT");
INSERT roles_permissions VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,2);

/* Departments */
INSERT departments(depart_name) VALUES("Bogota");

/* Cities */
INSERT cities(city_name, depart) VALUES("Bogota", 1);

/* Neighborhoods */
INSERT neighborhoods(neighborhood_name, city) VALUES("Kennedy", 1);

/* User */
INSERT users VALUES
('1000253253', "andresDev",'passwordNoEncode', 'andres@example.com', '3223883144', 'Andres', 1, '2023-01-02', TRUE, TRUE, TRUE, TRUE);

/* Address */
INSERT address(ref, neighborhood, user) VALUES("Cra 119 #64-80", 1, "1000253253");

/* Products */
INSERT INTO categories (cat_name, description) VALUES ('Electrónica', 'Productos electrónicos en general');
INSERT INTO brands (brand_name) VALUES ('Sony'),('Nokia');
INSERT INTO products (prod_name, description, quantity, price, image_url, cat, brand) 
VALUES ('Televisor LED', 'Televisor LED de alta definición', 50, 599.99, 'https://example.com/tv.jpg', 1, 1);

/* Sale */
INSERT sales(sale_date, pay_method, total_price, customer, address) VALUES ("2024-02-01", "TC", 35000.00, "1000253253", 1);

/* Orders */
INSERT orders(order_date, order_state, observations, sale, employee) VALUES
("2024-12-19", "EN PROCESO", "El pedido se realizara por Servientrega", 1, "1000253253");

/* Order Details */
INSERT order_details(order_id, product, quantity) VALUES (1, 1, 10);
