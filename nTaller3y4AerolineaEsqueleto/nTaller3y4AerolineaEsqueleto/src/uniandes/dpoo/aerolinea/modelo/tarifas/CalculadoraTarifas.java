package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas{

	public double impuesto =0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		double tarifaD = calcularCostoBase(vuelo, cliente)*(1-calcularPorcentajeDescuento(cliente))*(1+impuesto);
		int tarifaI = (int) tarifaD/1;
		return tarifaI;
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		double valorDouble = costoBase*impuesto;
		int valorInt = (int) valorDouble/1;
		return valorInt;
	}
	
}
