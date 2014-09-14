package br.unicesumar.escoladeti.controller;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.unicesumar.escoladeti.common.InfoError;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler( Exception.class)        
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public InfoError handleException(Exception e) {
            e.printStackTrace();
		return new InfoError(e.getMessage(), e.getLocalizedMessage() );
	}

    @ExceptionHandler( RuntimeException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public InfoError handleException(RuntimeException e) {
        e.printStackTrace();
        return new InfoError(e.getMessage(), e.getLocalizedMessage() );
    }
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public InfoError handleValidationException(HttpMessageNotReadableException e) {
		System.out.println(e.getClass());
                e.printStackTrace();
		return new InfoError(e.getMostSpecificCause().getMessage() , e.getLocalizedMessage() );
	}
	
	@ExceptionHandler(TransactionSystemException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public InfoError handleConstraintViolationException(TransactionSystemException e) {
		System.out.println(e.getClass());
                e.printStackTrace();
		StringBuilder builder = new StringBuilder();
		
		//Percorrer  as constantes violadas, armazenando qual campo, e a mensagem de validação
		if (e.getCause() != null 
				&& e.getCause().getCause() instanceof ConstraintViolationException) {
			ConstraintViolationException except = (ConstraintViolationException) e.getCause().getCause();
			for (ConstraintViolation<?> violation : except.getConstraintViolations()) {
				builder.append(violation.getPropertyPath());
				builder.append(" ");
				builder.append(violation.getMessage());
				builder.append("\n");
			}
			return new InfoError(builder.toString(), e.getMessage());
		}
		
		return new InfoError("Erro ao salvar", e.getLocalizedMessage() );
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public InfoError processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        ex.printStackTrace();
        for (FieldError error : fieldErrors) {
        	builder.append("*");
        	builder.append(error.getDefaultMessage());
        	builder.append("<br>");
        }
        
        return new InfoError(builder.toString(), builder.toString());
    }
	

}
