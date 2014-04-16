package br.unicesumar.escoladeti.util.nanotime;

public abstract class ManageableNanotimeStrategy extends NanotimeStrategy {

	protected long initialNanotime;

	public ManageableNanotimeStrategy(long initialNanotime) {
		this.initialNanotime = initialNanotime;
	}

}
