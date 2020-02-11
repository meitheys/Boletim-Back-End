CREATE TABLE turmas(

    id BIGINT IDENTITY(1,1) NOT NULL,
    escola BIGINT NOT NULL,
    numero_turma VARCHAR (100) NOT NULL PRIMARY KEY,
    periodo BIGINT NOT NULL
);

create unique index ix_turmas_01 on turmas (numero_turma asc);

ALTER TABLE turmas
ADD CONSTRAINT "fk1Turmas" FOREIGN KEY ("escola") REFERENCES "escolas" (id) ON DELETE CASCADE;