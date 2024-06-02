package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class InterfazLightsOut extends JFrame{

	private PanelSuperior panelSuperior = new PanelSuperior();
	private PanelDerecho panelDerecho = new PanelDerecho();
	private PanelInferior panelInferior = new PanelInferior();
	private TableroInterfaz tablero = new TableroInterfaz();
	
	public InterfazLightsOut()
	{
		setTitle("Juego de LightsOut");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		add(panelSuperior, BorderLayout.NORTH);
		
		add(panelDerecho, BorderLayout.EAST);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		add(tablero, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new InterfazLightsOut();
	}
}
