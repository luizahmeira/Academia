package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorVerTreino;
import classes.Treino;

/**
 * @author Mayara Cardoso Simões
 * 
 *         Classe em que e implementado a tela para visualizar um treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes" })
public class PanelVerTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelBase;
	private JButton btnVoltar;
	private JLabel lblNome;
	private JLabel lblAluno;
	private JLabel lblSeries;
	private JLabel lblRepeticoes;
	private JLabel lblExercicios;
	private JTextArea textTipo;
	private ControladorVerTreino controladorTela;
	private JPanel panelBaseGeral;
	private JLabel lblInstrutor;
	private JLabel lblExercicio;

	/**
	 * Construitor em que e gerado a tela de visualizacao de treino juntamente com
	 * seus componentes. Metodos atrelados aos botoes estao no backend
	 * 
	 * @see ControladorVerTreino
	 */
	public PanelVerTreino(Treino treino) {
		// Defino caracteristicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel que e utilizado como base para todos os elementos
		panelBaseGeral = new JPanel();
		panelBaseGeral.setBounds(0, 11, 529, 374);
		add(panelBaseGeral);
		panelBaseGeral.setLayout(null);

		// Defino o panel que e utilizado como base para os botoes
		panelBase = new JPanel();
		panelBase.setBounds(0, 346, 527, 28);
		panelBaseGeral.add(panelBase);
		panelBase.setLayout(null);
		panelBase.setBackground(new Color(224, 135, 186));
		panelBase.setAlignmentY(1.0f);

		// Defino o botao para voltar para o inicio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setBounds(219, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panelBase.add(btnVoltar);

		// Defino o panel que e utilizado como base
		panel = new JPanel();
		panel.setBounds(0, 0, 529, 28);
		panelBaseGeral.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(224, 135, 186));
		panel.setAlignmentY(1.0f);

		// Defino o label onde sera inserido o nome
		lblNome = new JLabel();
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(122, 0, 290, 26);
		panel.add(lblNome);
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		// Defino o label onde sera inserido o aluno
		lblAluno = new JLabel();
		lblAluno.setBounds(10, 59, 254, 14);
		panelBaseGeral.add(lblAluno);
		lblAluno.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		
		lblInstrutor = new JLabel();
		lblInstrutor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInstrutor.setBounds(10, 132, 254, 14);
		panelBaseGeral.add(lblInstrutor);

		// Defino o label onde sera inserido o numero de series
		lblSeries = new JLabel();
		lblSeries.setBounds(10, 205, 254, 14);
		panelBaseGeral.add(lblSeries);
		lblSeries.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o label onde sera inserido o numero de repeticoes
		lblRepeticoes = new JLabel();
		lblRepeticoes.setBounds(10, 284, 254, 14);
		panelBaseGeral.add(lblRepeticoes);
		lblRepeticoes.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino a label indicando os exercicios
		lblExercicios = new JLabel("Exercicios:");
		lblExercicios.setBounds(274, 47, 110, 26);
		panelBaseGeral.add(lblExercicios);
		lblExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		
		lblExercicio = new JLabel("");
		lblExercicio.setVerticalTextPosition(SwingConstants.TOP);
		lblExercicio.setVerticalAlignment(SwingConstants.TOP);
		lblExercicio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExercicio.setBounds(363, 59, 156, 239);
		panelBaseGeral.add(lblExercicio);

		// Defino o label para receber o tipo do treino
		textTipo = new JTextArea();
		textTipo.setBounds(10, 110, 254, 43);
		panelBaseGeral.add(textTipo);
		textTipo.setLineWrap(true);
		textTipo.setBackground(panelBaseGeral.getBackground());
		textTipo.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		textTipo.setEditable(false);

		// Defino o controlador que realizara a coneccao entre o backend e o
		// frontend
		controladorTela = new ControladorVerTreino(this, treino);
		controladorTela.inicializar();

	}

	/**
	 * Metodo responsavel por conectar o backend e o frontend
	 * 
	 * @param e Evento no qual representa o clique de um botao
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorTela.acaoPerformada(e.getSource());
	}

	// Getters e Setters
	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblAluno() {
		return lblAluno;
	}

	public void setLblAluno(JLabel lblAluno) {
		this.lblAluno = lblAluno;
	}

	public JTextArea getTextTipo() {
		return textTipo;
	}

	public void setTextTipo(JTextArea textTipo) {
		this.textTipo = textTipo;
	}

	public JLabel getLblSeries() {
		return lblSeries;
	}

	public void setLblSeries(JLabel lblSeries) {
		this.lblSeries = lblSeries;
	}

	public JLabel getLblRepeticoes() {
		return lblRepeticoes;
	}

	public void setLblRepeticoes(JLabel lblRepeticoes) {
		this.lblRepeticoes = lblRepeticoes;
	}

	public JPanel getPanelBaseGeral() {
		return panelBaseGeral;
	}

	public void setPanelBaseGeral(JPanel panelBaseGeral) {
		this.panelBaseGeral = panelBaseGeral;
	}

	public JLabel getLblInstrutor() {
		return lblInstrutor;
	}

	public void setLblInstrutor(JLabel lblInstrutor) {
		this.lblInstrutor = lblInstrutor;
	}

	public JLabel getLblExercicio() {
		return lblExercicio;
	}

	public void setLblExercicio(JLabel lblExercicio) {
		this.lblExercicio = lblExercicio;
	}
	
	

}
