INSERT roles(rol_name) VALUES ("ADMIN"),("LOGÍSTICA"),("VENTAS"),("CLIENTE");

INSERT `permissions`(permission_name) VALUES ("CREATE"),("READ"),("UPDATE"),("DELETE");

INSERT document_type(doc_type_name) VALUES ("CC"),("CE"),("NIT");

INSERT users
VALUES ('1000253253', "andresDev",'passwordNoEncode', 'andres@example.com', '3223883144', 'Andres', 'Oliveros', 1, '2023-01-02', TRUE, TRUE, TRUE, TRUE),
('1458452658', "juan",'passwordNoEncode2', 'juan@example.com', '3223883124', 'Juan', 'Lopez', 1, '2023-01-02', TRUE, TRUE, TRUE, TRUE),
('1234567890','pedro', 'passwordNoEncode1', 'Pedro@example.com', '9876543210', 'Pedro', 'Smith', 2, '1995-05-15', TRUE, TRUE, TRUE, TRUE);

INSERT users_roles VALUES ("1000253253",1),("1234567890",4),("1458452658",2),("1458452658",3);
INSERT roles_permissions VALUES (1,1),(1,2),(1,3),(1,4),(2,2),(2,3),(3,1),(3,2),(3,3),(4,2);