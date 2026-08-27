package com.financehub.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 0L;
	
	public ResourceNotFoundException(Object id) {
		super("Object not found " +id);
	}
}
