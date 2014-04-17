package br.unicesumar.escoladeti.controller;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.data.domain.Page;

import br.unicesumar.escoladeti.controller.DataPage;

public class DataPageTest {

	@Test
	public void testIsMaxPagesToShowValid() {
		assertThat(DataPage.MAX_PAGES_TO_SHOW % 2).isEqualTo(1);
	}
	
	@Test
	public void testPrimeirasPaginas() {
		Page<String> pageMock = mock(Page.class);
		when(pageMock.getTotalPages()).thenReturn(1);
		when(pageMock.getNumber()).thenReturn(0);
		
		DataPage<String> page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1});
		
		when(pageMock.getTotalPages()).thenReturn(2);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1, 2});

		when(pageMock.getTotalPages()).thenReturn(3);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1, 2, 3});
		
		when(pageMock.getTotalPages()).thenReturn(4);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1, 2, 3, 4});
		

		when(pageMock.getNumber()).thenReturn(3);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1, 2, 3, 4});
	}

	@Test
	public void testQuantidadeDePaginasMenorOuIgualAoMaximo() {
		Page<String> pageMock = mock(Page.class);
		when(pageMock.getTotalPages()).thenReturn(4);
		when(pageMock.getNumber()).thenReturn(2);
		
		DataPage<String> page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1,2,3,4});

		when(pageMock.getTotalPages()).thenReturn(5);

		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{1,2,3,4,5});
	}
	
	@Test
	public void testPaginaAtualNoFimDaFaixa() {
		Page<String> pageMock = mock(Page.class);
		when(pageMock.getTotalPages()).thenReturn(40);
		when(pageMock.getNumber()).thenReturn(39);
		
		DataPage<String> page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{36,37,38,39,40});

		when(pageMock.getNumber()).thenReturn(38);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{36,37,38,39,40});

		when(pageMock.getNumber()).thenReturn(37);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{36,37,38,39,40});

		when(pageMock.getNumber()).thenReturn(36);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isNotEqualTo(new int[]{36,37,38,39,40});
	}
	
	@Test
	public void testPaginaAtualEstahNasFaixasCentrais() {
		Page<String> pageMock = mock(Page.class);
		when(pageMock.getTotalPages()).thenReturn(40);
		when(pageMock.getNumber()).thenReturn(32);
		
		DataPage<String> page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{31,32,33,34,35});

		when(pageMock.getNumber()).thenReturn(24);
		
		page = new DataPage<>(pageMock);
		assertThat(page.getPagesAround()).isEqualTo(new int[]{23, 24, 25, 26, 27});
	}

}
