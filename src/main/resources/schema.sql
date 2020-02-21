DROP TABLE IF EXISTS tasks;
 
CREATE TABLE IF NOT EXISTS tasks (
  id              INT     NOT NULL PRIMARY KEY,
  descrition      VARCHAR(200) NOT NULL,
  priority        INT
);