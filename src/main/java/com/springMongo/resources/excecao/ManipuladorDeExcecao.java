package com.springMongo.resources.excecao;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice 
public class ManipuladorDeExcecao {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErroPadrao> ObjetoNaoEncontrado(NoSuchElementException erro,
			HttpServletRequest requisicao){
		
		HttpStatus estado = HttpStatus.NOT_FOUND;
		
		ErroPadrao err = new ErroPadrao(System.currentTimeMillis(), estado.value(), erro.getMessage(), "Objeto não encontrado", requisicao.getRequestURI());
				
		return ResponseEntity.status(estado).body(err);
	}
}
