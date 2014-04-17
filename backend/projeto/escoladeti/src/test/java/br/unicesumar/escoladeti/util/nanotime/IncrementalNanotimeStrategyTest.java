package br.unicesumar.escoladeti.util.nanotime;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.unicesumar.escoladeti.util.nanotime.IncrementalNanotimeStrategy;

public class IncrementalNanotimeStrategyTest {

	private IncrementalNanotimeStrategy strategy;

	@Before
	public void setUp() {
		strategy = new IncrementalNanotimeStrategy(10000L);
	}
	
	@Test
	public void testNanotime() {
		assertThat(strategy.nanotime()).isEqualTo(10001L);
		assertThat(strategy.nanotime()).isEqualTo(10002L);
		assertThat(strategy.nanotime()).isEqualTo(10003L);
		assertThat(strategy.nanotime()).isEqualTo(10004L);
		assertThat(strategy.nanotime()).isEqualTo(10005L);
		
		strategy.setIncrement(10L);
		assertThat(strategy.nanotime()).isEqualTo(10015L);
		assertThat(strategy.nanotime()).isEqualTo(10025L);
		assertThat(strategy.nanotime()).isEqualTo(10035L);
		assertThat(strategy.nanotime()).isEqualTo(10045L);
		assertThat(strategy.nanotime()).isEqualTo(10055L);
	}

	@Test
	public void testNotAcceptNegativeIncrement() {
		assertThat(strategy.nanotime()).isEqualTo(10001L);
		
		strategy.setIncrement(2L);
		assertThat(strategy.nanotime()).isEqualTo(10003L);

		strategy.setIncrement(3L);
		assertThat(strategy.nanotime()).isEqualTo(10006L);

		strategy.setIncrement(4L);
		assertThat(strategy.nanotime()).isEqualTo(10010L);

		strategy.setIncrement(0L);
		assertThat(strategy.nanotime()).isEqualTo(10014L);

		strategy.setIncrement(-1L);
		assertThat(strategy.nanotime()).isEqualTo(10018L);
	}

}
