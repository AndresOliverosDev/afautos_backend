INSERT roles(rol_name)
VALUES ("ADMIN"),("LOGÍSTICA"),("VENTAS"),("CLIENTE");

INSERT `permissions`(permission_name)
    VALUES ("CREATE"),("READ"),("UPDATE"),("DELETE");

INSERT document_type(doc_type_name)
    VALUES ("CC"),("CE"),("NIT");

INSERT roles_permissions
    VALUES (1,1),(1,2),(1,3),(1,4),(2,2),(2,3),(3,1),(3,2),(3,3),(4,2);
