CREATE TABLE turmas(

    id BIGINT IDENTITY(1,1) NOT NULL,
    numero_turma VARCHAR (100) PRIMARY KEY NOT NULL,
    periodo VARCHAR (20) NOT NULL,
    disciplina VARCHAR (25) NOT NULL
);

create unique index ix_turmas_01 on turmas (numero_turma asc);
