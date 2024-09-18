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

/**
 * A classe Locadora representa uma entidade que gerencia clientes, veículos e reservas.
 * 
 * <p> Ela possui métodos para cadastrar clientes, verificar a disponibilidade de veículos, 
 * efetuar reservas e listar veículos disponíveis.
 * 
 * @since 1.0
 */
public class Locadora {
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Veiculo> veiculos = new ArrayList<>();
	private List<Reserva> reservas = new ArrayList<>();
	
	/**
	 * Construtor padrao da locadora, que ja inicia cadastrando 2 clientes e 2 veiculos para fins de teste do sistema.
	 */
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
	
	/**
	 * Este metodo e responsavel por receber um cliente e cadastra-lo na lista de clientes da locadora.
	 * @param cliente - para ser adicionado a lista de clientes da locadora
	 * @throws CnpjCadastradoException Dispara uma excecao para o caso do CNPJ ja existir no cadastro de algum outro usuario.
	 * @throws CpfCadastradoException Dispara uma excecao para o caso do CPF ja existir no cadastro de algum outro usuario.
	 */
	public void cadastrarClientes(Cliente cliente) throws CnpjCadastradoException, CpfCadastradoException{
		validarCadastro(cliente);
		clientes.add(cliente);
	}
	
	/**
	 * Este metodo e responsavel por verificar se um cliente ja existe na lista de usuarios da locadora e assim, valida-lo.
	 * @param cliente - para passar pela validacao de usuario
	 * @throws CnpjCadastradoException Dispara uma excecao para o caso do CNPJ ja existir no cadastro de algum outro usuario.
	 * @throws CpfCadastradoException Dispara uma excecao para o caso do CPF ja existir no cadastro de algum outro usuario.
	 */
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
			
			// VERIFICA SE É PESSOA JURÍDICA PARA PODER CONVERTER AO OBJETO REFERENTE E COMPARAR OS CNPJS
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

	/**
	 * Este metodo e responsavel por instanciar um objeto do tipo Reserva e adiciona-lo a lista de reservas da locadora, guardando ao registro do aluguel
	 * @param cliente - O cliente que esta efetuando a reserva
	 * @param veiculo - O veiculo que esta sendo reservado
	 * @param dataInicio - A data em que o aluguel ira iniciar
	 * @param dataFim - A data em que o aluguel ira finalizar
	 * @throws VeiculoIndisponivelException Dispara uma excecao para o caso do veiculo nao estar disponivel para reserva
	 */
	public void efetuarReserva(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) throws VeiculoIndisponivelException {
		if(veiculoIsDisponivel(veiculo)) {
			reservas.add(new Reserva((reservas.size() + 1), cliente, veiculo, dataInicio, dataFim, StatusReserva.ATIVA));
			veiculo.setDisponivel(false);
		}
	}
	
	/**
	 * Este metodo e responsavel por verificar se o veiculo esta ou nao disponivel para reserva
	 * @param veiculo - O veiculo que sera verificado
	 * @return True - Caso o veiculo esteja disponivel, retorna um valor booleano verdadeiro
	 * @throws VeiculoIndisponivelException Dispara uma excecao para o caso do veiculo nao estar disponivel para reserva
	 */
	private Boolean veiculoIsDisponivel(Veiculo veiculo) throws VeiculoIndisponivelException {
		for (Veiculo veiculosDaClasse : veiculos) {
			if (veiculosDaClasse.equals(veiculo) && veiculosDaClasse.getDisponivel()) {
				return true;
			}
		}
		throw new VeiculoIndisponivelException("Veículo não está disponível ");
	}
	
	/**
	 * Este metodo e responsavel por listar todos os veiculos disponiveis da lista de veiculos que a locadora possui.
	 */
	public void listarVeiculosDisponiveis() {
		for (Veiculo veiculo : veiculos) {
			if(veiculo.getDisponivel()) {
				System.out.println(veiculo);
			}
		}
	}
	
}
