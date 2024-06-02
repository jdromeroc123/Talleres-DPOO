package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class TableroInterfaz extends JPanel{

	private int dimension = 5;
	private boolean[][] tablero;
	
	public TableroInterfaz() {
	}
	
	@Override
	public void paint(Graphics g) {
		
		

		tablero = new boolean[dimension][dimension];
		for (int i = 0; i < tablero.length; i++)
			for (int ii = 0; ii < tablero.length; ii++)
			{
				tablero[i][ii] = true;
			}
		
		Graphics2D g2d = (Graphics2D) g;
		
		int particionX = 0;
		int particionY = 0;
		
		int tama�oX = getWidth();
		int tama�oY = getHeight();
		
		int dX = tama�oX/dimension -1;
		int dY = tama�oY/dimension -1 ;
		
		for (int i = 0; i<dimension; i++)
		{
			particionY = 0;
			for (int j = 0; j<dimension; j++)
			{
				g2d.setColor(Color.BLACK);
				if (tablero[i][j])
				{
					g2d.setColor(Color.YELLOW);
				}
				else
				{
					g2d.setColor(Color.GRAY);
				}
				g2d.fillRect(particionX, particionY, dX, dY);
				particionY+=dY;
			}
			particionX+=dX;
		}
		
		particionX = 0;
		particionY = 0;
		
		g2d.setColor(Color.BLACK);
		
		for (int i = 0; i<dimension; i++)
		{
			particionY = 0;
			for (int j = 0; j<dimension; j++)
			{
				g2d.drawLine(0, particionY, tama�oX, particionY);
				g2d.drawLine(particionX, 0, particionX, tama�oY);
				particionY+=dY;
			}
			g2d.drawLine(0, particionY, tama�oX, particionY);
			particionX+=dX;
		}
		g2d.drawLine(particionX, 0, particionX, tama�oY);
		repaint();
		
	}
}
