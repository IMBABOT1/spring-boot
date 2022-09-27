DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title varchar(255), price integer, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Demon Souls', 10), ('Dark Souls', 80), ('Dark Souls2', 80);
