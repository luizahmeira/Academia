package telas;

import controladores.ControladorMainLabel;

/**
 * @author Mayara Cardoso Simões
 * @version 1.0
 * 
 *          Classe responsável por inicializar o programa chamando o PanelMenu.
 * 
 * @see PanelMenu
 * @see ControladorMainLabel
 *
 */
public class Main {

	/**
	 * Metodo Main que instancia a classe Panel menu e a torna visivel;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelMenu frame = new PanelMenu("Sistema de Gestão de Academia");
		frame.setTitle("Vitality Gym");
		frame.setVisible(true);
		
		classes.Main.main(args);

	}

}
