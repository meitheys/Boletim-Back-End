CREATE TABLE alunos(
    id BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    nome_aluno VARCHAR (100) NOT NULL,
    responsavel VARCHAR (100),
    telefone VARCHAR (13),
    turma VARCHAR(100) NOT NULL
)

ALTER TABLE alunos
ADD CONSTRAINT fk4AL FOREIGN KEY (turma) REFERENCES turmas (numero_turma) ON DELETE CASCADE;

INSERT INTO alunos (nome_aluno, responsavel, telefone, turma)
VALUES('Matheus','Sueli','991802190','3nc5');


CREATE TABLE disciplinas(

id BIGINT           IDENTITY    (1,1)  PRIMARY KEY   NOT NULL,
disciplinas         VARCHAR     (30)                 NOT NULL

);

INSERT INTO disciplinas (disciplinas)
VALUES('Matemática');
INSERT INTO disciplinas (disciplinas)
VALUES('Biologia');
INSERT INTO disciplinas (disciplinas)
VALUES('História');
INSERT INTO disciplinas (disciplinas)
VALUES('Física');
INSERT INTO disciplinas (disciplinas)
VALUES('Geografia');
INSERT INTO disciplinas (disciplinas)
VALUES('Português');
INSERT INTO disciplinas (disciplinas)
VALUES('Filosofia');
INSERT INTO disciplinas (disciplinas)
VALUES('Sociologia');
INSERT INTO disciplinas (disciplinas)
VALUES('EF');
INSERT INTO disciplinas (disciplinas)
VALUES('Inglês');
INSERT INTO disciplinas (disciplinas)
VALUES('Geografia');
INSERT INTO disciplinas (disciplinas)
VALUES('Português');

