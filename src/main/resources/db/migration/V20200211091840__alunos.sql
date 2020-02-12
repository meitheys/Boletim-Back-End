CREATE TABLE alunos(
    id BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    nome_aluno VARCHAR (100) NOT NULL,
    responsavel VARCHAR (100),
    telefone VARCHAR (13),
    turma VARCHAR(100) NOT NULL
)

ALTER TABLE alunos
ADD CONSTRAINT fk4AL FOREIGN KEY (turma) REFERENCES turmas (numero_turma) ON DELETE CASCADE;

