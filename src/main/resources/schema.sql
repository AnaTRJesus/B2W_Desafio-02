DROP TABLE IF EXISTS tarefas;
 
CREATE TABLE IF NOT EXISTS tarefas (
  id              INT  PRIMARY KEY,
  descricao       VARCHAR(200) NOT NULL,
  prioridade      INT
);