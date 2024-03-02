package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{

	protected int VALOR_POR_KM =1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return VALOR_POR_KM*this.calcularDistanciaVuelo(vuelo.getRuta());
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return Math.random();
	}
}
