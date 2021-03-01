package com.compassoUol.testCompassoUol.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.compassoUol.testCompassoUol.models.dto.ExceptionResponse;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {
	
	private String ESPACO_VAZIO = " ";
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ExceptionResponse handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    StringBuilder errors = new StringBuilder();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	errors.append(ESPACO_VAZIO + ((FieldError) error).getField() + ESPACO_VAZIO);
	    	errors.append(error.getDefaultMessage());
	    });
	    return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), errors);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public void handleNotFoundExceptions(
			NotFoundException ex) {
	}
}
