package controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import classes.Aluno;
import classes.GestaoAcademia;
import classes.Instrutor;
import classes.Operacoes;
import classes.Plano;
import telas.PanelCadastroAluno;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de aluno.
 * 
 * @see PanelCadastroAluno
 */

public class ControladorTelaCadastroAluno {

	private PanelCadastroAluno tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelCadastroAluno que chamou a tela
	 */
	public ControladorTelaCadastroAluno(PanelCadastroAluno tela) {
		this.tela = tela;
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

				String planosel = tela.getPlano().getSelectedItem().toString();

				for (Plano plano : GestaoAcademia.getPlanos()) {
					if (plano.getPlano() == planosel) {
						

						cadastrarAluno(tela.getTextNomeAluno().getText(), dataNasc,
								(String) tela.getEndereco().getText(), (String) tela.getTelefone().getText(),
								(String) tela.getEmail().getText(), charValue, (double) tela.getSpinAltura().getValue(),
								(double) tela.getSpinPeso().getValue(), (String) tela.getObjetivo().getText(), plano,
								(String) tela.getObservacao().getText(), plano.getMensalidade());
						ControladorRedirecionar.caminho(1);
					}
				}
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
	public void cadastrarAluno(String nome, LocalDate dtNascimento, String endereco, String telefone, String email,
			char genero, double altura, double peso, String objetivo, Plano plano, String observacao,
			double valorPago) {
		try {
			Aluno aluno = new Aluno(nome, dtNascimento, endereco, telefone, email, genero, altura, peso, objetivo,
					plano, observacao, valorPago);
			System.out.println(nome + dtNascimento);
			GestaoAcademia academia = new GestaoAcademia();

			academia.cadastrarAluno(aluno);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("==== Alunos cadastrados ====");
		for (Aluno alunocad : GestaoAcademia.getAlunos()) {
			System.out.println(alunocad);
			System.out.println("-----------------------------");
		}
	}
}
