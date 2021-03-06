CREATE TABLE pessoa (
	id INT(11) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(30) NOT NULL,
	sobrenome VARCHAR(30) NOT NULL,
	endereco VARCHAR(60) NOT NULL,
	email VARCHAR(60) NOT NULL,
	PRIMARY KEY (id) 
);

CREATE TABLE NUMERO(
	id INT(11) NOT NULL AUTO_INCREMENT,
	numero VARCHAR(30) NOT NULL,
	ordem INT(11) NOT NULL,
	pessoa_id INT(11),
	PRIMARY KEY (id)
);

ALTER TABLE numero ADD CONSTRAINT pessoa_numero_fk
FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);
