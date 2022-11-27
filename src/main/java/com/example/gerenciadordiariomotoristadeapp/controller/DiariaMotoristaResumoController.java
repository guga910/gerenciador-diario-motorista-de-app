package com.example.gerenciadordiariomotoristadeapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciadordiariomotoristadeapp.data.model.resumo.DiariaMotoristaResumo;
import com.example.gerenciadordiariomotoristadeapp.service.DiariaMotoristaResumoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/diariamotoristaresumo")
public class DiariaMotoristaResumoController {
	
	@Autowired
	DiariaMotoristaResumoService service;
	
	@GetMapping(value = "/resumo/{data}")
	@ApiOperation(value = "traz um resumo da semana que consta a data." )
//	public ResponseEntity<List<DiariaMotoristaVo>> resumoSemana(@PathVariable("data") String data) {
	public ResponseEntity<DiariaMotoristaResumo> resumoSemana(@PathVariable("data") LocalDate data) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate data2 = LocalDate.parse(data, formatter);
		
		DiariaMotoristaResumo resumo = service.resumoSemana(data);
		
		return ResponseEntity.ok(resumo);
	}

}
