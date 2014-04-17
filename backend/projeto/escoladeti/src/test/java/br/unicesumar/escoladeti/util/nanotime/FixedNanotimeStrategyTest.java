package br.unicesumar.escoladeti.util.nanotime;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import br.unicesumar.escoladeti.util.nanotime.FixedNanotimeStrategy;

public class FixedNanotimeStrategyTest {
	
	@Test
	public void testNanotime() {
		FixedNanotimeStrategy strategy = new FixedNanotimeStrategy(17266328906680L);
		
		for (int times = 0; times < 10000; times++)
			assertThat(strategy.nanotime() == 17266328906680L).isTrue();
	}

}
