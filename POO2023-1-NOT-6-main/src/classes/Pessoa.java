package classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 23245454L;
	private String nome;
	private LocalDate dtNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private char genero;

	public String teste_imprimir() {

		return "Nome: " + getNome() + ", Data Nascimento: " + getDtNascimento() + ", Endereço: " + getEndereco()
				+ ", Telefone: " + getTelefone() + ", Email: " + getEmail() + ", Gênero: " + getGenero();
	}

	public Pessoa(String nome, LocalDate dtNascimento, String endereco, String telefone, String email, char genero) {
		setNome(nome);
		setDtNascimento(dtNascimento);
		this.endereco = endereco;
		this.telefone = telefone;
		setEmail(email);
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() < 2) {
			throw new IllegalArgumentException("Nome inválido!");
		}
		this.nome = nome;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		int idade;
		idade = Period.between(dtNascimento, LocalDate.now()).getYears();
		if (idade < 14) {
			throw new IllegalArgumentException("Idade inválida, pessoa não pode ter menos de 14 anos!");
		}
		this.dtNascimento = dtNascimento;
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
		if (email.contains("@")) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("E-mail inválido!");
		}

	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	
	@Override
	public String toString() {
	    return "Nome: " + nome + "\n" +
	            "Data de Nascimento: " + dtNascimento + "\n" +
	            "Endereço: " + endereco + "\n" +
	            "Telefone: " + telefone + "\n" +
	            "Email: " + email + "\n" +
	            "Gênero: " + genero;
	}

	
	

}
