package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Aluno extends Pessoa implements Serializable {

	public static final long serialVersionUID = 6893483L;
	
	private double altura;
	private double peso;
	private String objetivo;
	private Plano plano;
	private String observacao;
	private double valorPago;

	public Aluno(String nome, LocalDate dtNascimento, String endereco, String telefone, String email, char genero,
			double altura, double peso, String objetivo, Plano plano, String observacao, double valorPago) {
		super(nome, dtNascimento, endereco, telefone, email, genero);
		setAltura(altura);
		setPeso(peso);
		setObjetivo(objetivo);
		setPlano(plano);
		setObservacao(observacao);
		setValorPago(valorPago);
	}
	public static Aluno getUmAluno(String nome) {

		for (Aluno alunoComparado : GestaoAcademia.getAlunos()) {
			
			if (nome.equals(alunoComparado.getNome())) {
				return alunoComparado;
			}
		}
		return null;
	}
	public static String[] getTodosAlunos() {
		String retornoAluno[] = new String[GestaoAcademia.getAlunos().size()];
		for (int i = 0; i < GestaoAcademia.getAlunos().size(); i++) {
			retornoAluno[i] = GestaoAcademia.getAlunos().get(i).getNome();
		}
		return retornoAluno;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		if (altura <= 0) {
			throw new IllegalArgumentException("Altura não pode ser menor ou igual a 0!");
		}
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso <= 0) {
			throw new IllegalArgumentException("Peso não pode ser menor ou igual a 0!");
		}
		this.peso = peso;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		if (objetivo.length() < 2) {
			throw new IllegalArgumentException("Objetivo inválido!");
		}
		this.objetivo = objetivo;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		if (observacao.length() < 2) {
			throw new IllegalArgumentException("Observação inválida!");
		}
		this.observacao = observacao;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
	    if (valorPago != plano.getMensalidade()) {
	        throw new IllegalArgumentException("Mensalidade inválida!!");
	    }
	    	this.valorPago = valorPago;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
			"Altura: " + altura + "\n" +
			"Peso: " + peso + "\n" +
			"Objetivo: " + objetivo + "\n" +
			"Plano: " + plano.getPlano() + "\n" +
			"Observação: " + observacao + "\n" +
			"Mensalidade: " + plano.getMensalidade() + "\n" +
			"Valor Pago: " + valorPago;
	}

}
