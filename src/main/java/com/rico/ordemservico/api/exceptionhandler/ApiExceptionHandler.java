package com.rico.ordemservico.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rico.ordemservico.exception.NegocioException;



@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleBusiness(NegocioException ne, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Problema problema = new Problema();
		problema.setStauts(status.value());
		problema.setTitulo(ne.getMessage());
		problema.setDataHora(LocalDateTime.now());
		return handleExceptionInternal(ne, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		ArrayList<Problema.Campo> campo = new ArrayList<Problema.Campo>();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			 
			campo.add(new Problema.Campo(nome, mensagem));
		}
		
		Problema problema = new Problema();
		problema.setStauts(status.value());
		problema.setTitulo("Um ou mais campos estão inválidos. "
				+ "Faça o preenchimento correto e tente novamente");
		problema.setDataHora(LocalDateTime.now());
		problema.setCampos(campo);
		
		
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
	
	
	

}
