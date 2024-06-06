USE afautos;
INSERT INTO categories (cat_name, description) VALUES ('Electrónica', 'Productos electrónicos en general');
INSERT INTO brands (brand_name) VALUES ('Sony'),('Nokia');
INSERT INTO products (prod_name, description, quantity, price, image_url, cat, brand) 
VALUES ('Televisor LED', 'Televisor LED de alta definición', 50, 599.99, 'https://example.com/tv.jpg', 1, 1);

INSERT INTO sales (sale_date, pay_method, total_price, customer, address) VALUES ("2024-05-15","TC",245000, "1","example");

INSERT INTO sale_details(product,sale,quantity,price_unit,subtotal) VALUES (1,1,121,12002,12200000);