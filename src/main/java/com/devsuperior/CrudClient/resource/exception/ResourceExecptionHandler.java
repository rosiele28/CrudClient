package com.devsuperior.CrudClient.resource.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.CrudClient.exceptions.DatabaseException;
import com.devsuperior.CrudClient.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExecptionHandler { 
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandError> entityNotFound (ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandError erro = new StandError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Erro !");
		erro.setMensagem(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandError> database (DatabaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandError erro = new StandError();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Erro !");
		erro.setMensagem(e.getMessage());
		erro.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
}
