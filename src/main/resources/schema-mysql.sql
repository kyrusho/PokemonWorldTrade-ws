USE `pokemonworld-db`;
create table if not exists pokemons(
                         id  INT NOT NULL AUTO_INCREMENT,
                         pokemon_id VARCHAR(36) NOT NULL UNIQUE,
                         name VARCHAR(255) NOT NULL,
                         typee VARCHAR(255) NOT NULL,
                         ability VARCHAR(255) NOT NULL,
                         weight VARCHAR(255) NOT NULL,
                         height VARCHAR(255) NOT NULL,
                         classification VARCHAR(255) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS events (
                    id INT NOT NULL AUTO_INCREMENT,
                    event_id VARCHAR(255) NOT NULL UNIQUE,
                    event_name VARCHAR(36) NOT NULL,
                    event_type VARCHAR(255) NOT NULL,
                    event_date DATE NOT NULL,
                    event_description VARCHAR(255) NOT NULL,
                    event_status VARCHAR(255) NOT NULL,
                    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
                    id INT NOT NULL AUTO_INCREMENT,
                    user_id VARCHAR(255) NOT NULL UNIQUE,
                    username VARCHAR(36) NOT NULL UNIQUE,
                    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_pokemon_bag (
                    id INT NOT NULL AUTO_INCREMENT,
                    user_id VARCHAR(255) NOT NULL UNIQUE,
                    pokemon_bag_id VARCHAR(36) NOT NULL UNIQUE,
                    owned_pokemons VARCHAR(255) NOT NULL,
                    PRIMARY KEY (id),
                    FOREIGN KEY (user_id) REFERENCES users(user_id)
);