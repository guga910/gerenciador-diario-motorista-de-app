package com.example.gerenciadordiariomotoristadeapp.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;
import com.example.gerenciadordiariomotoristadeapp.repository.DiariaMotoristaRepository;
import com.example.gerenciadordiariomotoristadeapp.service.DiariaMotoristaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DiariaMotoristaControllerTest {

	@MockBean
	DiariaMotoristaRepository repository;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	DiariaMotoristaService service;
	
	@Test
	void testabdpMetodoResumoDemana() throws Exception {
//		URI uri= new URI("diariamotorista/resumo/{data}");
		LocalDate hoje=  LocalDate.now();

		 List<DiariaMotorista> resumoMock= new ArrayList<>(builder());
		 
		when(repository.findBySemanaDoDia(any(), any())).thenReturn(resumoMock);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/diariamotorista/resumo/{data}", "2022-11-11"))
//		mockMvc.perform(MockMvcRequestBuilders.get("/diariamotorista/resumo/{data}", "13/01/2022"))
//		mockMvc.perform(MockMvcRequestBuilders.get("/diariamotorista/resumo/{data}", hoje.toString()))
//		mockMvc.perform(MockMvcRequestBuilders.get(uri, "13/01/2022"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
//		when(mocRepository.findBoletosVencidos()).thenReturn(boletos);
//		mockMvc.perform(
//				get("/boletos/vencido"))
//		.andExpect(jsonPath("$[0].status").value("VENCIDO"))
//		.andExpect(status().isOk())
//		.andDo(MockMvcResultHandlers.print());
		
		

	}

	List<DiariaMotorista> builder() {
		List<DiariaMotorista> lista = new ArrayList<>();
		lista.add(new DiariaMotorista(LocalDate.of(2023, 01, 01), new BigDecimal("10")));
		lista.add(new DiariaMotorista(LocalDate.of(2023, 01, 03), new BigDecimal("10")));
		lista.add(new DiariaMotorista(LocalDate.of(2023, 01, 05), new BigDecimal("10")));
		lista.add(new DiariaMotorista(LocalDate.of(2023, 01, 07), new BigDecimal("10")));
		lista.add(new DiariaMotorista(LocalDate.of(2023, 01, 8), new BigDecimal("100")));
		
		return lista;
	}

}
