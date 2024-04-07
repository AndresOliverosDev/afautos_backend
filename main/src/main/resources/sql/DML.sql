USE afautos;

-- Insertar roles
INSERT INTO roles (rol_name, `description`) VALUES
('Admin', 'Administrador del sistema'),
('User', 'Usuario estándar');

-- Insertar tipos de documentos
INSERT INTO document_type (doc_type_name) VALUES
('Cédula de Ciudadanía'),
('Cédula de Extranjería'),
('Pasaporte');

-- Insertar usuarios
INSERT INTO users (user_id, pass, email, phone, `names`, lastname, doc_type, birthday) VALUES
('user01', 'password01', 'user01@example.com', '1234567890', 'Juan', 'Pérez', 1, '1990-05-15'),
('user02', 'password02', 'user02@example.com', '2345678901', 'María', 'Gómez', 1, '1985-08-20'),
('user03', 'password03', 'user03@example.com', '3456789012', 'Luis', 'Rodríguez', 2, '1992-03-10'),
('user04', 'password04', 'user04@example.com', '4567890123', 'Ana', 'Martínez', 1, '1988-11-25'),
('user05', 'password05', 'user05@example.com', '5678901234', 'Carlos', 'Hernández', 3, '1995-07-03'),
('user06', 'password06', 'user06@example.com', '6789012345', 'Sofía', 'López', 1, '1983-09-12'),
('user07', 'password07', 'user07@example.com', '7890123456', 'Diego', 'Ramírez', 2, '1991-01-30'),
('user08', 'password08', 'user08@example.com', '8901234567', 'Laura', 'Díaz', 1, '1987-06-18'),
('user09', 'password09', 'user09@example.com', '9012345678', 'Pedro', 'Sánchez', 1, '1993-04-28'),
('user10', 'password10', 'user10@example.com', '0123456789', 'Camila', 'Pérez', 4, '1980-12-05'),
('user11', 'password11', 'user11@example.com', '9876543210', 'Andrés', 'González', 1, '1984-02-14'),
('user12', 'password12', 'user12@example.com', '8765432109', 'Valentina', 'Jiménez', 1, '1996-10-08'),
('user13', 'password13', 'user13@example.com', '7654321098', 'Javier', 'Molina', 2, '1990-07-17'),
('user14', 'password14', 'user14@example.com', '6543210987', 'Isabella', 'Duarte', 1, '1986-04-22'),
('user15', 'password15', 'user15@example.com', '5432109876', 'Miguel', 'Suárez', 3, '1994-08-31'),
('user16', 'password16', 'user16@example.com', '4321098765', 'Gabriela', 'Castro', 1, '1989-11-11'),
('user17', 'password17', 'user17@example.com', '3210987654', 'Alejandro', 'Ortiz', 2, '1992-06-27'),
('user18', 'password18', 'user18@example.com', '2109876543', 'Natalia', 'Rojas', 1, '1997-03-05'),
('user19', 'password19', 'user19@example.com', '1098765432', 'Daniel', 'Chávez', 1, '1982-09-19'),
('user20', 'password20', 'user20@example.com', '0987654321', 'Carolina', 'Vargas', 4, '1998-01-22');

-- Insertar roles de usuario con fecha de registro
INSERT INTO users_roles (rol_id, user, state, date_activated) VALUES
(1, 'user01', 'Active', '2024-04-03'),
(2, 'user02', 'Active', '2024-04-03'),
(2, 'user03', 'Active', '2024-04-03'),
(1, 'user04', 'Active', '2024-04-03'),
(2, 'user05', 'Active', '2024-04-03'),
(1, 'user06', 'Active', '2024-04-03'),
(2, 'user07', 'Active', '2024-04-03'),
(1, 'user08', 'Active', '2024-04-03'),
(1, 'user09', 'Active', '2024-04-03'),
(1, 'user10', 'Active', '2024-04-03'),
(2, 'user11', 'Active', '2024-04-03'),
(2, 'user12', 'Active', '2024-04-03'),
(1, 'user13', 'Active', '2024-04-03'),
(2, 'user14', 'Active', '2024-04-03'),
(1, 'user15', 'Active', '2024-04-03'),
(1, 'user16', 'Active', '2024-04-03'),
(2, 'user17', 'Active', '2024-04-03'),
(1, 'user18', 'Active', '2024-04-03'),
(1, 'user19', 'Active', '2024-04-03'),
(2, 'user20', 'Active', '2024-04-03');