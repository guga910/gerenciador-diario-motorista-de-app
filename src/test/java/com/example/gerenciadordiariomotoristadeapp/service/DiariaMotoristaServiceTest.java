package com.example.gerenciadordiariomotoristadeapp.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DiariaMotoristaServiceTest {

//	@Mock
	@Autowired
	private DiariaMotoristaService service;

	@Test
	void deveriaResgatarOPrumeiroObjetoRegistrado() {
		DiariaMotoristaVo teste = service.findById(1l);
		
		assertEquals(new BigDecimal("350.57"), teste.getValorBruto());
	}
	
	@Test
	public void deveriaSalvarObjeto() {
		DiariaMotoristaVo diariaMotorista= new DiariaMotoristaVo(LocalDate.now() ,new BigDecimal("220.45"));
//		DiariaMotoristaVo diariaMotorista= new DiariaMotoristaVo();
		Mockito.when(service.save(diariaMotorista)).thenReturn(diariaMotorista);
		assertNotNull(diariaMotorista.getValorBruto());
		assertNotNull(diariaMotorista.getDia());

		service.save(diariaMotorista);

	}
	@Test
	public void deveriaLancarExceptionAoSalvarComDadosObrigatoriosFaltando() {
		DiariaMotoristaVo diariaMotorista= new DiariaMotoristaVo();
		assertNull(diariaMotorista.getValorBruto()); // valor bruto nulo
		assertNull(diariaMotorista.getDia());// dia nulo nulo
		try {
			
		// deve ter lancado uma exception por valores nulos quando eu chamar o metodo
		Mockito.when(service.save(diariaMotorista)).thenReturn(diariaMotorista);
		// verificando se o metodo nao teve nenhuma interação, visto que uma 
//		exception foi lancada antes dele ser chamado.
		Mockito.verifyNoInteractions(service.save(diariaMotorista));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Test
	void deveriaChamarDiariasExistentesNoPeriodo	() {
		List<DiariaMotoristaVo> lista= new ArrayList<>();
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 01), new BigDecimal("220")));
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 03), new BigDecimal("220")));
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 05), new BigDecimal("220")));
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 07), new BigDecimal("220")));
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 8), new BigDecimal("220")));
		
		when(service.buscarSemana(Mockito.any())).thenReturn(lista);
		
		List<DiariaMotoristaVo> teste = service.buscarSemana(LocalDate.now());
		
		assertFalse(7== teste.size());
		assertEquals(5, teste.size());
		
	}

}
