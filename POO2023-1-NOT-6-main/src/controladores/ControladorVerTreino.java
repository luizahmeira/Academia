package controladores;

import classes.Treino;
import telas.PanelVerTreino;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          consulta de treinos.
 * 
 * @see PanelVerTreino
 */

public class ControladorVerTreino {
	private PanelVerTreino tela;
	private Treino treino;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param tela PanelVerTreino panel que chamou o controlador
	 */
	public ControladorVerTreino(PanelVerTreino tela, Treino treino) {
		this.tela = tela;
		this.treino = treino;
	}

	/**
	 * Metodo que ira realizar uma acao para cada botao prescionado pelo usuario.
	 * 
	 * Caso o usuario deseje retornar ao inicio, apenas sera chamado o controlador
	 * redirecionar. Caso o usuario deseje editar algum treino, ele sera
	 * redirecionado para uma tela especifica para editar o aluno.
	 * 
	 * @param e Object contendo a informacoes do botao precionado
	 * 
	 * @see PanelEditarTreino
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		} 
	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 */
	public void inicializar() {
		tela.getLblNome().setText(treino.getTreino());
		tela.getLblInstrutor().setText("Instrutor: " + treino.getInstrutor().getNome());
		tela.getLblAluno().setText("Aluno: " + treino.getAluno().getNome());
		tela.getLblRepeticoes().setText("Repetições: " + treino.getRepeticao());
		tela.getLblSeries().setText("Series: " + treino.getSerie());
		tela.getLblExercicio().setText(treino.getExercicio());
	}
}
