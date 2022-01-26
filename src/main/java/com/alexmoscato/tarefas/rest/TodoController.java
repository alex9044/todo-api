package com.alexmoscato.tarefas.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.alexmoscato.tarefas.model.Todo;
import com.alexmoscato.tarefas.repository.repositoryTodo;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("https://alex9044.github.io/")
public class TodoController {
	
	@Autowired
	private repositoryTodo repository;
	
	@PostMapping
	public Todo save (@RequestBody Todo todo){
		return repository.save(todo);
	}
	
	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository
				.findById(id)
				.orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping({})
	public List<Todo> getAll(){
		return repository.findAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	//PatchMapping:: Atualizacao parcial
	@PatchMapping("{id}/done")
	public Todo markAsDone(@PathVariable Long id){
		//findById: retorna um Objeto optional 
		//map: mapeia o objeto que retorna do findById
		 return repository.findById(id).map(todo -> {
			//Atualiza o campo done do objeto todo
			 todo.setDone(true);
			 //Atualiza o campo doneDate do objeto todo
			 todo.setDoneDate(LocalDateTime.now());
			 //save: Se o obejto exitir, o metodo enviara como um update,
			 //save: Caso o objeto nao exita, o metodo enviara como novo,
			 //Envia o objeto atualizado para o banco.
			 repository.save(todo);
			 //retorna o objeto atualizado
			 return todo;
		 }).orElse(null);
	}
}
