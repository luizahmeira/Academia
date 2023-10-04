package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import classes.Aluno;
import classes.GestaoAcademia;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

/**
 * @author Mayara Cardoso Simões
 * 
 *         Classe que implementa a tela incial com informacoes basicas do
 *         programa. Herda JPanel para criar a interface grafica
 * 
 * @see JPanel
 **/

public class PanelInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtAlunos;
	private JTextField txtTreinos;
	private JLabel lblBoasVindas;
	private JPanel panel;
	private JLabel lblAlunoinc;
	private JTextPane txtpBase;
	private JPanel panelBase;
	private JLabel iconTreino;
	private JTextPane txtpnCliqueEmTreino;
	private JPanel panelBase1;
	private JTextField textField;
	private JLabel txtTreinador;

	/**
	 * Construtor que cria a tela e suas caracterasticas
	 */
	public PanelInicio() {
		setForeground(new Color(97, 16, 61));
		// Defino a borda, a cor de fundo, tamanho da tela e seu layout;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Mensagem de boas Vindas
		lblBoasVindas = new JLabel("Vitality Gym");
		lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoasVindas.setFont(new Font("Segoe UI Light", Font.BOLD, 26));
		lblBoasVindas.setBounds(99, 31, 330, 52);
		add(lblBoasVindas);

		// Defino o JPanel que serve como base para os demais componentes da classe
		panel = new JPanel();
		panel.setBackground(new Color(234, 172, 207));
		panel.setBounds(10, 94, 162, 260);
		add(panel);
		panel.setLayout(null);

		// Defino o icone das informacoes dos alunos
		lblAlunoinc = new JLabel("");
		lblAlunoinc.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/do-utilizador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblAlunoinc.setBounds(61, 23, 40, 46);
		panel.add(lblAlunoinc);

		// Defino o texto contendo o titulo para alunos
		txtAlunos = new JTextField();
		txtAlunos.setEditable(false);
		txtAlunos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlunos.setText("Alunos");
		txtAlunos.setBounds(32, 69, 98, 27);
		panel.add(txtAlunos);
		txtAlunos.setColumns(10);

		// Defino o texto para as operacoes com alunos
		txtpBase = new JTextPane();
		txtpBase.setEditable(false);
		txtpBase.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpBase.setText("Clique em alunos para ser redirecionado ao campo de cadastro e listagem de alunos");
		txtpBase.setBounds(10, 125, 142, 94);
		panel.add(txtpBase);

		// Primeiro Panel usado como base grafica
		panelBase = new JPanel();
		panelBase.setBackground(new Color(234, 172, 207));
		panelBase.setBounds(182, 94, 162, 260);
		add(panelBase);
		panelBase.setLayout(null);

		txtTreinador = new JLabel("");
		txtTreinador.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/treinador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		txtTreinador.setBounds(61, 21, 40, 46);
		panelBase.add(txtTreinador);

		// Defino o texto contendo o titulo para treinos
		txtTreinos = new JTextField();
		txtTreinos.setEditable(false);
		txtTreinos.setText("Instrutores");
		txtTreinos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtTreinos.setColumns(10);
		txtTreinos.setBounds(32, 69, 98, 27);
		panelBase.add(txtTreinos);

		// Defino o texto para as operacoes com Treino
		txtpnCliqueEmTreino = new JTextPane();
		txtpnCliqueEmTreino.setEditable(false);
		txtpnCliqueEmTreino.setText(
				"Clique em instrutores para ser redirecionado ao campo de cadastro e listagem dos instrutores");
		txtpnCliqueEmTreino.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpnCliqueEmTreino.setBounds(10, 125, 142, 94);
		panelBase.add(txtpnCliqueEmTreino);

		// Defino aqui os segundo panel utilizado como base
		panelBase1 = new JPanel();
		panelBase1.setBackground(new Color(234, 172, 207));
		panelBase1.setBounds(354, 94, 162, 260);
		add(panelBase1);
		panelBase1.setLayout(null);

		JTextPane txtpnCliqueEmTreino_1 = new JTextPane();
		txtpnCliqueEmTreino_1.setAlignmentY(Component.TOP_ALIGNMENT);
		txtpnCliqueEmTreino_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtpnCliqueEmTreino_1
				.setText("Clique em treino para ser redirecionado ao campo de cadastro e listagem de treinos");
		txtpnCliqueEmTreino_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtpnCliqueEmTreino_1.setEditable(false);
		txtpnCliqueEmTreino_1.setBounds(10, 126, 142, 94);
		panelBase1.add(txtpnCliqueEmTreino_1);

		textField = new JTextField();
		textField.setText("Treinos");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(32, 72, 98, 27);
		panelBase1.add(textField);

		// Defino aqui o icone de Treino
		iconTreino = new JLabel("");
		iconTreino.setBounds(61, 16, 40, 46);
		panelBase1.add(iconTreino);
		iconTreino.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PanelMenu.class.getResource("/Imagens/exercicios-de-alongamento.png"))
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		JButton btnNewButton = new JButton("Registrar presença");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alunoNome = JOptionPane.showInputDialog("Digite o nome do aluno:");
				for (Aluno aluno : GestaoAcademia.getAlunos()) {
					if (aluno.getNome() == alunoNome) {
						GestaoAcademia academia = new GestaoAcademia();
						academia.realizarPresenca(aluno, 1, LocalDate.now());
					}
				}
				if (alunoNome != null) {
		            // Exibe uma caixa de diálogo com o valor inserido
		            JOptionPane.showMessageDialog(null, "Presença inserida para o aluno: " + alunoNome);
		        } else {
		            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
		        }
			}
		});
		btnNewButton.setBounds(354, 365, 162, 23);
		add(btnNewButton);
	}
}
