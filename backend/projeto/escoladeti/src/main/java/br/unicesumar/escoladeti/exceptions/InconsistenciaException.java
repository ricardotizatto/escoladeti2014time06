package br.unicesumar.escoladeti.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Inconsistencia do objeto")
public class InconsistenciaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InconsistenciaException(String message) {
		super(message);
	}

}
