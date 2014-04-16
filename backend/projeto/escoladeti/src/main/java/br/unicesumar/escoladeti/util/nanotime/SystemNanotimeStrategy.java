package br.unicesumar.escoladeti.util.nanotime;

public class SystemNanotimeStrategy extends NanotimeStrategy {

	@Override
	public Long nanotime() {
		return System.nanoTime();
	}

}
