package model.entities;

import model.entities.enums.CategoriaVeiculo;

public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private Integer ano;
	private CategoriaVeiculo categoria;
	private Double tarifaDiaria;
	private Boolean disponivel;
	
	// CONSTRUTORES
	
	public Veiculo() {
	}
	
	public Veiculo(String placa, String marca, String modelo, Integer ano, CategoriaVeiculo categoria, Double tarifaDiaria) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.categoria = categoria;
		this.tarifaDiaria = tarifaDiaria;
		this.disponivel = true;
	}
	
	// GETTERS E SETTERS

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getTarifaDiaria() {
		return tarifaDiaria;
	}

	public void setTarifaDiaria(Double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public CategoriaVeiculo getCategoria() {
		return categoria;
	}
	
	// MÉTODOS DA CLASSE

	@Override
	public String toString() {
		return "[ placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", categoria="
				+ categoria + ", tarifaDiaria=" + tarifaDiaria + ", disponivel=" + disponivel;
	}
	
	

}
