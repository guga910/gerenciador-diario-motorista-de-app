package com.example.gerenciadordiariomotoristadeapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;

@RunWith(SpringRunner.class)
@DataJpaTest
class DiariaMotoristaRepositoryTest {
//	@Autowired
//	private TestEntityManager em;
	
	@Autowired
	DiariaMotoristaRepository repository;
	
	@Test
	void deveRetornarSomenteOsDiasDeUmaSemana() {
		LocalDate data = LocalDate.of(2022, 11, 10);
		
		 List<DiariaMotorista> teste = repository.findASemanaDoDia(data, data.plusDays(6));
		 
		 assertEquals(7, teste.size());
//		 LocalDate dia = teste.get(0).getDia();
//		assertTrue(LocalDate.of(2022, 11, 10)==(dia));
//		 assertTrue("2022, 11, 10".equals(dia.toString()));
		
	}

	
	
	
//	@Test
//	public void deveriaBuscarBoltoPelaDescricao() {
//		Boleto boleto = new Boleto();
//		boleto.setDescricao("luz");
//		boleto.setStatus(StatusBoleto.NAO_PAGO);
//		boleto.setValor(new BigDecimal(222.22));
//		boleto.setVencimento(LocalDate.now());
//		em.persist(boleto);
//
//		List<Boleto> boletosDescricao = repository.findByDescricao("luz");
//
//		Assert.assertNotNull(boletosDescricao);
//		Assert.assertEquals("luz", boletosDescricao.get(0).getDescricao());
//		Assert.assertNotEquals("luiz", boletosDescricao.get(0).getDescricao());
//
//	}


}
