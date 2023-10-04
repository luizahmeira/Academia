package telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorTelaCadastroAluno;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

/**
 * @author Mayara Cardoso Simões
 * 
 *         Classe em que e implementado a tela para cadastro de aluno Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

public class PanelCadastroAluno extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
	private JPanel panel;
	private JPanel panelNome;
	private JPanel panelAltura;
	private JSpinner spinAltura;
	private JLabel lblTitulo;
	private JPanel panelPeso;
	private JSpinner spinPeso;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblInsiraOsDados;
	private JPanel faixaInferior;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private ControladorTelaCadastroAluno controladorTela;
	private JTextField endereco;
	private JTextField email;
	private JLabel lblObjetivo;
	private JTextField objetivo;
	private JLabel lblObservao;
	private JTextField observacao;
	private JComboBox<?> plano;
	private JComboBox<?>genero;
	private JTextField dtNascimento;
	private JTextField telefone;

	/**
	 * Construtor no qual cria a tela e suas dependencias, acao dos botoes atrelado
	 * ao BackEnd
	 * 
	 * @see ControladorTelaCadastroAluno
	 */
	@SuppressWarnings("removal")
	public PanelCadastroAluno() {

		// Defino as caracteristicas basicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel principal que e usado como base
		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino o campo que armazena o textNomeAluno
		panelNome = new JPanel();
		panelNome.setBackground(new Color(240, 240, 240));
		panelNome.setBounds(72, 107, 268, 31);
		panel.add(panelNome);
		panelNome.setLayout(null);

		// Defino o campo onde � inserido o nome do aluno
		textNomeAluno = new JTextField();
		textNomeAluno.setFont(new Font("Fira Code", Font.PLAIN, 14));
		textNomeAluno.setBounds(0, 0, 267, 31);
		panelNome.add(textNomeAluno);
		textNomeAluno.setColumns(10);

		// Defino o campo em que estara o titulo
		lblTitulo = new JLabel("Cadastro de Aluno");
		lblTitulo.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(125, 28, 279, 31);
		panel.add(lblTitulo);

		// Defino um panel para design da pagina
		faixa = new JPanel();
		faixa.setBackground(new Color(224, 135, 186));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino o campo onde sera colocado um texto de ajuda ao usuario em relacao ao
		// nome
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(10, 107, 63, 26);
		panel.add(lblNome);

		// Defino o campo onde sera colocado um texto de ajuda ao usuario em relacao a
		// idade
		lblIdade = new JLabel("Data de nascimento:");
		lblIdade.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblIdade.setBounds(10, 156, 145, 17);
		panel.add(lblIdade);

		// Defino o campo onde sera colocado um texto de ajuda ao usuario em relacao a
		// altura
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAltura.setBounds(368, 194, 55, 17);
		panel.add(lblAltura);

		// Defino o campo onde sera colocado um texto de ajuda ao usuario em relacao ao
		// peso
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblPeso.setBounds(368, 234, 55, 17);
		panel.add(lblPeso);

		// Defino o texto de ajuda principal
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		// Defino uma faixa inferior de design
		faixaInferior = new JPanel();
		faixaInferior.setBackground(new Color(224, 135, 186));
		faixaInferior.setBounds(0, 349, 529, 31);
		panel.add(faixaInferior);
		faixaInferior.setLayout(null);

		// Defino o botao para voltar ao in�cio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(98, 0, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(255, 255, 255));
		faixaInferior.add(btnVoltar);

		// Defino o botao para cadastro
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(313, 0, 117, 31);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBackground(new Color(255, 255, 255));
		faixaInferior.add(btnCadastrar);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEndereo.setBounds(10, 190, 78, 26);
		panel.add(lblEndereo);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		endereco.setColumns(10);
		endereco.setBounds(86, 190, 254, 25);
		panel.add(endereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTelefone.setBounds(298, 156, 66, 17);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblEmail.setBounds(10, 226, 78, 26);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Dialog", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(86, 226, 254, 25);
		panel.add(email);
		
				// Defino o spin que absorvera a altura
				spinAltura = new JSpinner();
				spinAltura.setBounds(441, 194, 55, 25);
				panel.add(spinAltura);
				spinAltura.setDoubleBuffered(true);
				spinAltura.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
				spinAltura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				spinAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
				spinAltura.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0E7, 5.0));
				
						// Defino o campo onde sera colocado o panel para inserir a altura
						panelAltura = new JPanel();
						panelAltura.setBounds(442, 196, 55, 25);
						panel.add(panelAltura);
						panelAltura.setLayout(null);
						
								// Defino o spin onde sera inserido peso do aluno
								spinPeso = new JSpinner();
								spinPeso.setBounds(442, 235, 55, 25);
								panel.add(spinPeso);
								spinPeso.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 1.0));
								spinPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
								
										// Defino o campo onde sera colocado o spin de peso
										panelPeso = new JPanel();
										panelPeso.setLayout(null);
										panelPeso.setBounds(443, 238, 55, 25);
										panel.add(panelPeso);
										
										lblObjetivo = new JLabel("Objetivo:");
										lblObjetivo.setFont(new Font("Dialog", Font.PLAIN, 16));
										lblObjetivo.setBounds(10, 262, 78, 26);
										panel.add(lblObjetivo);
										
										objetivo = new JTextField();
										objetivo.setFont(new Font("Dialog", Font.PLAIN, 14));
										objetivo.setColumns(10);
										objetivo.setBounds(86, 262, 254, 25);
										panel.add(objetivo);
										
										lblObservao = new JLabel("Observação:");
										lblObservao.setFont(new Font("Dialog", Font.PLAIN, 16));
										lblObservao.setBounds(10, 298, 99, 26);
										panel.add(lblObservao);
										
										observacao = new JTextField();
										observacao.setFont(new Font("Dialog", Font.PLAIN, 14));
										observacao.setColumns(10);
										observacao.setBounds(119, 298, 221, 25);
										panel.add(observacao);
										
										plano = new JComboBox();
										plano.setModel(new DefaultComboBoxModel(new String[] {"Selecione um plano", "Plano A", "Plano B"}));
										plano.setBounds(368, 299, 145, 31);
										panel.add(plano);
										
										genero = new JComboBox();
										genero.setModel(new DefaultComboBoxModel(new String[] {"Selecione um genero", "1- Feminino", "2- Masculino", "3- Outro", "4- Prefere não informar"}));
										genero.setBounds(368, 107, 145, 31);
										panel.add(genero);
										
										dtNascimento = new JTextField();
										dtNascimento.setFont(new Font("Dialog", Font.PLAIN, 14));
										dtNascimento.setColumns(10);
										dtNascimento.setBounds(165, 153, 123, 26);
										panel.add(dtNascimento);
										
										telefone = new JTextField();
										telefone.setFont(new Font("Dialog", Font.PLAIN, 14));
										telefone.setColumns(10);
										telefone.setBounds(368, 153, 145, 26);
										panel.add(telefone);

		// Defino o controlador da tela que realizara a ligacao com o backend
		controladorTela = new ControladorTelaCadastroAluno(this);
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

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JTextField getTextNomeAluno() {
		return textNomeAluno;
	}

	public JSpinner getSpinAltura() {
		return spinAltura;
	}

	public JSpinner getSpinPeso() {
		return spinPeso;
	}

	public JTextField getEndereco() {
		return endereco;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getObjetivo() {
		return objetivo;
	}

	public JTextField getObservacao() {
		return observacao;
	}

	public JComboBox<?> getPlano() {
		return plano;
	}
	public JComboBox<?> getGenero() {
		return genero;
	}

	public JTextField getDtNascimento() {
		return dtNascimento;
	}

	public JTextField getTelefone() {
		return telefone;
	}

	
	
}
