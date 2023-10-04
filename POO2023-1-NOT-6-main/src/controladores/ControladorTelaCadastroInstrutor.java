package controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import classes.Instrutor;
import classes.GestaoAcademia;
import classes.Operacoes;
import telas.PanelCadastroInstrutor;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de instrutor.
 * 
 * @see PanelCadastroinstrutor
 */

public class ControladorTelaCadastroInstrutor {

	private PanelCadastroInstrutor tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param panelCadastroInstrutor PanelCadastroAluno que chamou a tela
	 */
	public ControladorTelaCadastroInstrutor(PanelCadastroInstrutor panelCadastroInstrutor) {
		this.tela = panelCadastroInstrutor;
	}

	/**
	 * Metodo que ira realizar uma acao a cada vez que o usuario apertar um botao.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje cadastrar um
	 * aluno, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem enviadas ao banco de dados, antes de efetivamente cadastrar o
	 * aluno, E feito uma validacao para analisar se o campo de nome de aluno esta
	 * vazio ou se o aluno ja esta cadastrado no sistema.
	 *
	 * 
	 * @param e Object contendo qual botao o usuario apertou
	 * @see Aluno
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if (((tela.getTextNomeAluno().getText().isEmpty() == false)
					&& (tela.getTextNomeAluno().getText().isBlank() == false))) {

				String dateString = tela.getDtNascimento().getText();

				// Define o formato da data desejado
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				// Faz a conversão da String para LocalDate
				LocalDate dataNasc = LocalDate.parse(dateString, formatter);

				String selectedValue = (String) tela.getGenero().getSelectedItem();
				char charValue = selectedValue.charAt(0);

				if (charValue == '1') {
					charValue = 'F';
				} else if (charValue == '2') {
					charValue = 'M';
				} else if (charValue == '3') {
					charValue = 'O';
				} else if (charValue == '4') {
					charValue = 'N';
				}

				cadastrarInstrutor(tela.getTextNomeAluno().getText(), dataNasc, (String) tela.getEndereco().getText(),
						(String) tela.getTelefone().getText(), (String) tela.getEmail().getText(), charValue,
						tela.getArea().getText(), tela.getCpf().getText(), tela.getChckbxNewCheckBox().isSelected());
				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Metodo responsavel por cadastrar o aluno.
	 * 
	 * E criado uma instancia de aluno no qual sera utilizado o metodo de cadastro
	 * para envia-lo ao banco de dados
	 * 
	 * @param nome   String contendo o nome do aluno
	 * @param idade  Int contendo a idade do aluno
	 * @param altura Double contendo a altura do aluno
	 * @param peso   Double contendo o peso do aluno
	 * @see Aluno
	 * @see Operacoes
	 */
	public void cadastrarInstrutor(String nome, LocalDate dtNascimento, String endereco, String telefone, String email,
			char genero, String areaA, String cpf, boolean personal) {
		try {
			Instrutor instrutor = new Instrutor(nome, dtNascimento, endereco, telefone, email, genero, areaA, cpf,
					personal);
			System.out.println(nome + dtNascimento);
			GestaoAcademia academia = new GestaoAcademia();

			academia.cadastrarInstrutor(instrutor);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("==== Alunos cadastrados ====");
		for (Instrutor instrutorcad : GestaoAcademia.getInstrutores()) {
			System.out.println(instrutorcad);
			System.out.println("-----------------------------");
		}
	}
}
