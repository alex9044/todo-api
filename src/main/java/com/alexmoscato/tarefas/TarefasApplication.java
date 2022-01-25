package com.alexmoscato.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alexmoscato.tarefas.model.Todo;
import com.alexmoscato.tarefas.repository.repositoryTodo;

@SpringBootApplication
public class TarefasApplication {
	
	@Autowired
	private repositoryTodo repositoryTodo;
	
	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

}
