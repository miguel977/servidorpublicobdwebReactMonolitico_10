CREATE TABLE ServidorPublico (
  `matricula` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `foto` varchar(60) NOT NULL,
  `orgao` varchar(45) NOT NULL,
  `vinculo` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `lotacao` varchar(45) NOT NULL,
  `exercicio` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `naturalidade` varchar(45) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
);

CREATE TABLE Curso (
    idCurso INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    foto VARCHAR(80) NOT NULL,
    formarealizacao VARCHAR(45) NOT NULL,
    ofertante VARCHAR(60) NOT NULL,
    vagas INT NOT NULL,
    valor INT NOT NULL,
    site VARCHAR(200) NOT NULL,
    situacao VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idCurso`),
	UNIQUE KEY `idCurso_UNIQUE` (`idCurso`)
);

CREATE TABLE ServidorPublicoCurso (
    servidor_id INT,
    curso_id INT,
    PRIMARY KEY (servidor_id, curso_id),
    FOREIGN KEY (servidor_id) REFERENCES ServidorPublico(matricula)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES Curso(idCurso)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


