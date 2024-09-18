package model.entities;

import model.entities.enums.CategoriaVeiculo;
import model.entities.enums.TipoCambio;

public class Carro extends Veiculo {
	
	private TipoCambio tipoCambio;
	
	// CONSTRUTORES
	
	public Carro(String placa, String marca, String modelo, Integer ano, CategoriaVeiculo categoria, Double tarifaDiaria, TipoCambio tipoCambio) {
		super(placa, marca, modelo, ano, categoria, tarifaDiaria);
		this.tipoCambio = tipoCambio;
	}
	
	// GETTERS E SETTERS

	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", tipo do cambio= " + this.tipoCambio + " ]";
	}

}
