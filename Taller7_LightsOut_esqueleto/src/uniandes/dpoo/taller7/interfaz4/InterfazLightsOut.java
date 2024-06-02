package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import uniandes.dpoo.taller7.modelo.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class InterfazLightsOut extends JFrame{
	
	private int dimension = 5;
	private int dificultad = 5; 
	private String nombre = "Jugador Nuevo";
	private int jugadas =0;
	
	private Top10 top10 = new Top10();
	private File carpeta;
	
	private Tablero juego = new Tablero(dimension);
	

	private PanelSuperior panelSuperior = new PanelSuperior(this);
	private PanelDerecho panelDerecho = new PanelDerecho(this);
	private PanelInferior panelInferior = new PanelInferior();
	private TableroInterfaz tablero;
	
	public InterfazLightsOut()
	{
		juego.desordenar(dificultad);
		tablero = new TableroInterfaz(juego.darTablero(), this);
		
		File ruta = new File("data\\top10.csv");
		carpeta= new File(ruta.getAbsolutePath());
		top10.cargarRecords(carpeta);
		
		setTitle("Juego de LightsOut");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
		
		add(panelSuperior, BorderLayout.NORTH);
		
		add(panelDerecho, BorderLayout.EAST);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		add(tablero, BorderLayout.CENTER);
		
	}
	
	public void actualizarDimension(int nDimension) {
		this.dimension= nDimension;
	}
	
	public void actualizarDificultad(String nDificultad) {
		if (nDificultad.equals("Fácil")) {
			this.dimension= 3;
		}else if (nDificultad.equals("Medio")) {
			this.dimension= 5;
		}else if (nDificultad.equals("Dificil")) {
			this.dimension= 8;
		}
		
	}
	
	public void nuevoTablero() {
		Tablero tableroNuevo = new Tablero(dimension);
		tableroNuevo.desordenar(dificultad);
		this.juego = tableroNuevo;
		tablero.setTablero(this.juego.darTablero());
		tablero.repaint();
	}
	
	public void reiniciarTablero() {
		this.juego.reiniciar();
		tablero.setTablero(this.juego.darTablero());
		this.actualizarJugadas(0);
		tablero.repaint();
	}
	
	public void mostrarTop10() {
		Collection<RegistroTop10> registros = top10.darRegistros();
		ArrayList<String> nombres = new ArrayList<String>();
		HashMap<String, Integer> nombrePuntaje = new HashMap<String, Integer>();  
		for (RegistroTop10 registro: registros) {
			nombres.add(registro.darNombre());
			nombrePuntaje.put(registro.darNombre(), registro.darPuntos());
		}
		JPanel panelLista = new JPanel();
		JList<Panel> listaTop10 = new JList<Panel>();
		JPanel top1 = new JPanel();
		top1.setBackground(Color.GRAY);
		top1.setFont(new Font("Comic Sans", Font.BOLD, 20 ));
		top1.setLayout(new GridLayout(3,1));
		JLabel numero1 = new JLabel();
		numero1.setText("1");
		JLabel nombre1 = new JLabel();
		nombre1.setText(nombres.get(0));
		JLabel puntaje1 = new JLabel();
		puntaje1.setText("" + nombrePuntaje.get(nombres.get(0)));
		listaTop10.add(top1);
		JDialog ventanaTop10 = new JDialog();
		ventanaTop10.setSize(400, 300);
		ventanaTop10.setVisible(true);
		ventanaTop10.setResizable(false);
		ventanaTop10.setTitle("Top 10");
		
		panelLista.add(listaTop10);
		ventanaTop10.add(panelLista);
		//jsp.setLocationRelativeTo(null);

		
		
		
	}
	
	public void actualizarJugador(String nombreJugador) {
		this.nombre = nombreJugador;
		panelInferior.actualizarNombre(nombreJugador);
	}
	
	public void actualizarJugadas(int jugadas) {
		String jugadasString = ""+jugadas;
		this.jugadas = jugadas;
		panelInferior.actualizarJugadas(jugadasString);
	}
	
	public void realizarJugada(int fila, int columna) {
		juego.jugar(fila, columna);
		tablero.setTablero(this.juego.darTablero());
		actualizarJugadas(juego.darJugadas());
		tablero.repaint();
		if(juego.tableroIluminado()) {
			top10.agregarRegistro(nombre, juego.calcularPuntaje());
			try {
				top10.salvarRecords(carpeta);
				int rta = JOptionPane.showConfirmDialog(this, "¿Quiere jugar de nuevo?",
						"Fin de la partida", JOptionPane.YES_NO_OPTION);
				if (rta == JOptionPane.OK_OPTION) {
					nuevoTablero();
				}
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new InterfazLightsOut();
	}
}
