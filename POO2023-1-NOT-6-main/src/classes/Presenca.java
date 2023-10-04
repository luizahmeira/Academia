package classes;
import java.io.Serializable;
import java.time.LocalDate;

public class Presenca implements Serializable{
	private static final long serialVersionUID = 45896095860L;
	private Aluno aluno;
	private int frequencia;
	private LocalDate data;
	
	public Presenca(Aluno aluno, int frequencia, LocalDate data) {
		this.aluno = aluno;
		this.frequencia = frequencia;
		this.data = data;
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public int getFrequencia() {
		return frequencia;
	}


	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
	    return "Aluno: " + aluno.getNome() + "\n" +
	            "Frequência: " + frequencia + "\n" +
	            "Data: " + data;
	}


}
