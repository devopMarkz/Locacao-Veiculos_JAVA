package model.entities;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {

	private String cpf;
	private LocalDate dataNascimento;
	
	// CONSTRUTORES
	
	public PessoaFisica(String nome, String endereco, String telefone, String email, String cpf, LocalDate dataNascimento) {
		super(nome, endereco, telefone, email);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	// GETTERS E SETTERS

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	
	
}
