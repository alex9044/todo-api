package com.alexmoscato.tarefas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Coluna Id da tabela Todo
	
	@Column
	private String description; //Coluna descrição da tabela todo
	
	@Column
	private boolean done; //Coluna done da tabela todo que indica se a tarefa ja foi feita ou nao.
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createDate; //Coluna que indica quando a todo foi criada.
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime doneDate;//Coluna que indica quando a todo foi terminada.
	
	@PrePersist
	public void beforeSave() {
		setCreateDate(LocalDateTime.now());
	}
	
}
