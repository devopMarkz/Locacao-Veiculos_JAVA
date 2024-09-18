package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.enums.CategoriaVeiculo;
import model.entities.enums.StatusReserva;
import model.entities.enums.TipoCambio;
import model.exceptions.CnpjCadastradoException;
import model.exceptions.CpfCadastradoException;
import model.exceptions.VeiculoIndisponivelException;

public class Locadora {
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Veiculo> veiculos = new ArrayList<>();
	private List<Reserva> reservas = new ArrayList<>();
	
	public Locadora() {
		clientes.add(new PessoaFisica("Marcos André", "Coroado, R. do Cobre", "98986063363", "marcosacs.2022@gmail.com", "61713947340", LocalDate.parse("2002-09-25")));
		clientes.add(new PessoaJuridica("Vitor Nascimento", "Maracanã", "98987653922", "vitor@gmail.com", "37282637328", LocalDate.parse("2003-09-25")));
		
		veiculos.add(new Carro("ptd7h5t", "Sedan", "Creed", 2022, CategoriaVeiculo.HATCH, 200.00, TipoCambio.AUTOMATICO));
		veiculos.add(new Carro("ptd7s4t", "Volvo", "Look", 2021, CategoriaVeiculo.SUV, 250.00, TipoCambio.AUTOMATICO));
	}
	
	// GETTERS E SETTERS
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	// MÉTODOS
	
	public void cadastrarClientes(Cliente cliente) throws CnpjCadastradoException, CpfCadastradoException{
		validarCadastro(cliente);
		clientes.add(cliente);
	}
	
	private void validarCadastro(Cliente cliente) throws CnpjCadastradoException, CpfCadastradoException{
		for (Cliente clienteDaClasse : clientes) {
			
			// VERIFICA SE É PESSOA FÍSICA PARA PODER CONVERTER AO OBJETO REFERENTE E COMPARAR OS CPFS
			if(cliente instanceof PessoaFisica pf) {
				if(clienteDaClasse instanceof PessoaFisica pfDaClasse) {
					if (pf.getCpf().equals(pfDaClasse.getCpf())) {
						throw new CpfCadastradoException("Já existe um CPF cadastrado para esta Pessoa Física.");
					}
				}
			}
			
			// VERIFICA SE É PESSOA JURÍDICA PARA PODER CONVERTER AO OBJETO REFERENTE E COMPARAR OS CPFS
			if(cliente instanceof PessoaJuridica pf) {
				if(clienteDaClasse instanceof PessoaJuridica pfDaClasse) {
					if (pf.getCnpj().equals(pfDaClasse.getCnpj())) {
						throw new CnpjCadastradoException("Já existe um CPF cadastrado para esta Pessoa Física.");
					}
				}
			}
			
		}
	}
	
// ERAM UTILIZADOS PARA CHECAR SE O CLIENTE SE TRATAVA DE PF OU PJ, MAS ELIMINAMOS COM "cliente instanceof PessoaFisica pf" E "cliente instanceof PessoaJuridica pf"
//	private Boolean isPessoaFisica(Cliente cliente) {
//		if(cliente instanceof PessoaFisica) return true;
//		return false;
//	}
//	
//	private Boolean isPessoaJuridica(Cliente cliente) {
//		if(cliente instanceof PessoaJuridica) return true;
//		return false;
//	}

	public void efetuarReserva(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) throws VeiculoIndisponivelException {
		if(veiculoIsDisponivel(veiculo)) {
			reservas.add(new Reserva((reservas.size() + 1), cliente, veiculo, dataInicio, dataFim, StatusReserva.ATIVA));
			veiculo.setDisponivel(false);
		}
	}
	
	private Boolean veiculoIsDisponivel(Veiculo veiculo) throws VeiculoIndisponivelException {
		for (Veiculo veiculosDaClasse : veiculos) {
			if (veiculosDaClasse.equals(veiculo) && veiculosDaClasse.getDisponivel()) {
				return true;
			}
		}
		throw new VeiculoIndisponivelException("Veículo não está disponível ");
	}
	
	public void listarVeiculosDisponiveis() {
		for (Veiculo veiculo : veiculos) {
			if(veiculo.getDisponivel()) {
				System.out.println(veiculo);
			}
		}
	}
	
}
