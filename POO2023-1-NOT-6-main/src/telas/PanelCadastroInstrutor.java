package telas;
/***
 * @author Mayara Cardoso Simões
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorTelaCadastroAluno;
import controladores.ControladorTelaCadastroInstrutor;


import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;


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

public class PanelCadastroInstrutor extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
	private JPanel panel;
	private JPanel panelNome;
	private JLabel lblTitulo;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblPersonal;
	private JLabel lblInsiraOsDados;
	private JPanel faixaInferior;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private ControladorTelaCadastroInstrutor controladorTela;
	private JTextField endereco;
	private JTextField email;
	private JLabel lblArea;
	private JTextField area;
	private JLabel lblCpf;
	private JTextField cpf;
	private JComboBox<?>genero;
	private JTextField dtNascimento;
	private JTextField telefone;
	private JCheckBox chckbxPersonal;

	/**
	 * Construtor no qual cria a tela e suas dependencias, acao dos botoes atrelado
	 * ao BackEnd
	 * 
	 * @see ControladorTelaCadastroAluno
	 */
	
	public PanelCadastroInstrutor() {

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
		lblTitulo = new JLabel("Cadastro de Instrutor");
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
		lblPersonal = new JLabel("Personal:");
		lblPersonal.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblPersonal.setBounds(368, 194, 78, 17);
		panel.add(lblPersonal);

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
										
										lblArea = new JLabel("Área de atuação:");
										lblArea.setFont(new Font("Dialog", Font.PLAIN, 16));
										lblArea.setBounds(10, 297, 128, 26);
										panel.add(lblArea);
										
										area = new JTextField();
										area.setFont(new Font("Dialog", Font.PLAIN, 14));
										area.setColumns(10);
										area.setBounds(137, 297, 376, 25);
										panel.add(area);
										
										lblCpf = new JLabel("CPF:");
										lblCpf.setFont(new Font("Dialog", Font.PLAIN, 16));
										lblCpf.setBounds(10, 261, 99, 26);
										panel.add(lblCpf);
										
										cpf = new JTextField();
										cpf.setFont(new Font("Dialog", Font.PLAIN, 14));
										cpf.setColumns(10);
										cpf.setBounds(86, 263, 221, 25);
										panel.add(cpf);
										
										genero = new JComboBox();
										genero.setModel(new DefaultComboBoxModel(new String[] {"Selecione um gênero", "1- Feminino", "2- Masculino", "3- Outro", "4- Prefere não informar"}));
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
										
										chckbxPersonal = new JCheckBox("");
										chckbxPersonal.setBounds(436, 194, 26, 21);
										panel.add(chckbxPersonal);

		// Defino o controlador da tela que realizara a ligacao com o backend
		controladorTela = new ControladorTelaCadastroInstrutor(this);
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

	public JTextField getEndereco() {
		return endereco;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getObjetivo() {
		return area;
	}

	public JTextField getObservacao() {
		return cpf;
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

	public JTextField getArea() {
		return area;
	}

	public void setArea(JTextField area) {
		this.area = area;
	}

	public JTextField getCpf() {
		return cpf;
	}

	public void setCpf(JTextField cpf) {
		this.cpf = cpf;
	}

	public JCheckBox getChckbxNewCheckBox() {
		return chckbxPersonal;
	}

	public void setChckbxNewCheckBox(JCheckBox chckbxNewCheckBox) {
		this.chckbxPersonal = chckbxNewCheckBox;
	}
	
	
}
