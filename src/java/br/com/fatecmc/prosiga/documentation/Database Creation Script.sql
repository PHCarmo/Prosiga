CREATE DATABASE db_prosiga;
USE db_prosiga;

CREATE TABLE alunos (
    id_aluno  INT(5) NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(60) NOT NULL,
    ra        VARCHAR(13) NOT NULL,
    id_turma  INT(5) NOT NULL,
    CONSTRAINT alunos_pk PRIMARY KEY ( id_aluno )
);

CREATE TABLE cursos (
    id_curso   INT(5) NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(30) NOT NULL,
    turno      VARCHAR(10) NOT NULL,
    descricao  VARCHAR(60),
    CONSTRAINT cursos_pk PRIMARY KEY ( id_curso )
);

CREATE TABLE disciplinas (
    id_disciplina  INT(5) NOT NULL AUTO_INCREMENT,
    nome           VARCHAR(30) NOT NULL,
    carga_horaria  INT(4),
    ementa         VARCHAR(100),
    id_curso       INT(5) NOT NULL,
    id_professor   INT(5) NOT NULL,
    CONSTRAINT disciplinas_pk PRIMARY KEY ( id_disciplina )
);

CREATE TABLE professores (
    id_professor  INT(5) NOT NULL AUTO_INCREMENT,
    nome          VARCHAR(60) NOT NULL,
    titulacao     VARCHAR(20),
    CONSTRAINT professores_pk PRIMARY KEY ( id_professor )
);

CREATE TABLE turmas (
    id_turma   INT(5) NOT NULL AUTO_INCREMENT,
    descricao  VARCHAR(30),
    id_curso   INT(5) NOT NULL,
    CONSTRAINT turmas_pk PRIMARY KEY ( id_turma )
);

ALTER TABLE alunos
    ADD CONSTRAINT alunos_turmas_fk FOREIGN KEY ( id_turma )
        REFERENCES turmas ( id_turma );

ALTER TABLE disciplinas
    ADD CONSTRAINT disciplinas_cursos_fk FOREIGN KEY ( id_curso )
        REFERENCES cursos ( id_curso );

ALTER TABLE disciplinas
    ADD CONSTRAINT disciplinas_professores_fk FOREIGN KEY ( id_professor )
        REFERENCES professores ( id_professor );

ALTER TABLE turmas
    ADD CONSTRAINT turmas_cursos_fk FOREIGN KEY ( id_curso )
        REFERENCES cursos ( id_curso );