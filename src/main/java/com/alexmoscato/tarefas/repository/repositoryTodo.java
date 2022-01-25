package com.alexmoscato.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexmoscato.tarefas.model.Todo;

public interface repositoryTodo extends JpaRepository<Todo, Long>{

}
