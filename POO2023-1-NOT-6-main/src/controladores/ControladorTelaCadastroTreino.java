package controladores;

import classes.Aluno;
import classes.GestaoAcademia;
import classes.Instrutor;
import classes.Treino;
import telas.PanelCadastroTreino;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de treino.
 * 
 * @see PanelCadastroTreino
 */

public class ControladorTelaCadastroTreino {

	private PanelCadastroTreino tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelCadastroTreino que chamou a tela
	 */
	public ControladorTelaCadastroTreino(PanelCadastroTreino tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar uma acao a cada vez que o usuario apertar um botao.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje cadastrar um
	 * treino, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem enviadas ao banco de dados, antes de efetivamente cadastrar o
	 * treino, e feito uma validacao para analisar se o campo de nome de treino esta
	 * vazio , se o treino ja esta cadastrado no sistema, se a lista de Exercicios
	 * esta vazia ou se nenhum aluno foi selecionado.Ha tambem a funcao para
	 * alternar oque o usuario vera na tela em questao, caso o botao exercicio seje
	 * apertado, o programa ira mostrar para o usuario elementos como a lista de
	 * exercicios compativeis com o grupamento do treino nos quais podera escolhar
	 * um numero de repeticoes e series, entretanto, caso deseje voltar para a tela
	 * inicial de cadastro de exercicio, o botao voltar deve ser acionado.
	 *
	 * 
	 * @param e Object contendo qual botao o usuario apertou
	 * @see Aluno
	 * @see Treino
	 * @see Exercicio
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getTextField().getText().isBlank() == false)
					&& (tela.getTextField().getText().isEmpty() == false)) {

				String instrutorNome = tela.getComboInstrutor().getSelectedItem().toString();

				String alunoNome = tela.getComboAluno().getSelectedItem().toString();

				for (Aluno aluno : GestaoAcademia.getAlunos()) {
					if (aluno.getNome() == alunoNome) {
						for (Instrutor instrutor : GestaoAcademia.getInstrutores()) {
							if (instrutor.getNome() == instrutorNome) {
								cadastrarTreino(instrutor, aluno, tela.getTextFieldNome().getText(),
										tela.getTextFieldDescricao().getText(), tela.getTextFieldExercicios().getText(),
										(int) tela.getSpinRep().getValue(), (int) tela.getSpinSerie().getValue());
							}

						}

					}
				}

				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain1().setVisible(true);
			tela.getPanelMain2().setVisible(false);
		}
	}

	/**
	 * Metodo responsavel por cadastrar o Treino.
	 * 
	 * E criado uma instancia de treino no qual sera utilizado o metodo de cadastro
	 * para envia-lo ao banco de dados, para ser criado a instancia, e utilizado a
	 * funcao parearTipos para realizar a conversao do id para o grupamento muscular
	 * correspondente. Logo apos, e realizado a anexacao do aluno ao treino
	 * cadastrado.
	 * 
	 * @param nome      String contendo o nome do treino
	 * @param tipos     Int contendo o id dos grupamentos musculares do treino
	 * @param nomeAluno String contendo o nome do aluno que recebera o treino
	 * @param nomes     List contendo o nome dos exercicios do treino
	 * @param nRep      Int contendo o numero de repeticoes do treino
	 * @param nSer      Int contendo o numero de series do treino
	 * 
	 * @see Treino
	 * @see Exercicio
	 * @see TipoDeGrupamento
	 * @see anexarTreino
	 */
	public void cadastrarTreino(Instrutor instrutor, Aluno aluno, String treino, String descricao, String exercicio,
			int serie, int repeticao) {

		Treino treinos = new Treino(instrutor, aluno, treino, descricao, exercicio, serie, repeticao);
		GestaoAcademia academia = new GestaoAcademia();

		academia.cadastrarTreino(treinos);
		
		System.out.println("==== Treino cadastrados ====");
		for (Treino treinocad : GestaoAcademia.getTreinos()) {
			System.out.println(treinocad);
			System.out.println("-----------------------------");
		}
	}


}
