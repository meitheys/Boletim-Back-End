CREATE TABLE turmas(
    id BIGINT IDENTITY(1,1) NOT NULL,
    numero_turma VARCHAR (100) PRIMARY KEY NOT NULL,
    periodo VARCHAR (20) NOT NULL
);

create unique index ix_turmas_01 on turmas (numero_turma asc);

INSERT INTO turmas (numero_turma, periodo)
VALUES('1nc3','Vespertino');
INSERT INTO turmas (numero_turma, periodo)
VALUES('2nc3','Matutino');
INSERT INTO turmas (numero_turma, periodo)
VALUES('3nc5','Noturno');


