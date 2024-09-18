package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.entities.Cliente;
import model.entities.Locadora;
import model.entities.Reserva;
import model.entities.Veiculo;
import model.exceptions.VeiculoIndisponivelException;
import model.services.ValidarClienteService;
import model.services.ValidarVeiculoService;

public class Program {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		try (Scanner sc = new Scanner(System.in)){
			
			Locadora locadora = new Locadora();
			
			System.out.print("Informe seu e-mail para poder efetuar a reserva: ");
			String email = sc.next();
			
			Cliente cliente = ValidarClienteService.validarCliente(email, locadora);
			
			System.out.print("Informe a placa do veículo que deseja reservar: ");
			String placa = sc.next();
			
			Veiculo veiculo = ValidarVeiculoService.validarVeiculo(placa, locadora);
			
			System.out.print("Informe a data de início da reserva (dd/MM/yyyy): ");
			LocalDate dataInicio = LocalDate.parse(sc.next(), fmt);
			
			System.out.print("Informe a data do fim da reserva (dd/MM/yyyy): ");
			LocalDate dataFinal = LocalDate.parse(sc.next(), fmt);
			
			locadora.efetuarReserva(cliente, veiculo, dataInicio, dataFinal);
			
			System.out.println("VEICULOS DISPONÍVEIS: ");
			locadora.listarVeiculosDisponiveis();
			
			System.out.println("-------------------------------------");
			
			for (Reserva reservas : locadora.getReservas()) {
				System.out.println(reservas);
			}
		} catch (VeiculoIndisponivelException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("E-mail ou Veículo inexistentes!");
		}
		
	}

}
