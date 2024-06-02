package uniandes.dpoo.taller7.interfaz1;

import javax.swing.*;
import java.awt.*;

public class InterfazLightsOut extends JFrame{

	public InterfazLightsOut()
	{
		setTitle("Juego de LightsOut");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new InterfazLightsOut();
	}
}
