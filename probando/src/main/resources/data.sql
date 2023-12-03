-- Inserción de datos en BREWERY_OLD
INSERT INTO BREWERY (nombre) VALUES ('La Zaragozana');
INSERT INTO BREWERY (nombre) VALUES ('Mahou');
INSERT INTO BREWERY (nombre) VALUES ('Alhambra');
INSERT INTO BREWERY (nombre) VALUES ('Ambar');
INSERT INTO BREWERY (nombre) VALUES ('Cruzcampo');

-- Inserción de datos en BEER
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_id, is_old) VALUES ('Ambar Especial', '2022-01-15', 4, 0);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_id, is_old) VALUES ('Ambar 1900', '2022-01-15', 1, 0);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_id, is_old) VALUES ('Mahou Cinco Estrellas', '1999-02-28', 2, 1);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_id, is_old) VALUES ('Alhambra Reserva 1925', '2022-03-10', 5, 0);
