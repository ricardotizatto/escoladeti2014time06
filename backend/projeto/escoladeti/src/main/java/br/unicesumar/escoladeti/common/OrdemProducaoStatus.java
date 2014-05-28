package br.unicesumar.escoladeti.common;

public enum OrdemProducaoStatus {
	ANDAMENTO("Andamento"), FINALIZADO("Finalizado"), REJEITADO("Rejeitado");
	
	private String state;
	
	private OrdemProducaoStatus(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return state;
	}
}
	