package br.unicesumar.escoladeti.util.nanotime;

public class IncrementalNanotimeStrategy extends ManageableNanotimeStrategy {

	private long increment;

	public IncrementalNanotimeStrategy(long initialNanotime) {
		this(initialNanotime, 1L);
	}

	public IncrementalNanotimeStrategy(long initialNanotime, long increment) {
		super(initialNanotime);
		this.setIncrement(increment);
	}

	@Override
	public Long nanotime() {
		return initialNanotime += increment;
	}

	public long getIncrement() {
		return increment;
	}

	public void setIncrement(long increment) {
		if (increment <= 0)
			return;
		
		this.increment = increment;
	}

}
