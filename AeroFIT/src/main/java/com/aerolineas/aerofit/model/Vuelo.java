package com.aerolineas.aerofit.model;


import java.util.ArrayList;

public class Vuelo {
	private Integer numeroDeVuelo;
	private Integer capacidadDeVuelo;
	private ArrayList<Venta> ventas;

	
	public Vuelo(Integer numeroDeVuelo,Integer capacidadDeVuelo) {
		this.capacidadDeVuelo=capacidadDeVuelo;
		this.numeroDeVuelo=numeroDeVuelo;
		this.ventas=new ArrayList<Venta>();
	}
	
	public Integer getNumeroDeVuelo() {
		return this.numeroDeVuelo;
	}
	public void setNumeroDeVuelo(Integer numeroDeVuelo) {
		this.numeroDeVuelo = numeroDeVuelo;
	}
	public Integer getCapacidadDeVuelo() {
		return this.capacidadDeVuelo;
	}
	public void setCapacidadDeVuelo(Integer capacidadDeVuelo) {
		this.capacidadDeVuelo = capacidadDeVuelo;
	}
	public ArrayList<Venta> getVentas() {
		return this.ventas;
	}
	public void setVentas(Venta venta) {
			this.ventas.add(venta);
	}
	
}
