CREATE TABLE escolas(
    id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    nome_escola VARCHAR (100) NOT NULL,
    endereco VARCHAR (100) NOT NULL,
    telefone VARCHAR (13) NOT NULL,
    codigo_escola VARCHAR (10) NOT NULL
);

create unique index ix_escolas_01 on escolas (codigo_escola asc);