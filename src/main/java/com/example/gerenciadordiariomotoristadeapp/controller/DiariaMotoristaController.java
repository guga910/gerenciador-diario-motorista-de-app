package com.example.gerenciadordiariomotoristadeapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;
import com.example.gerenciadordiariomotoristadeapp.service.DiariaMotoristaService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/diariamotorista")
public class DiariaMotoristaController {

	@Autowired
	DiariaMotoristaService service;

	@PostMapping
	@ApiOperation(value = "Salva uma diaria no banco de dados" )
	public ResponseEntity<DiariaMotoristaVo> criarDiariaMotorista(
			@RequestBody DiariaMotoristaVo diariaVo,
			UriComponentsBuilder uriBuilder) {
		service.save(diariaVo);
		URI uri = uriBuilder.path("/diaria-motorista/{id}").buildAndExpand(diariaVo.getId()).toUri();

		return ResponseEntity.created(uri).body(diariaVo);

	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Faz uma busca pelo id fornecido." )
	public ResponseEntity<DiariaMotoristaVo> buscarPorId(@PathVariable("id") Long id) {
		DiariaMotoristaVo diariaVo = service.findById(id);
		
		return ResponseEntity.ok(diariaVo);
	}
	
	@GetMapping
	@ApiOperation(value = "Recupera todas as diarias salvas." )
	public ResponseEntity<List<DiariaMotoristaVo>> buscarTodasDiarias(){
		
		 List<DiariaMotoristaVo> lista = service.findAll();
		return ResponseEntity.ok(lista);
	}
	@DeleteMapping
	@ApiOperation(value = "Deleta uma diaria pelo id fornecido." )
	public ResponseEntity<DiariaMotoristaVo> delete(@PathVariable("id") Long id){
		service.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
	

}
