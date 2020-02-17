CREATE TABLE notas(
    id BIGINT IDENTITY(1,1)  NOT NULL,
    aluno BIGINT NOT NULL,
    nota_um DECIMAL NOT NULL,
    nota_dois DECIMAL NOT NULL,
    disciplina BIGINT NOT NULL,
)

ALTER TABLE notas
ADD CONSTRAINT fk5AL FOREIGN KEY (aluno) REFERENCES alunos (id) ON DELETE CASCADE;


ALTER TABLE notas
ADD CONSTRAINT fk6AL FOREIGN KEY (disciplina) REFERENCES disciplinas(id) ON DELETE CASCADE;
