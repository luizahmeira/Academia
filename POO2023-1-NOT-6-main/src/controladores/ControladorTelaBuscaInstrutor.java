package controladores;

import java.time.format.DateTimeFormatter;

import classes.Instrutor;
import telas.PanelBuscaAluno;
import telas.PanelBuscaInstrutor;
import telas.PanelMenu;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de busca
 *          de alunos.
 * 
 * @see PanelBuscaAluno
 */
public class ControladorTelaBuscaInstrutor {

	private PanelBuscaInstrutor tela;
	private Instrutor instrutor;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param panelBuscaInstrutor PanelBuscaAluno panel que chamou o controlador
	 */
	public ControladorTelaBuscaInstrutor(PanelBuscaInstrutor panelBuscaInstrutor) {
		this.tela = panelBuscaInstrutor;
	}

	/**
	 * Metodo que ira realizar algo caso algum botao seja pressionado na tela.
	 * 
	 * O usuario tem a funcao de voltar para o inicio do programa, Buscar um aluno,
	 * no qual ira extrair o nome do aluno que foi escrito e o buscara no banco de
	 * dados, Caso seja encontrado, o usuario pode deletar o aluno do banco de
	 * dados, ou edita-lo ultimo no qual ira leva-lo a outra tela.
	 * 
	 * @param e Object com as informacoes do botao precionado.
	 * @see Aluno
	 * @see ControladorRedirecionar
	 * @see PanelEditarAluno
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnBuscar()) {

			System.out.println(tela.getTextField().getText());
			instrutor = Instrutor.getUmInstrutor(tela.getTextField().getText());
			if (instrutor == null) {
				tela.getPanelNaoEncontrado().setVisible(true);
				tela.getPanelInfo().setVisible(false);
			} else {
				tela.getPanelNaoEncontrado().setVisible(false);
				alterarInformacoes();
				tela.getPanelInfo().setVisible(true);
			}

		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 * @see PanelMenu
	 */
	public void alterarInformacoes() {

		tela.getLblNome().setText("Nome:" + instrutor.getNome());
		// tela.getLblAltura().setText("Altura:\r" + instrutor.getAltura());
		tela.getLblEndereco().setText("Endereço: " + instrutor.getEndereco());
		//tela.getLblPeso().setText("Peso:\r" + aluno.getPeso());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Converte LocalDate para String
		String dateString = instrutor.getDtNascimento().format(formatter);

		tela.getLblDataNasc().setText("Data de nascimento: " + dateString);
		tela.getLblEmail().setText("E-mail: " + instrutor.getEmail());
		tela.getLblGenero().setText("Gênero: " + instrutor.getGenero());
		tela.getLblArea().setText("Área: " + instrutor.getAreaA());
		tela.getLblCpf().setText("CPF: " + instrutor.getCpf());
		tela.getLblPersonal().setText("Personal: " + instrutor.getPersonalString());
		tela.getLblTelefone().setText("Telefone: " + instrutor.getTelefone());

	}
}
