package br.unicesumar.escoladeti.common;

/**
 * @author Jhonatan
 * Classe responsavel por encapsular o erro lançado pelos controllers
 *
 */
public class InfoError {
	private final String MESSAGE;
	private final String MESSAGE_DEVELOPER;
	
	public InfoError(String message, String messageDeveloper) {
		this.MESSAGE = message;
		this.MESSAGE_DEVELOPER = messageDeveloper;
	}

	public String getMessage() {
		return MESSAGE;
	}	
	
	public String getMessageDeveloper() {
		return MESSAGE_DEVELOPER;
	}
	
}
