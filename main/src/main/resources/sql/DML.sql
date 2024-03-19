USE afautos;

/* User */

/* Document Type */
INSERT document_type(doc_type_name) VALUES("Cédula de ciudadanía");
INSERT roles(rol_name, description) VALUES("Dev Spring Boot","Developer Java Spring Boot");

/* Address */

/* Departments Insert */
INSERT departments(depart_name) VALUES("Huila");
/* City Insert */
INSERT cities(city_name, depart) VALUES("Isnos",1);
/* Neighborhood Insert */
INSERT neighborhoods(neighborhood_name, city) VALUES("Salta de Bordones",1);


