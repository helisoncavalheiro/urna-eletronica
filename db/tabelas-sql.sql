/*
Criação das tabelas para o projeto de urna
eletrônica em JSF.
*/
/*Criação da tabela eleitor*/
CREATE TABLE urna(
	id_urna SERIAL PRIMARY KEY,
	secao INTEGER,
	zona INTEGER,
	presidente_secao VARCHAR(80)
);

CREATE TABLE partido(
	numero_partido INTEGER PRIMARY KEY,
	nome_partido VARCHAR(50),
	legenda_partido VARCHAR(10)

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
	tipo_candidato VARCHAR(50),
	CONSTRAINT fk_partido_numero_partido FOREIGN KEY (partido_candidato) REFERENCES partido(numero_partido)
);

CREATE TABLE chapa(
	id_chapa SERIAL PRIMARY KEY,
	nome_candidato INTEGER,
	nome_vice_candidato INTEGER,
	numero_chapa INTEGER,
	CONSTRAINT fk_candidato FOREIGN KEY (nome_candidato) REFERENCES candidato(id_candidato),
	CONSTRAINT fk_vice FOREIGN KEY (nome_vice_candidato) REFERENCES candidato(id_candidato)
);

CREATE TABLE voto(
	id_voto SERIAL PRIMARY KEY,
	id_chapa_voto INTEGER,
	id_urna INTEGER,
	data_voto DATE,
	CONSTRAINT fk_chapa_id_chapa FOREIGN KEY (id_chapa) REFERENCES chapa(id_chapa),
	CONSTRAINT fk_urna_id_urna FOREIGN KEY (id_urna) REFERENCES urna(id_urna)
);

CREATE TABLE usuarios(
	id_user SERIAL PRIMARY KEY,
	login_user VARCHAR(16),
	passwd_user BIGINT);
)
