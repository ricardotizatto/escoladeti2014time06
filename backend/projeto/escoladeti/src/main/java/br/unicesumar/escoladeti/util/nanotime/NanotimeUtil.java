package br.unicesumar.escoladeti.util.nanotime;

public class NanotimeUtil {

	private static NanotimeStrategy strategy;

	public static Long nanotime() {
		return getStrategy().nanotime();
	}

	public static NanotimeStrategy getStrategy() {
		if (strategy == null)
			strategy = new SystemNanotimeStrategy();
		
		return strategy;
	}

	public static void changeStrategy(NanotimeStrategy newStrategy) {
		strategy = newStrategy;
	}

}
