CREATE TABLE aluno_turma (

    id BIGINT IDENTITY(1,1) NOT NULL,
    id_aluno BIGINT NOT NULL,
    id_turma VARCHAR (100) NOT NULL

);

ALTER TABLE aluno_turma
ADD CONSTRAINT "fk2AT" FOREIGN KEY ("id_aluno") REFERENCES "alunos" (id) ON DELETE CASCADE;

ALTER TABLE aluno_turma
ADD CONSTRAINT "fk3AT" FOREIGN KEY ("id_turma") REFERENCES "turmas" (numero_turma) ON DELETE CASCADE;