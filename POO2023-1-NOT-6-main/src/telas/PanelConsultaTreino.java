package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controladores.ControladorConsultaTreino;

/**
 * @author Mayara Cardoso Simões
 * 
 *         Classe em que e implementado a tela para consulta de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes" })
public class PanelConsultaTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTexto;
	private JPanel panelDesign;
	private JButton btnVoltar;
	private JButton btnVer;
	private JList listTreinos;
	private ControladorConsultaTreino controladorTela;
	private JPanel panelGeral;

	/**
	 * Construitor em que e gerado a tela de consulta de treino juntamente com seus
	 * componentes. Metodos atrelados aos botoes estao no backend
	 * 
	 * @see ControladorConsultaTreino
	 */
	public PanelConsultaTreino() {
		// Defino as caracteristicas basicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panelGeral = new JPanel();
		panelGeral.setBounds(0, 11, 529, 374);
		add(panelGeral);
		panelGeral.setLayout(null);

		// Defino o panel base das informacoes
		panel = new JPanel();
		panel.setBounds(0, 0, 529, 28);
		panelGeral.add(panel);
		panel.setBackground(new Color(224, 135, 186));
		panel.setAlignmentY(1.0f);
		panel.setLayout(null);

		// Defino a label de ajuda ao usuario
		lblTexto = new JLabel("Consultar Treinos");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(196, 7, 137, 14);
		panel.add(lblTexto);

		// Defino o panel de design inferior
		panelDesign = new JPanel();
		panelDesign.setBounds(0, 346, 527, 28);
		panelGeral.add(panelDesign);
		panelDesign.setLayout(null);
		panelDesign.setBackground(new Color(224, 135, 186));
		panelDesign.setAlignmentY(1.0f);

		// Defino o botao para retornar para o inicio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setBounds(146, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panelDesign.add(btnVoltar);

		// Defino o botao para visualizar informacoes do treino
		btnVer = new JButton("Ver");
		btnVer.setForeground(Color.BLACK);
		btnVer.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVer.setBackground(new Color(255, 255, 255));
		btnVer.setBounds(297, 0, 89, 28);
		btnVer.addActionListener(this);
		panelDesign.add(btnVer);

		// Defino a lista com os treinos no banco de dados
		listTreinos = new JList();
		listTreinos.setBounds(10, 39, 509, 297);
		panelGeral.add(listTreinos);
		listTreinos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o controlador que realiza a coneccao entre o backend e o frontend
		controladorTela = new ControladorConsultaTreino(this);
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

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JList getListTreinos() {
		return listTreinos;
	}

	public void setListTreinos(JList listTreinos) {
		this.listTreinos = listTreinos;
	}

	public JPanel getPanelGeral() {
		return panelGeral;
	}

	public void setPanelGeral(JPanel panelGeral) {
		this.panelGeral = panelGeral;
	}

}
