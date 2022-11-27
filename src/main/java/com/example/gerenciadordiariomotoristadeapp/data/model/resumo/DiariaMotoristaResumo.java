package com.example.gerenciadordiariomotoristadeapp.data.model.resumo;

import java.math.BigDecimal;

public class DiariaMotoristaResumo {
	
	private Integer diasTrabalhados;
	private Integer kmsRodados;
	private BigDecimal valorBruto;
	private BigDecimal valorCombustivel;
	private BigDecimal valorLiquido;
	private BigDecimal RealPorKm;
	
	public DiariaMotoristaResumo() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getDiasTrabalhados() {
		return diasTrabalhados;
	}
	public void setDiasTrabalhados(Integer diasTrabalhados) {
		this.diasTrabalhados = diasTrabalhados;
	}
	public Integer getKmsRodados() {
		return kmsRodados;
	}
	public void setKmsRodados(Integer kmsRodados) {
		this.kmsRodados = kmsRodados;
	}
	public BigDecimal getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}
	public BigDecimal getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(BigDecimal valorGasto) {
		this.valorCombustivel = valorGasto;
	}
	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public BigDecimal getRealPorKm() {
		return RealPorKm;
	}
	public void setRealPorKm(BigDecimal realPorKm) {
		RealPorKm = realPorKm;
	}
	@Override
	public String toString() {
		return "DiariaMotoristaResumo [diasTrabalhados=" + diasTrabalhados + ", kmsRodados=" + kmsRodados
				+ ", valorBruto=" + valorBruto + ", valorCombustivel=" + valorCombustivel + ", valorLiquido="
				+ valorLiquido + ", RealPorKm=" + RealPorKm + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
	

}
