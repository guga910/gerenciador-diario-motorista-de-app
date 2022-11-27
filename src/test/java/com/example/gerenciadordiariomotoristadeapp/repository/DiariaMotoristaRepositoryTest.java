package com.example.gerenciadordiariomotoristadeapp.repository;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;
import com.example.gerenciadordiariomotoristadeapp.exception.DiariaMotoristaException;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE) // acho que descartavel...
class DiariaMotoristaRepositoryTest {

	@Autowired
	DiariaMotoristaRepository repository;
	
	@Test
	void deveRetornarSomenteOsDiasDeUmaSemana() {
		LocalDate data = LocalDate.of(2022, 11, 10);

		List<DiariaMotorista> teste = repository.findBySemanaDoDia(data, data.plusDays(6));

		assertEquals(7, teste.size());
		assertEquals(new BigDecimal("100.00"), teste.get(0).getValorBruto());
		assertEquals(new BigDecimal("100.00"), teste.get(6).getValorBruto());

	}

	@Test
	void deveriaBuscarUmObjetoPeloId() {
		long id = 8;

		Optional<DiariaMotorista> teste = repository.findById(id);

		assertNotNull(teste.get());
		assertEquals(id, teste.get().getId());

	}

	@Test()
	void naoDeveriaBuscarUmProdutoPeloUdInvalido() {
		long id = 999;
		repository.findById(id);

		assertThatExceptionOfType(DiariaMotoristaException.class);

	}


	@Test
	void deveriaCarregarUlaListaDeDiaria() {

		List<DiariaMotorista> teste = repository.findAll();
		
		assertTrue(teste.size()>1);
	}
	
	@Test
	void deveRetornarOsValoresNoIntervalorDeSeteDias() {
		LocalDate data = LocalDate.of(2022,11,10);
		List<DiariaMotorista> semana = repository.findBySemanaDoDia(data, data.plusDays(6));
		

		assertEquals(data, semana.get(0).getDia());
		assertEquals(7, semana.size());
	}
	
	@Test
	void kmInicialEFinalNaoPodemEstarZerados() {
		LocalDate data = LocalDate.of(2022,11,10);
		List<DiariaMotorista> semana = repository.findBySemanaDoDia(data, data.plusDays(6));
		
		assertTrue(semana.get(0).getKmInicial()>0);
		assertTrue(semana.get(0).getKmFim()>0);
		assertTrue(semana.get(6).getKmInicial()>0);
		assertTrue(semana.get(6).getKmFim()>0);
		
	}
//	@Test
//	void deveRetornarOsValoresNoIntervalorDeSeteDiass() {
//		LocalDate data = LocalDate.of(2022,11,14);
//		List<DiariaMotoristaVo> semana = service.buscarSemana(data);
//		
//		
////		assertFalse(data.equals(semana.get(0).getDia()));
////		assertTrue(semana.get(0).getDia().equals(LocalDate.of(14,11,2022))); 
//		assertEquals(LocalDate.of(2022,11,10), semana.get(0).getDia());
////		assertEquals(7, semana.size());
//	}

}
