use afautos;

/* Departments */
INSERT departments(depart_name) VALUES("Bogota");

/* Cities */
INSERT cities(city_name, depart) VALUES("Bogota", 1);

/* Neighborhoods */
INSERT neighborhoods(neighborhood_name, city) VALUES("Kennedy", 1);