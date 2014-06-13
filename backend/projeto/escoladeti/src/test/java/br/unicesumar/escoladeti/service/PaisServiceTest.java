package br.unicesumar.escoladeti.service;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.unicesumar.escoladeti.repository.PaisRepository;

public class PaisServiceTest {
	private PaisRepository paisRepositoryMock;
	private PaisService paisServiceSpy;

	@Before
	public void setUp() {
		paisRepositoryMock = mock(PaisRepository.class);
		paisServiceSpy = spy(new PaisService());
	}
	
	

}
