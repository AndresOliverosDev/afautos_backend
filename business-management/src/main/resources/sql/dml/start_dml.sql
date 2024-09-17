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

/* Products */
INSERT INTO categories (cat_name, description) VALUES ('Electrónica', 'Productos electrónicos en general');
INSERT INTO brands (brand_name) VALUES ('Sony'),('Nokia');
