package com.example.gerenciadordiariomotoristadeapp.service;

import static com.example.gerenciadordiariomotoristadeapp.converter.DozerConverter.parseListObjects;
import static com.example.gerenciadordiariomotoristadeapp.converter.DozerConverter.parseObject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordiariomotoristadeapp.converter.DozerConverter;
import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;
import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;
import com.example.gerenciadordiariomotoristadeapp.exception.DiariaMotoristaException;
import com.example.gerenciadordiariomotoristadeapp.repository.DiariaMotoristaRepository;

@Service
public class DiariaMotoristaService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private DiariaMotoristaRepository repository;
	

	public DiariaMotoristaVo save(DiariaMotoristaVo diariaMotoristaVo) {
		
		if (diariaMotoristaVo.getDia() == null || diariaMotoristaVo.getValorBruto() == null) {
			throw new DiariaMotoristaException("Dados incorretos.");

		}
		DiariaMotorista diariaMotorista = DozerConverter.parseObject(diariaMotoristaVo, DiariaMotorista.class);
		repository.save(diariaMotorista);
		return diariaMotoristaVo;
	}

	
	public DiariaMotoristaVo findById(Long id) {
		
			
		DiariaMotorista diariaMotorista = repository.findById(id)
				.orElseThrow( () -> new DiariaMotoristaException("Objeto nao encontrado"));
		

		return parseObject(diariaMotorista, DiariaMotoristaVo.class);
	}

	public List<DiariaMotoristaVo> findAll() {

		return parseListObjects(repository.findAll(), DiariaMotoristaVo.class);
	}

	public DiariaMotoristaVo update(Long id, DiariaMotoristaVo diariaMotoristaVo) {
		if (repository.findById(id).isEmpty()) {
			throw new DiariaMotoristaException("Objeto nao existe no Banco de dados.");
		}
		return save(diariaMotoristaVo);

	}

	public void delete(Long id) {
		if (repository.findById(id).isEmpty()) {
			throw new DiariaMotoristaException("Objeto nao existe no Banco de dados.");
		}

		repository.deleteById(id);
	}
	
	public List<DiariaMotoristaVo> buscarSemana(LocalDate data	) {
		List<DiariaMotorista> semana = repository.findBySemanaDoDia(data, data.plusDays(6));// de hoje a 6
		
		return DozerConverter.parseListObjects(semana, DiariaMotoristaVo.class);
	}
	

	

}
