package com.example.gerenciadordiariomotoristadeapp.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciadordiariomotoristadeapp.converter.DozerConverter;
import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaMotorista;
import com.example.gerenciadordiariomotoristadeapp.data.model.resumo.DiariaMotoristaResumo;
import com.example.gerenciadordiariomotoristadeapp.data.vo.DiariaMotoristaVo;
import com.example.gerenciadordiariomotoristadeapp.repository.DiariaMotoristaRepository;

@Service
public class DiariaMotoristaResumoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DiariaMotoristaRepository repository;

	public DiariaMotoristaResumo resumoSemana(LocalDate data) {
		LocalDate segunda = segundaAntesDaData(data);
		List<DiariaMotorista> listaSemana = repository.findBySemanaDoDia(segunda, segunda.plusWeeks(6));
		List<DiariaMotoristaVo> listaSemanaVo = DozerConverter.parseListObjects(listaSemana, DiariaMotoristaVo.class);

		return resumoTotalNoPeriodo(listaSemanaVo);
	}

	public DiariaMotoristaResumo mediaSemana(LocalDate data) {

		DiariaMotoristaResumo resumoTotal = resumoSemana(data);
		return mediaTotal(resumoTotal);
	}

	protected DiariaMotoristaResumo mediaTotal(DiariaMotoristaResumo resumo) {
		DiariaMotoristaResumo media = new DiariaMotoristaResumo();
		media.setDiasTrabalhados(resumo.getDiasTrabalhados());
		media.setKmsRodados(resumo.getKmsRodados() / resumo.getDiasTrabalhados());
		media.setRealPorKm(resumo.getRealPorKm().divide(new BigDecimal(resumo.getDiasTrabalhados())));
		media.setValorBruto(resumo.getValorBruto().divide(new BigDecimal(resumo.getDiasTrabalhados())));
		media.setValorLiquido(resumo.getValorLiquido().divide(new BigDecimal(resumo.getDiasTrabalhados())));
		media.setValorBruto(resumo.getValorBruto().divide(new BigDecimal(resumo.getDiasTrabalhados())));

		return media;
	}

	protected DiariaMotoristaResumo resumoTotalNoPeriodo(List<DiariaMotoristaVo> lista) {
		DiariaMotoristaResumo resumoTotal = new DiariaMotoristaResumo();

		int kmsRodados = 0;
		BigDecimal totalBruto = BigDecimal.ZERO;
		BigDecimal totalCombustivel = BigDecimal.ZERO;
		BigDecimal totalLiquido = BigDecimal.ZERO;
		BigDecimal RealPorKm = BigDecimal.ZERO;

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Inicio: "+lista.get(i).getKmInicial());
			System.out.println("final: "+lista.get(i).getKmFim());
			kmsRodados += (lista.get(i).getKmFim() - lista.get(i).getKmInicial());
			
		}
		
		totalBruto = lista.stream().map(i -> i.getValorBruto()).reduce(BigDecimal.ZERO, BigDecimal::add);
		totalCombustivel = lista.stream().map(i -> i.getValorCombustivel()).reduce(BigDecimal.ZERO, BigDecimal::add);
		totalLiquido = totalBruto.subtract(totalCombustivel);
//		RealPorKm = totalLiquido.divide(new BigDecimal(kmsRodados), RoundingMode.HALF_UP); // com arredondamento para cima
		RealPorKm = totalLiquido.divide(new BigDecimal(kmsRodados));

		resumoTotal.setDiasTrabalhados(lista.size());
		resumoTotal.setKmsRodados(kmsRodados);
		resumoTotal.setValorBruto(totalBruto);
		resumoTotal.setValorCombustivel(totalCombustivel);
		resumoTotal.setValorLiquido(totalLiquido);
		resumoTotal.setRealPorKm(RealPorKm);

		return resumoTotal;
	}

	protected LocalDate segundaAntesDaData(LocalDate data) {
		if (!data.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
			int desconto = data.getDayOfWeek().ordinal();
			LocalDate segunda = data.minusDays(desconto);
			return segunda;
		}
		return data;
	}

}
