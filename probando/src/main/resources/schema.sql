CREATE TABLE IF NOT EXISTS BREWERY(
   id bigint auto_increment,
   nombre varchar(25),
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS BEER(
   id bigint auto_increment,
   nombre varchar(50),
   fechaLanzamiento date,
   brewery_id INT,
   is_old boolean,
   FOREIGN KEY (brewery_id) REFERENCES BREWERY(id)
);