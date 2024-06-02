package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel{
	 
	private JPanel panelIzquierdo = new JPanel();
	private JPanel panelDerecho = new JPanel();
	
	public PanelSuperior() {
		setLayout(new GridLayout(1, 2));
		
		panelIzquierdo.setLayout(new GridLayout(1, 2));
		
		JLabel tamaño = new JLabel("Tamaño", SwingConstants.CENTER);
		JComboBox<String> dimension = new JComboBox<String>();
		
		dimension.addItem("5x5");
		dimension.addItem("6x6");
		dimension.addItem("7x7");
		
		panelIzquierdo.add(tamaño);
		panelIzquierdo.add(dimension);
		add(panelIzquierdo);
		
		panelDerecho.setLayout(new GridLayout(1, 4));
		
		JLabel dificultad = new JLabel("Dificultad");
		JRadioButton facil = new JRadioButton("Fácil");
		JRadioButton medio = new JRadioButton("Medio");
		JRadioButton dificil = new JRadioButton("Dificil");
		
		panelDerecho.add(dificultad);
		panelDerecho.add(facil);
		panelDerecho.add(medio);
		panelDerecho.add(dificil);
		
		add(panelDerecho);
		}

}
