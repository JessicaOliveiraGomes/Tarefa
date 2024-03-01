package com.todo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_USER')")
	@PostMapping
	public ResponseEntity<TodoDTO> saveTodo(@RequestBody TodoDTO todo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		todo.setUser(auth.getName());
		return ResponseEntity.ok(todoService.saveTodo(todo));
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_USER')")
	public ResponseEntity<List<TodoDTO>> getTodo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		return ResponseEntity.ok(todoService.getByUser(auth.getName()));
	}
	
	@PutMapping
	public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todo) {
		return ResponseEntity.ok().body(todoService.updateTodo(todo));
	} 

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
}
