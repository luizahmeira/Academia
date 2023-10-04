package telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorTelaBuscaAluno;
import controladores.ControladorTelaBuscaInstrutor;
import classes.Aluno;

/**
 * @author Mayara Cardoso Simões
 *
 *         Classe em que e implementada a tela de busca de aluno
 *         Herda a classe JPanel pra confeccionar a tela e implementa a
 *         interface ActionListener para a iteracao dos botoes
 *
 * @see JPanel
 * @see ActionListener
 */

public class PanelBuscaInstrutor extends JPanel implements ActionListener {

	Aluno aluno;
	private static final long serialVersionUID = 7399066554867365317L;
	private JTextField textFieldNome;
	private JLabel lblPersonal;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JPanel panelEstilo;
	private JLabel lblnaoEncont;
	private JPanel panelInfo;
	private JPanel panel;
	private JLabel iconeBusca;
	private JLabel lblTexto;
	private JPanel panelNaoEncontrado;
	private JButton btnBuscar;
	private JButton btnVoltar;
	private ControladorTelaBuscaInstrutor controladorTela;
	private JPanel panelbase;
	private JLabel lblEndereco;
	private JLabel lblDataNasc;
	private JLabel lblGenero;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblArea;

	/**
	 * Construitor em que e gerado a tela de busca de aluno juntamente com seus
	 * componentes. Metodos atrelados aos botoes estao no backend
	 * 
	 * @see ControladorTelaBuscaAluno
	 */
	public PanelBuscaInstrutor() {
		// Defino a borda, a cor de fundo, tamanho da tela e seu layout;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel utilizado como base da tela
		panelbase = new JPanel();
		panelbase.setBounds(0, 11, 528, 381);
		add(panelbase);
		panelbase.setLayout(null);

		// Defino o texto base no topo da tela
		lblTexto = new JLabel("Buscar instrutor");
		lblTexto.setBounds(184, 0, 185, 45);
		panelbase.add(lblTexto);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 20));

		// Defino o campo para digitar o nome do Aluno
		textFieldNome = new JTextField();
		textFieldNome.setBounds(59, 55, 366, 20);
		panelbase.add(textFieldNome);
		textFieldNome.setToolTipText("Digite o nome do aluno");
		textFieldNome.setColumns(10);

		// Defino aqui o icone de busca
		iconeBusca = new JLabel("");
		iconeBusca.setBounds(1, 30, 68, 58);
		panelbase.add(iconeBusca);
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		// Defino um panel para estilizar a tela
		panel = new JPanel();
		panel.setBounds(1, 7, 527, 28);
		panelbase.add(panel);
		panel.setBackground(new Color(224, 135, 186));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		// Defino o panel em que e anexado as informacoes
		panelInfo = new JPanel();
		panelInfo.setBounds(1, 92, 527, 261);
		panelbase.add(panelInfo);
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setVisible(false);
		panelInfo.setLayout(null);

		// Defino o campo de peso
		lblPersonal = new JLabel();
		lblPersonal.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPersonal.setBounds(50, 213, 426, 30);
		panelInfo.add(lblPersonal);
		
		lblEndereco = new JLabel();
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEndereco.setBounds(50, 186, 426, 30);
		panelInfo.add(lblEndereco);

		// Defino o campo de altura
		lblCpf = new JLabel();
		lblCpf.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblCpf.setBounds(50, 231, 426, 30);
		panelInfo.add(lblCpf);
		
		lblDataNasc = new JLabel();
		lblDataNasc.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDataNasc.setBounds(50, 24, 426, 30);
		panelInfo.add(lblDataNasc);
		
		lblGenero = new JLabel();
		lblGenero.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGenero.setBounds(50, 51, 426, 30);
		panelInfo.add(lblGenero);

		// Defino o campo de nome
		lblNome = new JLabel();
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(50, -3, 426, 30);
		panelInfo.add(lblNome);
		
		lblTelefone = new JLabel();
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setBounds(50, 105, 426, 30);
		panelInfo.add(lblTelefone);
		
		lblEmail = new JLabel();
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(50, 132, 426, 30);
		panelInfo.add(lblEmail);
		
		lblArea = new JLabel();
		lblArea.setFont(new Font("Dialog", Font.BOLD, 14));
		lblArea.setBounds(50, 159, 426, 30);
		panelInfo.add(lblArea);

		// Defino a tela base caso o aluno nao seja encontrado
		panelNaoEncontrado = new JPanel();
		panelNaoEncontrado.setBounds(1, 92, 527, 250);
		panelbase.add(panelNaoEncontrado);
		panelNaoEncontrado.setVisible(false);
		panelNaoEncontrado.setLayout(null);

		// Defino a escrita caso o aluno nao seja encontrado
		lblnaoEncont = new JLabel("Aluno N\u00E3o Encontrado!");
		lblnaoEncont.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblnaoEncont.setBounds(153, 118, 220, 14);
		panelNaoEncontrado.add(lblnaoEncont);

		// Defino um panel para estilizacao
		panelEstilo = new JPanel();
		panelEstilo.setBounds(1, 353, 527, 28);
		panelbase.add(panelEstilo);
		panelEstilo.setBackground(new Color(224, 135, 186));
		panelEstilo.setAlignmentY(1.0f);
		panelEstilo.setLayout(null);

		// Defino o botao para voltar para o inicio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.addActionListener(this);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(219, 0, 89, 28);
		panelEstilo.add(btnVoltar);

		// Defino o botao para buscar o aluno
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(435, 52, 89, 23);
		panelbase.add(btnBuscar);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		// controlador que liga o Frontend Com o Backend
		controladorTela = new ControladorTelaBuscaInstrutor(this);
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


	public JLabel getLblEndereco() {
		return lblEndereco;
	}

	public void setLblEndereco(JLabel lblEndereco) {
		this.lblEndereco = lblEndereco;
	}

	public JLabel getLblPeso() {
		return lblPersonal;
	}

	public void setLblPeso(JLabel lblPeso) {
		this.lblPersonal = lblPeso;
	}

	public JLabel getLblAltura() {
		return lblCpf;
	}

	public void setLblAltura(JLabel lblAltura) {
		this.lblCpf = lblAltura;
	}

	

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JPanel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public JPanel getPanelNaoEncontrado() {
		return panelNaoEncontrado;
	}

	public void setPanelNaoEncontrado(JPanel panelNaoEncontrado) {
		this.panelNaoEncontrado = panelNaoEncontrado;
	}

	public JPanel getPanelbase() {
		return panelbase;
	}

	public void setPanelbase(JPanel panelbase) {
		this.panelbase = panelbase;
	}

	public JLabel getLblDataNasc() {
		return lblDataNasc;
	}

	public void setLblDataNasc(JLabel lblDataNasc) {
		this.lblDataNasc = lblDataNasc;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}


	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblObservacao() {
		return lblArea;
	}

	public void setLblObservacao(JLabel lblObservacao) {
		this.lblArea = lblObservacao;
	}

	public JLabel getLblPersonal() {
		return lblPersonal;
	}

	public void setLblPersonal(JLabel lblPersonal) {
		this.lblPersonal = lblPersonal;
	}

	public JLabel getLblCpf() {
		return lblCpf;
	}

	public void setLblCpf(JLabel lblCpf) {
		this.lblCpf = lblCpf;
	}

	public JLabel getLblArea() {
		return lblArea;
	}

	public void setLblArea(JLabel lblArea) {
		this.lblArea = lblArea;
	}
	
	

}
