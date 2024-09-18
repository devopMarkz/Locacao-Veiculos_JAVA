package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Cliente {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;
	
	// CONSTRUTORES
	
	public Cliente() {
	}
	
	public Cliente(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = LocalDate.now();
	}
	
	// GETTERS E SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	@Override
	public String toString() {
		return "Nome: " 
				+ this.nome
				+ " | Endereço: "
				+ this.endereco
				+ " | Telefone: "
				+ this.telefone
				+ " | E-mail: "
				+ this.email
				+ " | Data de Cadastro: "
				+ this.dataCadastro.format(fmt);
				
	}

}
