package com.todo.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.todo.dto.TodoDTO;
import com.todo.entities.Todo;

@Component
public class TodoMapper {
	
	public TodoDTO entitiesToDTO (Todo entity) {
		
		return TodoDTO.builder()
			.id(entity.getId())
			.nomeTarefa(entity.getNomeTarefa())
			.detalhes(entity.getDetalhes())
			.data(entity.getData())
			.lista(entity.getLista())
			.concluido(entity.getConcluido())
			.user(entity.getUser())
			.build();
	}
	
	public Todo dtoToEntities (TodoDTO dto) {
		return Todo.builder()
			.id(dto.getId())
			.nomeTarefa(dto.getNomeTarefa())
			.detalhes(dto.getDetalhes())
			.data(dto.getData())
			.lista(dto.getLista())
			.concluido(dto.getConcluido())
			.user(dto.getUser())
			.build();
	}
	
	public List<TodoDTO> entitiesToDTO (List<Todo> entities) {
		List<TodoDTO> dtos = new ArrayList<>();
		
		for (int i=0; i< entities.size(); i++) {
			Todo entity = entities.get(i);
			
			TodoDTO dto = TodoDTO.builder()
					.id(entity.getId())
					.nomeTarefa(entity.getNomeTarefa())
					.detalhes(entity.getDetalhes())
					.data(entity.getData())
					.lista(entity.getLista())
					.concluido(entity.getConcluido())
					.user(entity.getUser())
					.build();
			dtos.add(dto);
		}
		return dtos;
	}
	
	
	

}
