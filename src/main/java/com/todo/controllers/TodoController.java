package com.todo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.TodoDTO;
import com.todo.services.TodoService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	@PostMapping
	public ResponseEntity<TodoDTO> saveTodo(@RequestBody TodoDTO todo) {
		return ResponseEntity.ok(todoService.saveTodo(todo));
	}
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> getTodo() {
		return ResponseEntity.ok(todoService.getTodo());
	}
	
	@PutMapping
	public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todo) {
		return ResponseEntity.ok(todoService.updateTodo(todo));
	} 

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
}
