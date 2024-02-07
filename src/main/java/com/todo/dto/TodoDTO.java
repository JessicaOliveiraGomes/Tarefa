package com.todo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	private Long id;
	private String nomeTarefa;
	private String detalhes;
	private LocalDateTime data;
	private String lista;
	private Boolean concluido;

}
