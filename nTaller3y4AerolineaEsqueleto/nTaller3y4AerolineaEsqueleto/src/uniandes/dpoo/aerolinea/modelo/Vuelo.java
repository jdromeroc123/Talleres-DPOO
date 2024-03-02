package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifasTemporadaAlta;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta=ruta;
		this.avion =avion;
		this.fecha=fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}
	
	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public Map<String, Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		if (tiquetes.values().size() <= getAvion().getCapacidad()- cantidad)
		{
			CalculadoraTarifasTemporadaAlta calculadoraA = (CalculadoraTarifasTemporadaAlta) calculadora;
			double tarifaD = calculadoraA.calcularCostoBase(this, cliente)*calculadoraA.calcularPorcentajeDescuento(cliente)*1.28;
			int tarifaI = (int) tarifaD/1;
			for (int i =0; i<cantidad; i++)
			{
				Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifaI);
				tiquetes.put(nuevoTiquete.getCodigo(), nuevoTiquete);
			}
			return tarifaI*cantidad;
		}
		else
		{
			throw new VueloSobrevendidoException(this);
		}
	}
	
	public boolean equals(Object obj) {
		
		
		return false;
	}
	
	
}
