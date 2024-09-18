package model.entities;

import java.time.Duration;
import java.time.LocalDate;

import model.entities.enums.StatusReserva;

public class Reserva {
	
	private Integer idReserva;
	private Cliente cliente;
	private Veiculo veiculo;
	private LocalDate dataReserva;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private StatusReserva statusReserva;
	
	// CONSTRUTORES
	
	public Reserva(Integer idReserva, Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, StatusReserva statusReserva) {
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataReserva = LocalDate.now();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.statusReserva = statusReserva;
	}

	// GETTERS E SETTERS

	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public LocalDate getDataReserva() {
		return dataReserva;
	}


	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public StatusReserva getStatusReserva() {
		return statusReserva;
	}


	public void setStatusReserva(StatusReserva statusReserva) {
		this.statusReserva = statusReserva;
	}


	public Integer getIdReserva() {
		return idReserva;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public LocalDate getDataFim() {
		return dataFim;
	}
	
	// MÉTODOS DA CLASSE
	
	public Double calcularValorTotal() {
		return Duration.between(dataInicio.atStartOfDay(), dataFim.atStartOfDay()).toDays() * veiculo.getTarifaDiaria();
	}
	
	public Integer calcularDiasReservados() {
		return Integer.valueOf(String.valueOf(Duration.between(dataInicio.atStartOfDay(), dataFim.atStartOfDay()).toDays()));
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", veiculo=" + veiculo + ", dataReserva="
				+ dataReserva + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", statusReserva="
				+ statusReserva + ", Valor Total=" + calcularValorTotal() + ", DiasReservados="
				+ calcularDiasReservados() + "]";
	}
	
	

}
