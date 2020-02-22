package br.com.b2w.tarefas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.b2w.tarefas.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
