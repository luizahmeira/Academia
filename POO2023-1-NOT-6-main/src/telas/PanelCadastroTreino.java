package telas;

import java.awt.Color;
import java.awt.Font;

import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import classes.Aluno;
import classes.Instrutor;
import controladores.ControladorTelaCadastroTreino;


/**
 * @author Mayara Cardoso Simões
 * 
 *         Classe em que e implementado a tela para cadastro de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PanelCadastroTreino extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6408302848948208845L;

	private ControladorTelaCadastroTreino controladorTela;
	private JTextField textFieldNome;
	private JComboBox comboAluno;
	private JList<String> listExerciciosTreino;
	private JPanel panel;
	private JPanel panelMain2;
	private JLabel lblTexto;
	private JPanel panelMain1;
	private JLabel lblMsgMain;
	private JPanel faixa;
	private JPanel faixa2;
	private JLabel lblAjudaNome;
	private JPanel panel2;
	private JLabel lblInsiraOsDados;
	private JLabel lblAjudaAluno;
	private JButton btnInicio;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private JTextField textFieldDescricao;
	private JLabel lblExercicios;
	private JTextField textFieldExercicios;
	private JLabel lblSeries;
	private JSpinner spinSerie;
	private JLabel lblRepeticoes;
	private JSpinner spinRep;
	private JComboBox comboInstrutor;

	/**
	 * Construtor que realiza a inicializacao da tela
	 * 
	 * @see ControladorTelaCadastroTreino
	 */
	public PanelCadastroTreino() {
		// Defino as caracteristicas base da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel utilizado como base da tela
		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino primeiro panel que aparecera para o usuario
		panelMain1 = new JPanel();
		panelMain1.setVisible(true);
		panelMain1.setBounds(0, 70, 529, 266);
		panel.add(panelMain1);
		panelMain1.setLayout(null);

		// Defino a mensagem principal da tela
		lblMsgMain = new JLabel("Cadastro de Treino");
		lblMsgMain.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblMsgMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgMain.setBounds(128, 33, 279, 26);
		panel.add(lblMsgMain);

		// Defino a faixa utilizada como design
		faixa = new JPanel();
		faixa.setBackground(new Color(224, 135, 186));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino a segunda faixa utilizada para design
		faixa2 = new JPanel();
		faixa2.setBackground(new Color(224, 135, 186));
		faixa2.setBounds(0, 349, 529, 31);
		panel.add(faixa2);
		faixa2.setLayout(null);

		// Defino o botao para retornar para o inicio
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(96, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(255, 255, 255));
		faixa2.add(btnInicio);

		// Defino o botao para retornar para o cadastrar
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(311, 0, 117, 31);
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.addActionListener(this);
		faixa2.add(btnCadastrar);

		// Defino a label para direcionar o usuario em relacao ao nome
		lblAjudaNome = new JLabel("Nome:");
		lblAjudaNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAjudaNome.setBounds(10, 37, 63, 26);
		panelMain1.add(lblAjudaNome);

		// Defino o terceiro panel de design
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(SystemColor.menu);
		panel2.setBounds(83, 37, 238, 26);
		panelMain1.add(panel2);

		// Defino textfield para inserir dados
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(10, 0, 222, 25);
		panel2.add(textFieldNome);

		// Defino combo para selecionar o aluno em que deve ser anexado o treino
		comboAluno = new JComboBox();
		comboAluno.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboAluno.setBounds(95, 113, 255, 26);
		comboAluno.setModel(new DefaultComboBoxModel<String>(Aluno.getTodosAlunos()));
		panelMain1.add(comboAluno);
		
		lblSeries = new JLabel("Séries:");
		lblSeries.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblSeries.setBounds(396, 82, 50, 20);
		panelMain1.add(lblSeries);
		
		spinSerie = new JSpinner();
		spinSerie.setBounds(454, 82, 65, 20);
		panelMain1.add(spinSerie);
		
		lblRepeticoes = new JLabel("Repetições:");
		lblRepeticoes.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblRepeticoes.setBounds(360, 34, 86, 29);
		panelMain1.add(lblRepeticoes);
		
		spinRep = new JSpinner();
		spinRep.setBounds(454, 43, 65, 20);
		panelMain1.add(spinRep);

		// Defino o label para direcionar usuario em relacao ao aluno
		lblAjudaAluno = new JLabel("Aluno:");
		lblAjudaAluno.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAjudaAluno.setBounds(10, 122, 75, 14);
		panelMain1.add(lblAjudaAluno);

		// Defino a label de ajuda
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(126, 0, 279, 26);
		panelMain1.add(lblInsiraOsDados);
		
		JLabel lblInstrutor = new JLabel("Instrutor:");
		lblInstrutor.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblInstrutor.setBounds(10, 150, 75, 14);
		panelMain1.add(lblInstrutor);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDescrio.setBounds(10, 76, 86, 26);
		panelMain1.add(lblDescrio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(93, 74, 257, 25);
		panelMain1.add(textFieldDescricao);
		
		lblExercicios = new JLabel("Exercícios:");
		lblExercicios.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblExercicios.setBounds(10, 190, 86, 26);
		panelMain1.add(lblExercicios);
		
		textFieldExercicios = new JTextField();
		textFieldExercicios.setColumns(10);
		textFieldExercicios.setBounds(93, 188, 257, 25);
		panelMain1.add(textFieldExercicios);
		
		comboInstrutor = new JComboBox();
		comboInstrutor.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboInstrutor.setBounds(95, 149, 255, 26);
		comboInstrutor.setModel(new DefaultComboBoxModel<String>(Instrutor.getTodosInstrutores()));
		panelMain1.add(comboInstrutor);

		// Defino o panel onde ficara a segunda parte de informacoes principais
		panelMain2 = new JPanel();
		panelMain2.setBounds(0, 61, 529, 277);
		panel.add(panelMain2);
		panelMain2.setVisible(false);
		panelMain2.setLayout(null);

		// Defino a label de ajuda na tela 2
		lblTexto = new JLabel("Selecione os exerc\u00EDcios desejados");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(100, 11, 361, 30);
		panelMain2.add(lblTexto);

		// Defino a lista onde estara os exercicios que devem ser selecionados
		listExerciciosTreino = new JList();
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBounds(27, 44, 338, 189);
		panelMain2.add(listExerciciosTreino);

		// Defino o botao para voltar
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(204, 244, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(255, 163, 100));
		btnVoltar.setForeground(Color.BLACK);
		panelMain2.add(btnVoltar);

		// Controlador que realiza a coneccao entre o front e o backend
		controladorTela = new ControladorTelaCadastroTreino(this);

	}

	/**
	 * Metodo responsavel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botao
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	// Getters e Setters
	public JTextField getTextField() {
		return textFieldNome;
	}

	public void setTextField(JTextField textField) {
		this.textFieldNome = textField;
	}

	public JList<String> getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList<String> listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}

	public JComboBox getComboAluno() {
		return comboAluno;
	}

	public JSpinner getSpinSerie() {
		return spinSerie;
	}

	public JSpinner getSpinRep() {
		return spinRep;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JPanel getPanelMain2() {
		return panelMain2;
	}

	public JPanel getPanelMain1() {
		return panelMain1;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldDescricao() {
		return textFieldDescricao;
	}

	public void setTextFieldDescricao(JTextField textFieldDescricao) {
		this.textFieldDescricao = textFieldDescricao;
	}

	public JTextField getTextFieldExercicios() {
		return textFieldExercicios;
	}

	public void setTextFieldExercicios(JTextField textFieldExercicios) {
		this.textFieldExercicios = textFieldExercicios;
	}

	public JComboBox getComboInstrutor() {
		return comboInstrutor;
	}

	public void setComboInstrutor(JComboBox comboInstrutor) {
		this.comboInstrutor = comboInstrutor;
	}

	
	
	
}
