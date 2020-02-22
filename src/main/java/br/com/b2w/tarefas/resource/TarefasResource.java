package br.com.b2w.tarefas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.tarefas.model.Tarefas;
import br.com.b2w.tarefas.service.TarefasService;

@RestController
@RequestMapping("/tarefas")
public class TarefasResource {
	
	
	@Autowired
	private TarefasService tarefasService;
	
	@PutMapping("/{id}") 
	
	public ResponseEntity<Tarefas> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefas tarefas){
		
		Tarefas tarefaSalva = tarefasService.atualizar(id, tarefas);
		return ResponseEntity.ok(tarefaSalva);
	}

}
