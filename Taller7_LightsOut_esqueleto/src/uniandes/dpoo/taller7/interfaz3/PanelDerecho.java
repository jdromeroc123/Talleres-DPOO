package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class PanelDerecho extends JPanel{

	private JButton nuevo = new JButton("NUEVO");
	private JButton reiniciar = new JButton("REINICIAR");
	private JButton top10 = new JButton("TOP-10");
	private JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
	
	public PanelDerecho(){
	
		setLayout(new GridLayout(3,1));
		
		JPanel panelVacioUno = new JPanel();
		add(panelVacioUno);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(7,1));
		nuevo.setFocusable(false);
		panelBotones.add(nuevo);
		JPanel panelVacioIntermedioUno = new JPanel();
		panelBotones.add(panelVacioIntermedioUno);
		reiniciar.setFocusable(false);
		panelBotones.add(reiniciar);
		JPanel panelVacioIntermedioDos = new JPanel();
		panelBotones.add(panelVacioIntermedioDos);
		top10.setFocusable(false);
		panelBotones.add(top10);
		JPanel panelVacioIntermedioTres = new JPanel();
		panelBotones.add(panelVacioIntermedioTres);
		cambiarJugador.setFocusable(false);
		panelBotones.add(cambiarJugador);
		
		add(panelBotones);

		}
}
