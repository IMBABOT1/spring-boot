DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title varchar(255), price integer, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Demon Souls', 10), ('Dark Souls', 80), ('Dark Souls2', 80), ('Dark Souls3', 80), ('Bloodborne', 80), ('Sekiro', 80), ('Elden Ring', 80), ('Star Craft', 80), ('World of Warcraft ', 80), ('World of Warcraft: Wrath of the Lich King', 80);
