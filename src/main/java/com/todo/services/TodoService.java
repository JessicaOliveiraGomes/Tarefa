package com.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.dto.TodoDTO;
import com.todo.entities.Todo;
import com.todo.mappers.TodoMapper;
import com.todo.repositorie.TodoIRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {
	
	private final TodoIRepository todoIRepository;
	private final TodoMapper todoMapper;
	
	public List<TodoDTO> getTodo() {
		return todoMapper.entitiesToDTO(todoIRepository.findAll());
	}
	
	public List<TodoDTO> getByUser(String id) {
		return todoMapper.entitiesToDTO(todoIRepository.findByUser(id));
	}
	
	public TodoDTO saveTodo (TodoDTO todo) {
		Todo entity = todoMapper.dtoToEntities(todo);
		return todoMapper.entitiesToDTO(todoIRepository.save(entity));
	}
	
	public TodoDTO updateTodo (TodoDTO todo) {
		Todo entity = todoMapper.dtoToEntities(todo);
		return todoMapper.entitiesToDTO(todoIRepository.save(entity));
	}

	public void deleteTodo (Long id) {
		todoIRepository.deleteById(id);
	}
	
	public List<TodoDTO> getTodoByLista() {
		return todoMapper.entitiesToDTO(todoIRepository.findAll());
	}
	
	public Todo getTodoById(Long id) {
		return todoIRepository.findById(id).orElse(null);
	}
	
	public TodoDTO getTodoByNome(String nomeTarefa) {
		return todoMapper.entitiesToDTO(todoIRepository.findByNomeTarefa(nomeTarefa));
	}
	

}
