/*
Criação das tabelas para o projeto de urna
eletrônica em JSF.
*/
/*Criação da tabela eleitor*/
CREATE TABLE urna(
	id_urna SERIAL PRIMARY KEY,
	secao INTEGER,
	zona INTEGER,
	presidente_secao INTEGER
);

CREATE TABLE partido(
	numero_partido INTEGER PRIMARY KEY,
	nome_partido VARCHAR(50),
	legenda_partido VARCHAR(10)
	
);

CREATE TABLE chapa(
	id_chapa SERIAL PRIMARY KEY,
	candidato VARCHAR(100),
	vice_candidato VARCHAR(100),
	numero_chapa INTEGER,
	CONSTRAINT fk_candidato FOREIGN KEY (candidato) REFERENCES candidato(id_candidato),
	CONSTRAINT fk_vice FOREIGN KEY (vice_candidato) REFERENCES candidato(id_candidato)
);


CREATE TABLE eleitor(
	titulo_eleitoral BIGINT PRIMARY KEY,
	nome VARCHAR(100),
	cpf BIGINT,	
	uf VARCHAR(5),
	situacao VARCHAR(10),
	id_urna INTEGER,
	CONSTRAINT fk_urna_id_urna FOREIGN KEY (id_urna) REFERENCES urna(id_urna)
);

CREATE TABLE candidato(
	id_candidato SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	numero_candidato BIGINT,
	uf_candidato VARCHAR(10),
	partido_candidato INTEGER,
	CONSTRAINT fk_partido_numero_partido FOREIGN KEY (partido_candidato) REFERENCES partido(numero_partido)
);


CREATE TABLE voto(
	id_voto SERIAL PRIMARY KEY,
	id_chapa INTEGER,
	id_urna INTEGER,
	CONSTRAINT fk_chapa_id_chapa FOREIGN KEY (id_chapa) REFERENCES chapa(id_chapa),
	CONSTRAINT fk_urna_id_urna FOREIGN KEY (id_urna) REFERENCES urna(id_urna)
);


