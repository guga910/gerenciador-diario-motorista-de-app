package com.example.gerenciadordiariomotoristadeapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gerenciadordiariomotoristadeapp.data.model.resumo.DiariaMotoristaResumo;
import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;

//@DataJpaTest 
//@RunWith(SpringRunner.class) 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest(classes=GerenciadorDiarioMotoristaDeAppApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class DiariaMotoristaResumoServiceTest {

	@Autowired
	@Lazy
	private DiariaMotoristaResumoService resumo;

	@Test
	void deveriaMeRetornarAMediaTotaDaSemana() {
		DiariaMotoristaResumo resumoSemana = resumo.resumoSemana(LocalDate.of(2022, 11, 16));
		
		assertEquals(7, resumoSemana.getDiasTrabalhados());
		assertEquals(new BigDecimal("700.00"), resumoSemana.getValorBruto());
		assertEquals(new BigDecimal("70.00"), resumoSemana.getValorCombustivel());
		assertEquals(new BigDecimal("630.00"), resumoSemana.getValorLiquido());
		assertEquals(700, resumoSemana.getKmsRodados());
		assertEquals(new BigDecimal("0.90"), resumoSemana.getRealPorKm());

	}

	@Test
	void deveriaRetornarResumoTotalDosDadosNoPeriodo() {

		DiariaMotoristaResumo teste = resumo.resumoTotalNoPeriodo(builder());

		assertEquals(50, teste.getKmsRodados());
		assertEquals(5, builder().size());
		assertEquals(new BigDecimal("140"), teste.getValorBruto());
		
		assertEquals(new BigDecimal("60"), teste.getValorCombustivel());
		assertEquals(new BigDecimal("80"), teste.getValorLiquido());
		assertEquals(new BigDecimal("1.6"), teste.getRealPorKm());
	}

	@Test
	void deveriaRetornarSugundaFeiraAnteriorAData() {

		LocalDate data = LocalDate.of(2023, 01, 28);
		LocalDate segunda = resumo.segundaAntesDaData(data);
		assertEquals(LocalDate.of(2023, 01, 23), segunda);
		assertEquals(DayOfWeek.MONDAY.name(), segunda.getDayOfWeek().name());

	}

	List<DiariaMotoristaVo> builder() {
		List<DiariaMotoristaVo> lista = new ArrayList<>();
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 01), new BigDecimal("10")));
		lista.get(0).setValorCombustivel(new BigDecimal("10"));
		lista.get(0).setKmFim(20);
		lista.get(0).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 03), new BigDecimal("10")));
		lista.get(1).setValorCombustivel(new BigDecimal("20"));
		lista.get(1).setKmFim(20);
		lista.get(1).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 05), new BigDecimal("10")));
		lista.get(2).setValorCombustivel(new BigDecimal("30"));
		lista.get(2).setKmFim(20);
		lista.get(2).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 07), new BigDecimal("10")));
		lista.get(3).setKmFim(20);
		lista.get(3).setKmInicial(10);
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 8), new BigDecimal("100")));
		lista.get(4).setKmFim(20);
		lista.get(4).setKmInicial(10);
		return lista;
	}

}
