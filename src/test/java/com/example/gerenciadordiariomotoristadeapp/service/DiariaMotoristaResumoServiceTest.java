package com.example.gerenciadordiariomotoristadeapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.gerenciadordiariomotoristadeapp.data.model.resumo.DiariaMotoristaResumo;
import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;

class DiariaMotoristaResumoServiceTest {

	private DiariaMotoristaResumoService resumo;
	@BeforeEach
	void before() {
		resumo = new DiariaMotoristaResumoService();
	}
	
	void meveriaMeRetornarAMediaTota() {
		
		DiariaMotoristaResumo resumoSemana = resumo.resumoSemana(LocalDate.now());
		
	}
	

	@Test
	void deveriaRetornarResumoTotalDosDadosNoPeriodo() {

		DiariaMotoristaResumo teste = resumo.resumoTotalNoPeriodo(builder());

		assertEquals(50, teste.getKmsRodados());
		assertEquals(5, builder().size());
		assertEquals(new BigDecimal("140"), teste.getValorBruto());
		assertEquals(new BigDecimal("60"), teste.getValorCombustivel());
		assertEquals(new BigDecimal("80"), teste.getValorLiquido());
		assertEquals(new BigDecimal("2"), teste.getRealPorKm());
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
		lista.get(0).setKmFinal(20);
		lista.get(0).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 03), new BigDecimal("10")));
		lista.get(1).setValorCombustivel(new BigDecimal("20"));
		lista.get(1).setKmFinal(20);
		lista.get(1).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 05), new BigDecimal("10")));
		lista.get(2).setValorCombustivel(new BigDecimal("30"));
		lista.get(2).setKmFinal(20);
		lista.get(2).setKmInicial(10);

		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 07), new BigDecimal("10")));
		lista.get(3).setKmFinal(20);
		lista.get(3).setKmInicial(10);
		lista.add(new DiariaMotoristaVo(LocalDate.of(2023, 01, 8), new BigDecimal("100")));
		lista.get(4).setKmFinal(20);
		lista.get(4).setKmInicial(10);
		return lista;
	}

}
