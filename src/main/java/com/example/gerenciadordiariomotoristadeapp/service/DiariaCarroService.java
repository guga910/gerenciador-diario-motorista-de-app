package com.example.gerenciadordiariomotoristadeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordiariomotoristadeapp.converter.DozerConverter;
import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaCarro;
import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaCarroVo;
import com.example.gerenciadordiariomotoristadeapp.exception.DiariaCarroException;
import com.example.gerenciadordiariomotoristadeapp.repository.DiariaCarroRepository;

@Service
public class DiariaCarroService {

	@Autowired
	private DiariaCarroRepository repository;

	public DiariaCarroVo findById(Long id) {

		return new DiariaCarroVo(
				repository.findById(id).orElseThrow(() -> new DiariaCarroException("diaria nao encontrada.")));

//		Optional<DiariaCarro> diaraiCarro = repository.findById(id);
//		if (diaraiCarro.isEmpty()) {
//			throw new DiariaCarroException("diaria nao encontrada.");
//		}
//
//		return new DiariaCarroVo(diaraiCarro.get());
	}

	public DiariaCarroVo save(DiariaCarroVo diariaVo) {
//		
		if (diariaVo.getDia() == null || diariaVo.getKm() == 0) {
			throw new DiariaCarroException("Objeto fora dos padroes.");
		}
		DiariaCarro diaria = repository.save(DozerConverter.parseObject(diariaVo, DiariaCarro.class));

		return DozerConverter.parseObject(diaria, DiariaCarroVo.class);
	}

	public DiariaCarroVo update(Long id, DiariaCarroVo diariaVo) {

		if (repository.findById(id).isEmpty()) {
			throw new DiariaCarroException("Objeto a ser atualizado nao existe.");
		}

		return save(diariaVo);
	}

	public List<DiariaCarroVo> findAll() {

		List<DiariaCarro> lista = repository.findAll();

		return DozerConverter.parseListObjects(lista, DiariaCarroVo.class);
	}

	public void delete(Long id) {
		if (repository.findById(id).isEmpty()) {
			throw new DiariaCarroException("O objeto a ser excluido nao existe");
		}
		repository.deleteById(id);
	}

}
