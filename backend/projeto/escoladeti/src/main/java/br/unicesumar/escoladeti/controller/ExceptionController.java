package br.unicesumar.escoladeti.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.unicesumar.escoladeti.common.InfoError;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public InfoError handleException(Exception e) {
		return new InfoError(e.getMessage(), e.getLocalizedMessage());
	}

}
