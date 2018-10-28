/*
Criação das tabelas para o projeto de urna
eletrônica em JSF.
*/
/*Criação da tabela eleitor*/
CREATE TABLE eleitor(
	nome VARCHAR(100),
	cpf BIGINT,
	titulo_eleitoral BIGINT PRIMARY KEY,
	colegio_eleitoral VARCHAR(100),
	zona_eleitoral INTEGER,
	uf VARCHAR(5),
	situacao VARCHAR(10)
);


CREATE TABLE partido(
	nome_partido VARCHAR(50),
	legenda_partido VARCHAR(10),
	numero_partido INTEGER PRIMARY KEY
);

CREATE TABLE candidato(
	id_candidato SERIAL PRIMARY KEY,
	nome VARCHAR(100),
	numero_candidato BIGINT,
	uf_candidato VARCHAR(10),
	partido_candidato VARCHAR(50),
	FOREIGN KEY (partido_candidato) REFERENCES partido(nome),
);

CREATE TABLE chapa(
	id_chapa SERIAL PRIMARY KEY,
	nome_candidato VARCHAR(100),
	nome_vice_candidato VARCHAR(100),
	numero_chapa INTEGER,
	CONSTRAINT fk_candidato FOREIGN KEY (nome_candidato) REFERENCES candidato(nome),
	CONSTRAINT fk_vice_candidato FOREIGN KEY (nome_vice_candidato) REFERENCES candidato(nome)
);

CREATE TABLE voto(
	numero_chapa INTEGER,
	colegio_voto VARCHAR(100),
	zona_voto INTEGER
);


CREATE TABLE urna(
	id_urna BIGINT PRIMARY KEY,
	colegio_urna VARCHAR(100),
	zona_urna INTEGER,
	mesario_resp BIGINT,
	CONSTRAINT fk_mesario FOREIGN KEY mesario_resp REFERENCES mesario(id_mesario)
);

CREATE TABLE mesario (
	id_mesario SERIAL PRIMARY KEY,
	nome_mesario VARCHAR(100),
	cpf_mesario BIGINT,
	senha_mesario VARCHAR(16)
);



