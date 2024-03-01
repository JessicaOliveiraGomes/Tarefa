package com.todo.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entities.Todo;

@Repository
public interface TodoIRepository extends JpaRepository <Todo, Long> {

	Todo findByNomeTarefa(String nomeTarefa);
	List<Todo> findByUser(String user);
	
}
