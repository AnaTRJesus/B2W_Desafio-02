package br.com.b2w.tarefas.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.b2w.tarefas.model.Tarefas;
import br.com.b2w.tarefas.repository.TarefasRepository;

@Service
public class TarefasService {
	
	@Autowired
	private TarefasRepository tarefasRepository;
	
	
	public Tarefas atualizar(Long id, Tarefas tarefas) {
		
			Tarefas tarefasSalvas = tarefasRepository.findById(id)
			        .orElseThrow(() -> new EmptyResultDataAccessException("Ocorreu um erro", 0));			
			BeanUtils.copyProperties(tarefas, tarefasSalvas, "id");
			return tarefasRepository.save(tarefasSalvas);

	}

}
