use afautos;
-- Insertar categoría de repuestos para automóviles
INSERT INTO categories (cat_name, description) VALUES 
('Filtros', 'Filtros de aire, aceite, combustible, etc.'),
('Frenos', 'Pastillas de freno, discos de freno, líquido de frenos, etc.'),
('Baterías', 'Baterías de arranque para vehículos'),
('Lubricantes', 'Aceites de motor y lubricantes para vehículos');

-- Insertar marcas de repuestos para automóviles
INSERT INTO brands (brand_name) VALUES
('Bosch'),
('ACDelco'),
('Mann Filter'),
('Brembo'),
('Motul');

-- Insertar productos de repuestos para automóviles
INSERT INTO products (prod_name, description, quantity, price, image_url, cat, brand) VALUES
('Filtro de aire Bosch', 'Filtro de aire de alta calidad para automóviles', 50, 50000.00, 'https://img.freepik.com/foto-gratis/accesorios-coche-espacio-copia_23-2149030410.jpg?size=626&ext=jpg&ga=GA1.1.289359447.1706918376&semt=ais', 1, 1),
('Pastillas de freno ACDelco', 'Pastillas de freno de larga duración y alto rendimiento', 40, 75000.00, 'https://www.freepik.es/fotos-premium/nuevas-piezas-automoviles-metal-sobre-fondo-gris_8984114.htm#query=repuestos%20auto&position=6&from_view=keyword&track=ais&uuid=6fe9bc2e-9a21-4506-b12c-49fb1bdd1b67', 2, 2),
('Batería de arranque Mann Filter', 'Batería de arranque confiable para vehículos', 20, 200000.00, 'https://img.freepik.com/fotos-premium/piezas-coche-aisladas-blanco_241146-583.jpg?size=626&ext=jpg&ga=GA1.1.289359447.1706918376&semt=ais', 3, 3),
('Aceite de motor Motul 5W-30', 'Aceite de motor sintético de alto rendimiento', 30, 100000.00, 'https://img.freepik.com/foto-gratis/composicion-diferentes-accesorios-coche_23-2149030392.jpg?size=626&ext=jpg&ga=GA1.1.289359447.1706918376&semt=ais', 4, 5),
('Filtro de aceite Mann Filter', 'Filtro de aceite de alta eficiencia para motores', 60, 60000.00, 'https://www.freepik.es/foto-gratis/composicion-diferentes-accesorios-coche_16137856.htm#query=repuestos%20auto&position=8&from_view=keyword&track=ais&uuid=6fe9bc2e-9a21-4506-b12c-49fb1bdd1b67', 1, 3),
('Discos de freno Brembo', 'Discos de freno perforados y ventilados para alto rendimiento', 25, 150000.00, 'https://www.freepik.es/foto-gratis/nuevas-piezas-automoviles-metal-sobre-fondo-gris_8984114.htm#query=repuestos%20auto&position=6&from_view=keyword&track=ais&uuid=6fe9bc2e-9a21-4506-b12c-49fb1bdd1b67', 2, 4),
('Líquido de frenos Motul DOT 4', 'Líquido de frenos de alto rendimiento para sistemas de frenos avanzados', 35, 50000.00, 'https://www.freepik.es/foto-gratis/composicion-diferentes-accesorios-coche_16137857.htm#query=repuestos%20auto&position=23&from_view=keyword&track=ais&uuid=6fe9bc2e-9a21-4506-b12c-49fb1bdd1b67', 2, 5),
('Filtro de combustible Mann Filter', 'Filtro de combustible de alta eficiencia para motores a gasolina y diésel', 55, 70000.00, 'https://www.freepik.es/foto-gratis/accesorios-coche-espacio-copia_16137815.htm#query=repuestos%20auto&position=24&from_view=keyword&track=ais&uuid=6fe9bc2e-9a21-4506-b12c-49fb1bdd1b67', 1, 3),
('Aceite de caja Motul Gear 75W-90', 'Aceite de caja de cambios sintético para transmisiones manuales y automáticas', 40, 120000.00, 'https://img.freepik.com/foto-gratis/accesorios-coche-espacio-copia_23-2149030410.jpg?size=626&ext=jpg&ga=GA1.1.289359447.1706918376&semt=ais', 4, 5),
('Batería de arranque Bosch', 'Batería de arranque premium para vehículos', 15, 250000.00, 'https://img.freepik.com/foto-gratis/composicion-diferentes-accesorios-coche_23-2149030435.jpg?size=626&ext=jpg&ga=GA1.1.289359447.1706918376&semt=ais',4,5)
