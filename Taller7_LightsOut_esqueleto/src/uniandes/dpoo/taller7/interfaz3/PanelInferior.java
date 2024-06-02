package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel{
	
	JLabel jugadas = new JLabel("Jugadas");
	JTextField cantidadJugadas = new JTextField();
	JLabel jugador = new JLabel("Jugador");
	JTextField nombreJugador = new JTextField();
	
	public PanelInferior()
	{
		setLayout(new GridLayout(1,4));
		
		add(jugadas);
		
		cantidadJugadas.setEditable(false);
		cantidadJugadas.setText("0");
		add(cantidadJugadas);
		
		add(jugador);
		
		nombreJugador.setEditable(false);
		add(nombreJugador);
		
	}

}
