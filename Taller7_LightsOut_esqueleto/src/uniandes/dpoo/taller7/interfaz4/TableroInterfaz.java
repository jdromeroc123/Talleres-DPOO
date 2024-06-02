package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableroInterfaz extends JPanel implements MouseListener{

	private boolean[][] tablero;
	
	private InterfazLightsOut interfazPrincipal;
	
	public TableroInterfaz(boolean[][] tableroJuego, InterfazLightsOut interfaz) {
		this.tablero = tableroJuego;
		this.interfazPrincipal = interfaz;
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		int dimension = tablero.length;
		
		int particionX = 0;
		int particionY = 0;
		
		int tamañoX = getWidth();
		int tamañoY = getHeight();
		
		int dX = tamañoX/dimension -1;
		int dY = tamañoY/dimension -1 ;
		
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
				g2d.drawLine(0, particionY, tamañoX, particionY);
				g2d.drawLine(particionX, 0, particionX, tamañoY);
				particionY+=dY;
			}
			g2d.drawLine(0, particionY, tamañoX, particionY);
			particionX+=dX;
		}
		g2d.drawLine(particionX, 0, particionX, tamañoY);
		repaint();
		
	}

	
	public void setTablero(boolean[][] tableroJuego) {
		this.tablero = tableroJuego;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		interfazPrincipal.realizarJugada(casilla[1], casilla[0]);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
