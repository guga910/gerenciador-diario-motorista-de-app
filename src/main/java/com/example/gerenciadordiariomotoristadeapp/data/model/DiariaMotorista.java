package com.example.gerenciadordiariomotoristadeapp.data.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="DIARIAMOTORISTA")
public class DiariaMotorista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private LocalDate dia;
	@Column(name = "VALORCOMBUSTIVEL")
	private BigDecimal valorCombustivel;
	
	@Column(name= "VALORBRUTO",nullable = false)
	private BigDecimal valorBruto;
	private BigDecimal valorPromocao;
	@Column(name= "KMINICIAL")
	private int kmInicial;
	@Column(name= "KMFIM")
	private int kmFim;
	
	public DiariaMotorista() {
		// TODO Auto-generated constructor stub
	}
	
//	public DiariaMotorista( BigDecimal valorCombustivel) {
//		this.dia = LocalDate.now();
//		this.valorCombustivel = valorCombustivel;
//	}

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
	public int getKmInicial() {
		return kmInicial;
	}
	public void setKmInicial(int kmInicial) {
		this.kmInicial = kmInicial;
	}
	public int getKmFim() {
		return kmFim;
	}
	public void setKmFim(int kmFim) {
		this.kmFim = kmFim;
	}
	public BigDecimal getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(BigDecimal valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}
	public BigDecimal getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}
	public BigDecimal getValorPromocao() {
		return valorPromocao;
	}
	public void setValorPromocao(BigDecimal valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

}
