package classes;

import java.io.Serializable;

public class Treino implements Serializable{

	private static final long serialVersionUID = 59685065L;
	private Instrutor instrutor;
	private Aluno aluno;
	private String treino;
	private String descricao;
	private String exercicio;
	private int serie;
	private int repeticao;
	
	public Treino(Instrutor instrutor, Aluno aluno, String treino, String descricao, String exercicio, int serie, int repeticao) {
		this.instrutor = instrutor;
		this.aluno = aluno;
		this.treino = treino;
		this.descricao = descricao;
		this.exercicio = exercicio;
		this.serie = serie;
		this.repeticao = repeticao;
	}
	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : GestaoAcademia.getTreinos()) {
			if (nome.equals(treinoComparado.getTreino())) {
				return treinoComparado;
			}
		}
		return null;
	}
	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getTreino() {
		return treino;
	}

	public void setTreino(String treino) {
		this.treino = treino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getExercicio() {
		return exercicio;
	}

	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}
	
	@Override
	public String toString() {
	    return "Instrutor: " + instrutor.getNome() + "\n" +
	            "Aluno: " + aluno.getNome() + "\n" +
	            "Treino: " + treino + "\n" +
	            "Descrição: " + descricao + "\n" +
	            "Exercício: " + exercicio + "\n" +
	            "Série: " + serie + "\n" +
	            "Repetição: " + repeticao;
	}
}
