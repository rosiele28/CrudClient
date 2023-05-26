package com.devsuperior.CrudClient.exceptions;

public class EntityNotFounException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public EntityNotFounException(String msg) {
		super(msg);
	}
 
}
