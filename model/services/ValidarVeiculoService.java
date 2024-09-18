package model.services;

import model.entities.Locadora;
import model.entities.Veiculo;

public class ValidarVeiculoService {
	
	public static Veiculo validarVeiculo(String placa, Locadora locadora) {
		
		return locadora.getVeiculos().stream().filter(x -> x.getPlaca().equals(placa)).findFirst().orElseThrow();
		
	}

}
