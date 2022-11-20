package com.example.gerenciadordiariomotoristadeapp.data.vo;

import java.time.LocalDate;

import com.example.gerenciadordiariomotoristadeapp.data.model.DiariaCarro;
import com.example.gerenciadordiariomotoristadeapp.data.model.Servico;

public class DiariaCarroVo {
	
	private Long id;
	private LocalDate dia;
	private int km;
	private Servico servico;
	private int kmProximaTroca;

	public DiariaCarroVo(DiariaCarro diariaCarro) {
		this.id = diariaCarro.getId();
		this.dia = diariaCarro.getDia();
		this.km = diariaCarro.getKm();
		this.servico = diariaCarro.getServico();
		this.kmProximaTroca = diariaCarro.getKmProximaTroca();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public int getKmProximaTroca() {
		return kmProximaTroca;
	}

	public void setKmProximaTroca(int kmProximaTroca) {
		this.kmProximaTroca = kmProximaTroca;
	}



}
