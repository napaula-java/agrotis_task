package com.agrotis.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404() {
		return ResponseEntity.notFound().build();
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException e) {
		var erros = e.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroCadastro::new).toList());
	}

	
	private record DadosErroCadastro(String campo, String mensagem) {
		public DadosErroCadastro(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
