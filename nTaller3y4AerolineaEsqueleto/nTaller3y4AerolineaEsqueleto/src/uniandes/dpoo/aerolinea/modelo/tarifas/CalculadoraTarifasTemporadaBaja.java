package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
	protected int COSTO_POR_KM_NATURAL=600;
	protected int COSTO_POR_KM_CORPORATIVO=900;
	protected double DESCUENTO_PEQ=0.02;
	protected double DESCUENTO_MEDIANAS=0.01;
	protected double DESCUENTO_GRANDES=0.02;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int costo;
		if (cliente.getTipoCliente().equals("Natural")) {
			costo = COSTO_POR_KM_NATURAL*this.calcularDistanciaVuelo(vuelo.getRuta());
		}
		else {
			costo = COSTO_POR_KM_CORPORATIVO*this.calcularDistanciaVuelo(vuelo.getRuta());
		}
		return costo;
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento=0.0;
		if (cliente.getTipoCliente().equals("Corporativo"))
		{
			ClienteCorporativo clienteC = (ClienteCorporativo) cliente;
			if(clienteC.getTamanoEmpresa()==1)
			{
				descuento =  this.DESCUENTO_PEQ;
			}
			else if (clienteC.getTamanoEmpresa()==2)
			{
				descuento =  this.DESCUENTO_MEDIANAS;
			}
			else if (clienteC.getTamanoEmpresa()==3)
			{
				descuento =  this.DESCUENTO_GRANDES;
			}
		
		}
		else
		{
			descuento = Math.random();	
		}
		return descuento;
	}

}
