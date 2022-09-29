CREATE TABLE IF NOT EXISTS products (id bigserial, title varchar(255), price integer, PRIMARY KEY (id), secret_key varchar(255));
INSERT INTO products (title, price, secret_key) VALUES
                                        ('Demon Souls', 10, 'sdtu*&^dsft6UF'),
                                        ('Dark Souls', 80, 'sdtu*&^dsft6UF'),
                                        ('Dark Souls2', 80, 'sdtu*&^dsft6UF'),
                                        ('Dark Souls3', 80, 'sdtu*&^dsft6UF'),
                                        ('Bloodborne', 80, 'sdtu*&^dsft6UF'),
                                        ('Sekiro', 80, 'sdtu*&^dsft6UF'),
                                        ('Elden Ring', 80, 'sdtu*&^dsft6UF'),
                                        ('StarCraft', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft ', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft: Wrath of the Lich King', 80, 'sdtu*&^dsft6UF'),
                                        ('StarCraft II', 80, 'sdtu*&^dsft6UF'),
                                        ('StarCraft II Wings of Liberty', 80, 'sdtu*&^dsft6UF'),
                                        ('StarCraft II: Heart of the Swarm', 80, 'sdtu*&^dsft6UF'),
                                        ('StarCraft II: Legacy of the Void', 80, 'sdtu*&^dsft6UF'),
                                        ('Dota', 80, 'sdtu*&^dsft6UF'),
                                        ('Dota 2', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft: Burning Crusade', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft: Cataclysm', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft: Mists of Pandaria', 80, 'sdtu*&^dsft6UF'),
                                        ('World of Warcraft: Warlords of Draenor', 80, 'sdtu*&^dsft6UF');


