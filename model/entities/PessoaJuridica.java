package model.entities;

import java.time.LocalDate;

public class PessoaJuridica extends Cliente {

	private String cnpj;
	private String razaoSocial;
	private LocalDate dataFundacao;
	
	// CONSTRUTORES
	
	public PessoaJuridica(String nome, String endereco, String telefone, String email, String cnpj, LocalDate dataFundacao) {
		super(nome, endereco, telefone, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	
	// GETTERS E SETTERS

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
}
