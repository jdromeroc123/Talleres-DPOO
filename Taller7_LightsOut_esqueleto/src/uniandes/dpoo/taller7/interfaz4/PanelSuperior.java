package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelSuperior extends JPanel implements ActionListener,ItemListener{
	 
	private JPanel panelIzquierdo = new JPanel();
	private JPanel panelDerecho = new JPanel();
	private JRadioButton facil = new JRadioButton("Fácil");
	private JRadioButton medio = new JRadioButton("Medio");
	private JRadioButton dificil = new JRadioButton("Dificil");
	
	private InterfazLightsOut interfazPrincipal;
	
	public PanelSuperior(InterfazLightsOut interfaz) {
		setLayout(new GridLayout(1, 2));
		
		panelIzquierdo.setLayout(new GridLayout(1, 2));
		
		interfazPrincipal = interfaz;
		
		JLabel tamaño = new JLabel("Tamaño", SwingConstants.CENTER);
		JComboBox<String> dimension = new JComboBox<String>();
		
		dimension.addItem("5x5");
		dimension.addItem("6x6");
		dimension.addItem("7x7");
		dimension.addItemListener(this);
		
		panelIzquierdo.add(tamaño);
		panelIzquierdo.add(dimension);
		add(panelIzquierdo);
		
		panelDerecho.setLayout(new GridLayout(1, 4));
		
		JLabel dificultad = new JLabel("Dificultad");
		facil.addActionListener(this);
		medio.addActionListener(this);
		dificil.addActionListener(this);
		facil.setFocusable(false);
		medio.setFocusable(false);
		dificil.setFocusable(false);
		medio.setSelected(true);
		medio.setEnabled(false);
		
		panelDerecho.add(dificultad);
		panelDerecho.add(facil);
		panelDerecho.add(medio);
		panelDerecho.add(dificil);
		
		add(panelDerecho);
		}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String dimension = e.getItem().toString();
		if (dimension.equals("5x5")) {
			interfazPrincipal.actualizarDimension(5);
		}else if (dimension.equals("6x6")) {
			interfazPrincipal.actualizarDimension(6);
		}else if (dimension.equals("7x7")) {
			interfazPrincipal.actualizarDimension(7);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if (accion.equals("Fácil")) {
			facil.setEnabled(false);
			medio.setEnabled(true);
			dificil.setEnabled(true);
			medio.setSelected(false);
			dificil.setSelected(false);
		}else if (accion.equals("Medio")) {

			facil.setEnabled(true);
			medio.setEnabled(false);
			dificil.setEnabled(true);
			facil.setSelected(false);
			dificil.setSelected(false);
		}else if (accion.equals("Dificil")) {
			facil.setEnabled(true);
			medio.setEnabled(true);
			dificil.setEnabled(false);
			facil.setSelected(false);
			medio.setSelected(false);
		}
	}

}
