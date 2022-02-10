package com.jonathasab.bookstore.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	List<FieldException> erros = new ArrayList<>(); 

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<FieldException> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String message) {
		this.erros.add(new FieldException(fieldName, message));
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

}
