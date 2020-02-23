DROP TABLE IF EXISTS tarefas;
 
CREATE TABLE IF NOT EXISTS tarefas (
  id              int primary key NOT NULL,
  descricao       VARCHAR(200) NOT NULL,
  prioridade      INT
);