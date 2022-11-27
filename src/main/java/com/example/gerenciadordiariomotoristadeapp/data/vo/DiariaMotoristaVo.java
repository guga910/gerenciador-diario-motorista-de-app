package com.example.gerenciadordiariomotoristadeapp.data.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DiariaMotoristaVo {

	private Long id;
	private LocalDate dia;
	private BigDecimal valorCombustivel = BigDecimal.ZERO;
	private BigDecimal valorBruto;
	private BigDecimal valorPromocao;
	private int kmInicial;
	private int kmFim;

	public DiariaMotoristaVo() {
		// TODO Auto-generated constructor stub
	}
//	public DiariaMotoristaVo( BigDecimal valorCombustivel) {
//		this.dia = LocalDate.now();
//		this.valorCombustivel = valorCombustivel;
//	}

	public Long getId() {
		return id;
	}

	public DiariaMotoristaVo(LocalDate dia, BigDecimal valorBruto) {
		super();
		this.dia = dia;
		this.valorBruto = valorBruto;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
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

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DiariaMotoristaVo [id=" + id + ", dia=" + dia + ", valorCombustivel=" + valorCombustivel
				+ ", valorBruto=" + valorBruto + ", valorPromocao=" + valorPromocao + ", kmInicial=" + kmInicial
				+ ", kmFim=" + kmFim + "]";
	}

}
