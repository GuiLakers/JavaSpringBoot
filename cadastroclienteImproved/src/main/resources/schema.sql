CREATE TABLE cidade (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	estado VARCHAR(30) NOT NULL
);

CREATE TABLE cliente (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome_completo VARCHAR(60) NOT NULL,
	sexo VARCHAR(20) NOT NULL,
	data_nascimento DATE NOT NULL,
	idade INT(11) NOT NULL,
	cidade_id INT(11) NOT NULL,
    CONSTRAINT cidade_cliente_fk FOREIGN KEY (cidade_id)
    REFERENCES cidade (id)
);


