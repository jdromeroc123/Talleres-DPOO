package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDerecho extends JPanel implements ActionListener{

	private JButton nuevo = new JButton("NUEVO");
	private JButton reiniciar = new JButton("REINICIAR");
	private JButton top10 = new JButton("TOP-10");
	private JButton cambiarJugador = new JButton("CAMBIAR JUGADOR");
	
	private InterfazLightsOut interfazPrincipal;
	
	public PanelDerecho(InterfazLightsOut interfaz){
	
		setLayout(new GridLayout(3,1));
		
		interfazPrincipal = interfaz;
		
		JPanel panelVacioUno = new JPanel();
		add(panelVacioUno);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(7,1));
		nuevo.setFocusable(false);
		nuevo.addActionListener(this);
		panelBotones.add(nuevo);
		JPanel panelVacioIntermedioUno = new JPanel();
		panelBotones.add(panelVacioIntermedioUno);
		reiniciar.setFocusable(false);
		reiniciar.addActionListener(this);
		panelBotones.add(reiniciar);
		JPanel panelVacioIntermedioDos = new JPanel();
		panelBotones.add(panelVacioIntermedioDos);
		top10.setFocusable(false);
		top10.addActionListener(this);
		panelBotones.add(top10);
		JPanel panelVacioIntermedioTres = new JPanel();
		panelBotones.add(panelVacioIntermedioTres);
		cambiarJugador.setFocusable(false);
		cambiarJugador.addActionListener(this);
		panelBotones.add(cambiarJugador);
		
		add(panelBotones);

		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if (accion.equals("NUEVO")) {
			interfazPrincipal.nuevoTablero();
		}else if (accion.equals("REINICIAR")) {
			interfazPrincipal.reiniciarTablero();
		}else if (accion.equals("TOP-10")) {
			interfazPrincipal.mostrarTop10();
		}else if (accion.equals("CAMBIAR JUGADOR")) {
			String nuevoNombre = JOptionPane.showInputDialog(interfazPrincipal, "Escriba su nombre:", "Nuevo Jugador", -1);
			interfazPrincipal.actualizarJugador(nuevoNombre);
			
		}
	}
}
