package model.services;

import model.entities.Cliente;
import model.entities.Locadora;

public class ValidarClienteService {
	
	public static Cliente validarCliente(String email, Locadora locadora) {
		
		return locadora.getClientes().stream().filter(x -> x.getEmail().equals(email)).findFirst().orElseThrow();
		
	}

}
